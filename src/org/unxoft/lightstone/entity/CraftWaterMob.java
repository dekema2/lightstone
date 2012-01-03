package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityWaterAnimal;

import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.WaterMob;

public class CraftWaterMob extends CraftCreature implements WaterMob {

    public CraftWaterMob(CraftServer server, EntityWaterAnimal entity) {
        super(server, entity);
    }

    @Override
    public EntityWaterAnimal getHandle() {
        return (EntityWaterAnimal) entity;
    }

    @Override
    public String toString() {
        return "CraftWaterMob";
    }
}
