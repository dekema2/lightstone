package org.unxoft.lightstone.block;

import net.minecraft.server.TileEntityChest;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.unxoft.lightstone.CraftWorld;
import org.unxoft.lightstone.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;

public class CraftChest extends CraftBlockState implements Chest {
    private final CraftWorld world;
    private final TileEntityChest chest;

    public CraftChest(final Block block) {
        super(block);

        world = (CraftWorld) block.getWorld();
        chest = (TileEntityChest) world.getTileEntityAt(getX(), getY(), getZ());
    }

    public Inventory getInventory() {
        return new CraftInventory(chest);
    }

    @Override
    public boolean update(boolean force) {
        boolean result = super.update(force);

        if (result) {
            chest.update();
        }

        return result;
    }
}
