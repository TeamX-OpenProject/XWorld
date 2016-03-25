package org.teamx.xworldcore.api.world;

import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;
import org.teamx.xworldcore.api.XWorld;

/**
 * @author Shustin
 */
public interface IXWorldUtil {

    void buildXWorld(String name, String seed, String chunkGenerator, WorldType worldType, Boolean structure, World.Environment environment);

    void deleteXWorld(XWorld xWorld);

    void loadXWorld(World world);

    void unloadXWorld(XWorld xWorld);

    XWorld getXWorld(XWorld xWorld);

    XWorld[] getXWorlds();

    boolean isLoaded();

    void purge();

    String getName();


}
