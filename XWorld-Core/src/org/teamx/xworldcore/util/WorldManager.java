package org.teamx.xworldcore.util;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.XWorld;
import org.teamx.xworldcore.api.log.PlayerMessenger;
import org.teamx.xworldcore.api.world.IXWorldUtil;
import org.teamx.xworldcore.configuration.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @author Shustin
 */
public class WorldManager implements IXWorldUtil {

    FileConfiguration worldConfiguration;

    private final ConfigManager configManager = XWorldCore.getInstance().getConfigManager();

    @Override
    public void buildXWorld(String name, String seed, String chunkGenerator, WorldType worldType, Boolean structure, World.Environment environment) {
        Long seedLong = null;
        WorldCreator worldCreator = new WorldCreator(name);

        if((seed != null) && (seed.length() > 0)) {
            try {
                seedLong = Long.valueOf(Long.parseLong(seed));
            } catch (NumberFormatException numberformatexception) {
                seedLong = Long.valueOf(seed.hashCode());
            }
            worldCreator.seed(seedLong.longValue());
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "Seed for world " + name + " cannot be null!", true);
        }

        if((chunkGenerator != null) && (chunkGenerator.length() != 0)) {
            worldCreator.generator(chunkGenerator);
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "Generator for world " + name + " cannot be null!", true);
        }

        if(worldType != null) {
            worldCreator.type(worldType);
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "WorldType for world " + name + " cannot be null!", true);
        }

        if(structure != null) {
            worldCreator.generateStructures(structure.booleanValue());
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "Structure Boolean for world " + name + " cannot be null!", true);
        }

        XWorldCore.getxLogger().log(Level.INFO, "Starting world creation for world " + name + "...", true);

        long startTime = System.currentTimeMillis();
        worldCreator.createWorld();
        long stopTime = System.currentTimeMillis();

        XWorldCore.getxLogger().log(Level.INFO, "World " + name + " created in " + (stopTime - startTime) + "ms!", true);

        Location location = Bukkit.getWorld(name).getSpawnLocation();

        File file = new File(name);
        configManager.setupWorldConfig(file, seedLong, structure, worldType, environment, location);
    }


    @Override
    public void deleteXWorld(XWorld xWorld) {

    }

    @Override
    public void loadXWorld(World world) {

    }

    @Override
    public void unloadXWorld(XWorld xWorld) {

    }

    @Override
    public XWorld getXWorld(XWorld xWorld) {
        return null;
    }

    @Override
    public XWorld[] getXWorlds() {
        return new XWorld[0];
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }




}
