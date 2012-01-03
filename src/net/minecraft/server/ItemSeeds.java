package net.minecraft.server;

// lightstone start
import org.unxoft.lightstone.block.CraftBlockState;
import org.unxoft.lightstone.event.CraftEventFactory;
import org.bukkit.event.block.BlockPlaceEvent;
// lightstone end

public class ItemSeeds extends Item {

    private int id;
    private int b;

    public ItemSeeds(int i, int j, int k) {
        super(i);
        this.id = j;
        this.b = k;
    }

    public boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        } else if (entityhuman.d(i, j, k) && entityhuman.d(i, j + 1, k)) {
            int i1 = world.getTypeId(i, j, k);

            if (i1 == this.b && world.isEmpty(i, j + 1, k)) {
                CraftBlockState blockState = CraftBlockState.getBlockState(world, i, j + 1, k); // lightstone

                world.setTypeId(i, j + 1, k, this.id);

                // lightstone start - seeds
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(world, entityhuman, blockState, i, j, k, this.id);

                if (event.isCancelled() || !event.canBuild()) {
                    event.getBlockPlaced().setTypeId(0);
                    return false;
                }
                // lightstone end

                --itemstack.count;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
