package org.unxoft.lightstone.entity;

import org.unxoft.lightstone.entity.CraftMinecart;
import net.minecraft.server.EntityMinecart;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.PoweredMinecart;

public class CraftPoweredMinecart extends CraftMinecart implements PoweredMinecart {
    public CraftPoweredMinecart(CraftServer server, EntityMinecart entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftPoweredMinecart";
    }
}
