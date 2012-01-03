package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityEnderPearl;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.EnderPearl;

public class CraftEnderPearl extends CraftProjectile implements EnderPearl {
    public CraftEnderPearl(CraftServer server, EntityEnderPearl entity) {
        super(server, entity);
    }

    @Override
    public EntityEnderPearl getHandle() {
        return (EntityEnderPearl) entity;
    }

    @Override
    public String toString() {
        return "CraftEnderPearl";
    }
}
