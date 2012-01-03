
package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityWeather;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.Weather;

public class CraftWeather extends CraftEntity implements Weather {
    public CraftWeather(final CraftServer server, final EntityWeather entity) {
        super(server, entity);
    }

    @Override
    public EntityWeather getHandle() {
        return (EntityWeather) entity;
    }

    @Override
    public String toString() {
        return "CraftWeather";
    }
}
