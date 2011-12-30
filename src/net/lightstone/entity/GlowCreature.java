package net.lightstone.entity;

import net.lightstone.GlowServer;
      
import org.bukkit.entity.Creature;

import net.lightstone.util.Position;
import net.lightstone.msg.Message;
import net.lightstone.msg.SpawnMobMessage;
import net.lightstone.util.Parameter;
import net.lightstone.GlowWorld;
import org.bukkit.entity.LivingEntity;

/**
 * Represents a monster such as a creeper.
 * @author Graham Edgecombe
 */
public final class GlowCreature extends GlowLivingEntity implements Creature {

    /**
     * The type of monster.
     */
    private final int type;
   
    /**
     * The monster's target.
     */
    private LivingEntity target;

    /**
     * Creates a new monster.
     * @param world The world this monster is in.
     * @param type The type of monster.
     */
    public GlowCreature(GlowServer server, GlowWorld world, int type) {
        super(server, world);
        this.type = type;
    }

    /**
     * Gets the type of monster.
     * @return The type of monster.
     */
    public int getType() {
        return type;
    }

    @Override
    public Message createSpawnMessage() {
        int x = Position.getIntX(location);
        int y = Position.getIntY(location);
        int z = Position.getIntZ(location);
        int yaw = Position.getIntYaw(location);
        int pitch = Position.getIntPitch(location);
        return new SpawnMobMessage(id, type, x, y, z, yaw, pitch, metadata);
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    public LivingEntity getTarget() {
        return target;
    }

    public int getMaxHealth() {
        throw new UnsupportedOperationException("Not supported yet!");
    }
}
