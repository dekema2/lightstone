package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityMushroomCow;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.MushroomCow;

public class CraftMushroomCow extends CraftCow implements MushroomCow {
    public CraftMushroomCow(CraftServer server, EntityMushroomCow entity) {
        super(server, entity);
    }

    @Override
    public EntityMushroomCow getHandle() {
        return (EntityMushroomCow) entity;
    }

    @Override
    public String toString() {
        return "CraftMushroomCow";
    }
}
