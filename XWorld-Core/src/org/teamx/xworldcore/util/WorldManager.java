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

    /**
     * Build's a new world
     * @param name
     * @param seed
     * @param chunkGenerator
     * @param worldType
     * @param structure
     * @param environment
     */
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
            XWorldCore.getxLogger().log(Level.INFO, "Seed for world " + name + " cannot be null!", true, true);
        }

        if((chunkGenerator != null) && (chunkGenerator.length() != 0)) {
            worldCreator.generator(chunkGenerator);
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "Generator for world " + name + " cannot be null!", true, true);
        }

        if(worldType != null) {
            worldCreator.type(worldType);
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "WorldType for world " + name + " cannot be null!", true, true);
        }

        if(structure != null) {
            worldCreator.generateStructures(structure.booleanValue());
        } else {
            XWorldCore.getxLogger().log(Level.INFO, "Structure Boolean for world " + name + " cannot be null!", true, true);
        }

        XWorldCore.getxLogger().log(Level.INFO, "Starting world creation for world " + name + "...", true, true);

        long startTime = System.currentTimeMillis();
        worldCreator.createWorld();
        long stopTime = System.currentTimeMillis();

        XWorldCore.getxLogger().log(Level.INFO, "World " + name + " created in " + (stopTime - startTime) + "ms!", true, true);

        Location location = Bukkit.getWorld(name).getSpawnLocation();

        File file = new File(name);
        configManager.setupWorldConfig(file, seedLong, structure, worldType, environment, location);
    }

    /**
     * Delete's a specified XWorld
     * @param xWorld
     */
    @Override
    public void deleteXWorld(XWorld xWorld) {

    }

    /**
     * Load's a specified XWorld
     * @param world
     */
    @Override
    public void loadXWorld(World world) {

    }

    /**
     * Unload's a specified XWorld
     * @param xWorld
     */
    @Override
    public void unloadXWorld(XWorld xWorld) {

    }

    /**
     * Return's a specified XWorld as a new Object
     * @param xWorld
     * @return
     */
    @Override
    public XWorld getXWorld(XWorld xWorld) {
        return null;
    }

    /**
     * Return's all XWorlds as an object in an array
     * @return
     */
    @Override
    public XWorld[] getXWorlds() {
        return new XWorld[0];
    }

    /**
     * Check's wether the XWorld is loaded
     * @return
     */
    @Override
    public boolean isLoaded() {
        return false;
    }

    /**
     * Delete's the whole world with world folder and config
     */
    @Override
    public void purge() {

    }

    /**
     * Return's the name of this XWorld
     * @return
     */
    @Override
    public String getName() {
        return null;
    }




}
