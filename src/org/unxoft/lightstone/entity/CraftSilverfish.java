package org.unxoft.lightstone.entity;

import net.minecraft.server.EntitySilverfish;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.Silverfish;

public class CraftSilverfish extends CraftMonster implements Silverfish {
    public CraftSilverfish(CraftServer server, EntitySilverfish entity) {
        super(server, entity);
    }

    @Override
    public EntitySilverfish getHandle() {
        return (EntitySilverfish) entity;
    }

    @Override
    public String toString() {
        return "CraftSilverfish";
    }
}
