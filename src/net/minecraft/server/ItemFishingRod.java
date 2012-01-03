package net.minecraft.server;

import org.bukkit.event.player.PlayerFishEvent; // lightstone

public class ItemFishingRod extends Item {

    public ItemFishingRod(int i) {
        super(i);
        this.f(64);
        this.e(1);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.hookedFish != null) {
            int i = entityhuman.hookedFish.j();

            itemstack.damage(i, entityhuman);
            entityhuman.r_();
        } else {
            // lightstone start
            PlayerFishEvent playerFishEvent = new PlayerFishEvent((org.bukkit.entity.Player) entityhuman.getBukkitEntity(), null,PlayerFishEvent.State.FISHING);
            world.getServer().getPluginManager().callEvent(playerFishEvent);

            if (playerFishEvent.isCancelled()) {
                return itemstack;
            }
            // lightstone end

            world.makeSound(entityhuman, "random.bow", 0.5F, 0.4F / (c.nextFloat() * 0.4F + 0.8F));
            if (!world.isStatic) {
                world.addEntity(new EntityFishingHook(world, entityhuman));
            }

            entityhuman.r_();
        }

        return itemstack;
    }
}
