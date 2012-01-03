package net.minecraft.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// lightstone start
import java.util.Random;
import org.unxoft.lightstone.CraftChunk;
import org.unxoft.lightstone.util.LongHashset;
import org.unxoft.lightstone.util.LongHashtable;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.generator.BlockPopulator;
// lightstone end

public class ChunkProviderServer implements IChunkProvider {

    // lightstone start
    public LongHashset unloadQueue = new LongHashset();
    public Chunk emptyChunk;
    public IChunkProvider chunkProvider; // lightstone
    private IChunkLoader e;
    public boolean forceChunkLoad = false;
    public LongHashtable<Chunk> chunks = new LongHashtable<Chunk>();
    public List chunkList = new ArrayList();
    public WorldServer world;
    // lightstone end

    public ChunkProviderServer(WorldServer worldserver, IChunkLoader ichunkloader, IChunkProvider ichunkprovider) {
        this.emptyChunk = new EmptyChunk(worldserver, new byte[256 * worldserver.height], 0, 0);
        this.world = worldserver;
        this.e = ichunkloader;
        this.chunkProvider = ichunkprovider;
    }

    public boolean isChunkLoaded(int i, int j) {
        return this.chunks.containsKey(i, j); // lightstone
    }

    public void queueUnload(int i, int j) {
        if (this.world.worldProvider.c()) {
            ChunkCoordinates chunkcoordinates = this.world.getSpawn();
            int k = i * 16 + 8 - chunkcoordinates.x;
            int l = j * 16 + 8 - chunkcoordinates.z;
            short short1 = 128;

            if (k < -short1 || k > short1 || l < -short1 || l > short1 || !(this.world.keepSpawnInMemory)) { // lightstone - added 'this.world.keepSpawnInMemory'
                this.unloadQueue.add(i, j); // lightstone
            }
        } else {
            this.unloadQueue.add(i, j); // lightstone
        }
    }

    public Chunk getChunkAt(int i, int j) {
        // lightstone start
        this.unloadQueue.remove(i, j);
        Chunk chunk = (Chunk) this.chunks.get(i, j);
        boolean newChunk = false;
        // lightstone end

        if (chunk == null) {
            chunk = this.loadChunk(i, j);
            if (chunk == null) {
                if (this.chunkProvider == null) {
                    chunk = this.emptyChunk;
                } else {
                    chunk = this.chunkProvider.getOrCreateChunk(i, j);
                }
                newChunk = true; // lightstone
            }

            this.chunks.put(i, j, chunk); // lightstone
            this.chunkList.add(chunk);
            if (chunk != null) {
                chunk.loadNOP();
                chunk.addEntities();
            }

            // lightstone start
            org.bukkit.Server server = this.world.getServer();
            if (server != null) {
                /*
                 * If it's a new world, the first few chunks are generated inside
                 * the World constructor. We can't reliably alter that, so we have
                 * no way of creating a CraftWorld/CraftServer at that point.
                 */
                server.getPluginManager().callEvent(new ChunkLoadEvent(chunk.bukkitChunk, newChunk));
            }
            // lightstone end

            chunk.a(this, this, i, j);
        }

        return chunk;
    }

    public Chunk getOrCreateChunk(int i, int j) {
        // lightstone start
        Chunk chunk = (Chunk) this.chunks.get(i, j);

        chunk = chunk == null ? (!this.world.isLoading && !this.forceChunkLoad ? this.emptyChunk : this.getChunkAt(i, j)) : chunk;
        if (chunk == this.emptyChunk) return chunk;
        if (i != chunk.x || j != chunk.z) {
            MinecraftServer.log.severe("Chunk (" + chunk.x + ", " + chunk.z + ") stored at  (" + i + ", " + j + ") in world '" + world.getWorld().getName() + "'");
            MinecraftServer.log.severe(chunk.getClass().getName());
            Throwable ex = new Throwable();
            ex.fillInStackTrace();
            ex.printStackTrace();
        }
        return chunk;
        // lightstone end
    }

    public Chunk loadChunk(int i, int j) { // lightstone - private -> public
        if (this.e == null) {
            return null;
        } else {
            try {
                Chunk chunk = this.e.a(this.world, i, j);

                if (chunk != null) {
                    chunk.t = this.world.getTime();
                }

                return chunk;
            } catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
    }

    public void saveChunkNOP(Chunk chunk) { // lightstone - private -> public
        if (this.e != null) {
            try {
                this.e.b(this.world, chunk);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void saveChunk(Chunk chunk) { // lightstone - private -> public
        if (this.e != null) {
            try {
                chunk.t = this.world.getTime();
                this.e.a(this.world, chunk);
            } catch (Exception ioexception) { // lightstone - IOException -> Exception
                ioexception.printStackTrace();
            }
        }
    }

    public void getChunkAt(IChunkProvider ichunkprovider, int i, int j) {
        Chunk chunk = this.getOrCreateChunk(i, j);

        if (!chunk.done) {
            chunk.done = true;
            if (this.chunkProvider != null) {
                this.chunkProvider.getChunkAt(ichunkprovider, i, j);

                // lightstone start
                BlockSand.instaFall = true;
                Random random = new Random();
                random.setSeed(world.getSeed());
                long xRand = random.nextLong() / 2L * 2L + 1L;
                long zRand = random.nextLong() / 2L * 2L + 1L;
                random.setSeed((long) i * xRand + (long) j * zRand ^ world.getSeed());

                org.bukkit.World world = this.world.getWorld();
                if (world != null) {
                    for (BlockPopulator populator : world.getPopulators()) {
                        populator.populate(world, random, chunk.bukkitChunk);
                    }
                }
                BlockSand.instaFall = false;
                this.world.getServer().getPluginManager().callEvent(new ChunkPopulateEvent(chunk.bukkitChunk));
                // lightstone end

                chunk.f();
            }
        }
    }

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        int i = 0;

        for (int j = 0; j < this.chunkList.size(); ++j) {
            Chunk chunk = (Chunk) this.chunkList.get(j);

            if (flag && !chunk.r) {
                this.saveChunkNOP(chunk);
            }

            if (chunk.a(flag)) {
                this.saveChunk(chunk);
                chunk.q = false;
                ++i;
                if (i == 24 && !flag) {
                    return false;
                }
            }
        }

        if (flag) {
            if (this.e == null) {
                return true;
            }

            this.e.b();
        }

        return true;
    }

    public boolean unloadChunks() {
        if (!this.world.savingDisabled) {
            // lightstone start
            org.bukkit.Server server = this.world.getServer();
            for (int i = 0; i < 50 && !this.unloadQueue.isEmpty(); i++) {
                long chunkcoordinates = this.unloadQueue.popFirst();
                Chunk chunk = this.chunks.get(chunkcoordinates);
                if (chunk == null) continue;

                ChunkUnloadEvent event = new ChunkUnloadEvent(chunk.bukkitChunk);
                server.getPluginManager().callEvent(event);
                if (!event.isCancelled()) {
                    this.world.getWorld().preserveChunk((CraftChunk) chunk.bukkitChunk);

                    chunk.removeEntities();
                    this.saveChunk(chunk);
                    this.saveChunkNOP(chunk);
                    // this.unloadQueue.remove(integer);
                    this.chunks.remove(chunkcoordinates); // lightstone
                    this.chunkList.remove(chunk);
                }
            }
            // lightstone end

            if (this.e != null) {
                this.e.a();
            }
        }

        return this.chunkProvider.unloadChunks();
    }

    public boolean canSave() {
        return !this.world.savingDisabled;
    }

    public List a(EnumCreatureType enumcreaturetype, int i, int j, int k) {
        return this.chunkProvider.a(enumcreaturetype, i, j, k);
    }

    public ChunkPosition a(World world, String s, int i, int j, int k) {
        return this.chunkProvider.a(world, s, i, j, k);
    }
}
