package org.unxoft.lightstone.entity;

import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.Vehicle;

public abstract class CraftVehicle extends CraftEntity implements Vehicle {
    public CraftVehicle(CraftServer server, net.minecraft.server.Entity entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftVehicle{passenger=" + getPassenger() + '}';
    }
}
