package net.minecraft.server;

// lightstone start
import org.unxoft.lightstone.block.CraftBlockState;
import org.unxoft.lightstone.event.CraftEventFactory;
import org.bukkit.event.block.BlockPlaceEvent;
// lightstone end

public class ItemRedstone extends Item {

    public ItemRedstone(int i) {
        super(i);
    }

    public boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l) {
        int clickedX = i, clickedY = j, clickedZ = k; // lightstone

        if (world.getTypeId(i, j, k) != Block.SNOW.id) {
            if (l == 0) {
                --j;
            }

            if (l == 1) {
                ++j;
            }

            if (l == 2) {
                --k;
            }

            if (l == 3) {
                ++k;
            }

            if (l == 4) {
                --i;
            }

            if (l == 5) {
                ++i;
            }

            if (!world.isEmpty(i, j, k)) {
                return false;
            }
        }

        if (!entityhuman.d(i, j, k)) {
            return false;
        } else {
            if (Block.REDSTONE_WIRE.canPlace(world, i, j, k)) {
                CraftBlockState blockState = CraftBlockState.getBlockState(world, i, j, k); // lightstone

                world.setRawTypeId(i, j, k, Block.REDSTONE_WIRE.id); // lightstone - We update after the event

                // lightstone start - redstone
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(world, entityhuman, blockState, clickedX, clickedY, clickedZ, Block.REDSTONE_WIRE);

                if (event.isCancelled() || !event.canBuild()) {
                    event.getBlockPlaced().setTypeIdAndData(blockState.getTypeId(), blockState.getRawData(), false);
                    return false;
                }

                world.update( i, j, k, Block.REDSTONE_WIRE.id); // Must take place after BlockPlaceEvent, we need to update all other blocks.
                // lightstone end

                --itemstack.count; // lightstone - ORDER MATTERS
            }

            return true;
        }
    }
}
