package net.lightstone.io.blockstate;

import net.lightstone.block.GlowNoteBlock;
import net.lightstone.util.nbt.ByteTag;
import net.lightstone.util.nbt.CompoundTag;
import net.lightstone.util.nbt.Tag;

import java.util.Map;

public class NoteBlockStore extends BlockStateStore<GlowNoteBlock> {
    public NoteBlockStore() {
        super(GlowNoteBlock.class, "Music");
    }

    @Override
    public void load(GlowNoteBlock state, CompoundTag compound) {
        state.setRawNote(((ByteTag) compound.getValue().get("note")).getValue());
    }

    @Override
    public Map<String, Tag> save(GlowNoteBlock entity) {
        Map<String, Tag> map = super.save(entity);
        map.put("note", new ByteTag("note", entity.getRawNote()));
        return map;
    }
}
