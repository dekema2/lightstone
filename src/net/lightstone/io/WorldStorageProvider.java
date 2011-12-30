package net.lightstone.io;

import java.io.File;
import net.lightstone.GlowWorld;

public interface WorldStorageProvider {

    public ChunkIoService getChunkIoService();

    public WorldMetadataService getMetadataService();

    public void setWorld(GlowWorld world);

    /** Get the folder holding the world data.
     * @return world folder
     */
    public File getFolder();

}
