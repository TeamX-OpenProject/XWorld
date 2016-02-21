package org.teamx.xworldcore.generator;

import org.bukkit.generator.ChunkGenerator;
import org.teamx.xworldcore.generator.chunkgenerator.EmptyWorldChunkGenerator;

/**
 * Created by lusu007 on 21.02.2016.
 */
public class EmptyWorldGenerator {

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new EmptyWorldChunkGenerator(id);
    }
}
