package net.lightstone.io.entity;

import net.lightstone.entity.GlowLivingEntity;

public abstract class LivingEntityStore<T extends GlowLivingEntity> extends EntityStore<T> {
    
    public LivingEntityStore(Class<T> clazz, String id) {
        super(clazz, id);
    }
}
