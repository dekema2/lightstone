package net.lightstone.io.mcregion;

import net.lightstone.GlowWorld;
import net.lightstone.io.ChunkIoService;
import net.lightstone.io.WorldMetadataService;
import net.lightstone.io.WorldStorageProvider;
import net.lightstone.io.nbt.NbtWorldMetadataService;

import java.io.File;

public class McRegionWorldStorageProvider implements WorldStorageProvider {
    private GlowWorld world;
    private final File dir;
    private McRegionChunkIoService service;
    private NbtWorldMetadataService meta;

    public McRegionWorldStorageProvider(String name) {
        this(new File(name));
    }

    public McRegionWorldStorageProvider(File dir) {
        this.dir = dir;
    }

    public void setWorld(GlowWorld world) {
        if (this.world != null)
            throw new IllegalArgumentException("World is already set");
        this.world = world;
        service = new McRegionChunkIoService(dir);
        meta = new NbtWorldMetadataService(world, dir);
    }

    public ChunkIoService getChunkIoService() {
        return service;
    }

    public WorldMetadataService getMetadataService() {
        return meta;
    }

    public File getFolder() {
        return dir;
    }
}
