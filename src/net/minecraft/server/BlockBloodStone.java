package net.minecraft.server;

import org.bukkit.event.block.BlockRedstoneEvent; // lightstone

public class BlockBloodStone extends Block {

    public BlockBloodStone(int i, int j) {
        super(i, j, Material.STONE);
    }

    // lightstone start
    public void doPhysics(World world, int i, int j, int k, int l) {
        if (net.minecraft.server.Block.byId[l] != null && net.minecraft.server.Block.byId[l].isPowerSource()) {
            org.bukkit.block.Block block = world.getWorld().getBlockAt(i, j, k);
            int power = block.getBlockPower();

            BlockRedstoneEvent event = new BlockRedstoneEvent(block, power, power);
            world.getServer().getPluginManager().callEvent(event);
        }
    }
    // lightstone end
}
