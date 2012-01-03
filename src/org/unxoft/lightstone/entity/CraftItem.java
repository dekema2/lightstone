package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityItem;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.unxoft.lightstone.inventory.CraftItemStack;
import org.unxoft.lightstone.CraftServer;

public class CraftItem extends CraftEntity implements Item {
    private EntityItem item;

    public CraftItem(CraftServer server, EntityItem entity) {
        super(server, entity);
        this.item = entity;
    }

    public ItemStack getItemStack() {
        return new CraftItemStack(item.itemStack);
    }

    public void setItemStack(ItemStack stack) {
        item.itemStack = CraftItemStack.createNMSItemStack(stack);
    }

    public int getPickupDelay() {
        return item.pickupDelay;
    }

    public void setPickupDelay(int delay) {
        item.pickupDelay = delay;
    }

    @Override
    public EntityItem getHandle() {
        return (EntityItem) entity;
    }

    @Override
    public String toString() {
        return "CraftItem";
    }
}
