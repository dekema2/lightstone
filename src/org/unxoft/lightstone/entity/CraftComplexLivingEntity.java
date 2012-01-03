package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityComplex;
import net.minecraft.server.EntityLiving;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.ComplexLivingEntity;

public abstract class CraftComplexLivingEntity extends CraftLivingEntity implements ComplexLivingEntity {
    public CraftComplexLivingEntity(CraftServer server, EntityComplex entity) {
        super(server, entity);
    }

    @Override
    public EntityComplex getHandle() {
        return (EntityComplex) entity;
    }

    @Override
    public String toString() {
        return "CraftComplexLivingEntity";
    }
}
