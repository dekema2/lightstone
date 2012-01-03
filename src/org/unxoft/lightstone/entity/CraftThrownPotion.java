package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityPotion;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.ThrownPotion;

public class CraftThrownPotion extends CraftProjectile implements ThrownPotion {
    public CraftThrownPotion(CraftServer server, EntityPotion entity) {
        super(server, entity);
    }

    @Override
    public EntityPotion getHandle() {
        return (EntityPotion) entity;
    }

    @Override
    public String toString() {
        return "CraftThrownPotion";
    }
}
