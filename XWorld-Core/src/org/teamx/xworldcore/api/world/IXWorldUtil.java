package org.teamx.xworldcore.api.world;

import org.bukkit.World;
import org.teamx.xworldcore.api.XWorld;

/**
 * @author Shustin
 */
public interface IXWorldUtil {

    void buildXWorld();

    void deleteXWorld(XWorld xWorld);

    void loadXWorld(World world);

    void unloadXWorld(XWorld xWorld);

    XWorld getXWorld(XWorld xWorld);

    XWorld[] getXWorlds();

    boolean isLoaded();

    String getName();


}
