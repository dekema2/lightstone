package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityFallingBlock;

import org.unxoft.lightstone.CraftServer;
import org.unxoft.lightstone.entity.CraftEntity;
import org.bukkit.entity.FallingSand;

public class CraftFallingSand extends CraftEntity implements FallingSand {

    public CraftFallingSand(CraftServer server, EntityFallingBlock entity) {
        super(server, entity);
    }

    @Override
    public EntityFallingBlock getHandle() {
        return (EntityFallingBlock) entity;
    }

    @Override
    public String toString() {
        return "CraftFallingSand";
    }
}
