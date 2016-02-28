package org.teamx.xworldcore.api.world;

import org.bukkit.World;
import org.teamx.xworldcore.api.XWorld;

/**
 * @author Shustin
 */
public interface IXWorldUtil {

    void buildXWorld();

    void deleteXWorld();

    void loadXWorld();

    void unloadXWorld();

    XWorld getXWorld();

    XWorld[] getXWorlds();

    World getWorld();



}
