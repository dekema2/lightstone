
package org.unxoft.lightstone.entity;

import net.minecraft.server.EntityExperienceOrb;
import org.unxoft.lightstone.CraftServer;
import org.bukkit.entity.ExperienceOrb;

public class CraftExperienceOrb extends CraftEntity implements ExperienceOrb {
    public CraftExperienceOrb(CraftServer server, EntityExperienceOrb entity) {
        super(server, entity);
    }

    public int getExperience() {
        return getHandle().value;
    }

    public void setExperience(int value) {
        getHandle().value = value;
    }

    @Override
    public EntityExperienceOrb getHandle() {
        return (EntityExperienceOrb) entity;
    }

    @Override
    public String toString() {
        return "CraftExperienceOrb";
    }
}
