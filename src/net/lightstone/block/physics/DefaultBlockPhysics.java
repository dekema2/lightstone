package net.lightstone.block.physics;

import net.lightstone.block.BlockProperties;
import net.lightstone.block.GlowBlock;
import net.lightstone.block.GlowBlockState;
import org.bukkit.block.BlockFace;
import org.bukkit.material.MaterialData;

public class DefaultBlockPhysics implements BlockPhysicsHandler {

    public boolean canPlaceAt(GlowBlock loc, BlockFace against) {
        return true;
    }

    public boolean doPhysics(GlowBlock block) {
        return false;
    }

    public boolean postUpdateNeighbor(GlowBlock block, BlockFace against) {
        return false;
    }

    public int getPlacedMetadata(int current, BlockFace against) {
        return current;
    }

    public GlowBlockState placeAgainst(GlowBlockState block, int type, short data, BlockFace against) {
        block.setTypeId(type);
        block.setData(new MaterialData(block.getTypeId(),
                (byte) BlockProperties.get(block.getTypeId()).getPhysics().getPlacedMetadata(data, against)));
        return block;
    }
}
