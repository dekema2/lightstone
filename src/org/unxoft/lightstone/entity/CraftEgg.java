package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityEgg;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.Egg;

public class CraftEgg extends CraftProjectile implements Egg {
    public CraftEgg(CraftServer server, EntityEgg entity) {
        super(server, entity);
    }

    @Override
    public EntityEgg getHandle() {
        return (EntityEgg) entity;
    }

    @Override
    public String toString() {
        return "CraftEgg";
    }
}
