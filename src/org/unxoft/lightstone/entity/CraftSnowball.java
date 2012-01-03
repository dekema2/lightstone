package org.unxoft.lightstone.entity;

import net.minecraft.server.EntitySnowball;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.Snowball;

public class CraftSnowball extends CraftProjectile implements Snowball {
    public CraftSnowball(CraftServer server, EntitySnowball entity) {
        super(server, entity);
    }

    @Override
    public EntitySnowball getHandle() {
        return (EntitySnowball) entity;
    }

    @Override
    public String toString() {
        return "CraftSnowball";
    }
}
