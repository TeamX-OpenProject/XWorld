package org.teamx.xworldcore.api.world;

import org.bukkit.World;
import org.bukkit.WorldType;
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
