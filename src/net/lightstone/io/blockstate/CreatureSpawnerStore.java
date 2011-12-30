package net.lightstone.io.blockstate;

import net.lightstone.block.GlowCreatureSpawner;
import net.lightstone.util.nbt.CompoundTag;
import net.lightstone.util.nbt.IntTag;
import net.lightstone.util.nbt.StringTag;
import net.lightstone.util.nbt.Tag;

import java.util.Map;

public class CreatureSpawnerStore extends BlockStateStore<GlowCreatureSpawner> {
    public CreatureSpawnerStore() {
        super(GlowCreatureSpawner.class, "MobSpawner");
    }


    @Override
    public void load(GlowCreatureSpawner spawner, CompoundTag compound) {
        super.load(spawner, compound);
        spawner.setCreatureTypeId(compound.getValue().get("EntityId").getValue().toString());
        spawner.setDelay(((IntTag) compound.getValue().get("Delay")).getValue());
    }

    @Override
    public Map<String, Tag> save(GlowCreatureSpawner spawner) {
        Map<String, Tag> ret = super.save(spawner);
        ret.put("EntityId", new StringTag("EntityId", spawner.getCreatureTypeId()));
        ret.put("Delay", new IntTag("Delay", spawner.getDelay()));
        return ret;
    }
}
