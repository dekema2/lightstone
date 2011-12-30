package net.lightstone.entity;

import org.bukkit.entity.Weather;

import net.lightstone.GlowServer;
import net.lightstone.GlowWorld;

/**
 * Represents a Weather related entity, such as a storm.
 */
public abstract class GlowWeather extends GlowEntity implements Weather {

    public GlowWeather(GlowServer server, GlowWorld world) {
        super(server, world);
    }
    
}
