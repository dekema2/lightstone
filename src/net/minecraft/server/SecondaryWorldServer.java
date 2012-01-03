package net.minecraft.server;

import org.bukkit.generator.ChunkGenerator; // lightstone

public class SecondaryWorldServer extends WorldServer {
    // lightstone start
    public SecondaryWorldServer(MinecraftServer minecraftserver, IDataManager idatamanager, String s, int i, WorldSettings worldsettings, WorldServer worldserver, org.bukkit.World.Environment env, ChunkGenerator gen) {
        super(minecraftserver, idatamanager, s, i, worldsettings, env, gen);
        // lightstone end
        this.worldMaps = worldserver.worldMaps;
    }
}
