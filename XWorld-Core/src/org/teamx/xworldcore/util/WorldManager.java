package org.teamx.xworldcore.util;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.XWorld;
import org.teamx.xworldcore.api.world.IXWorldUtil;
import org.teamx.xworldcore.configuration.ConfigManager;

import java.io.File;
import java.io.IOException;

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
        }

        if((chunkGenerator != null) && (chunkGenerator.length() != 0)) {
            worldCreator.generator(chunkGenerator);
        }

        if(worldType != null) {
            worldCreator.type(worldType);
        }


        if(structure != null) {
            worldCreator.generateStructures(structure.booleanValue());
        }

        worldCreator.createWorld();

        Location location = Bukkit.getWorld(name).getSpawnLocation();

        File file = new File(name);

        setupWorldConfig(file, seedLong, structure, worldType, environment, location);
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


    public void setupWorldConfig(File worldFile, long seed, boolean structure, WorldType worldType, World.Environment environment, Location location) {
        this.worldConfiguration = YamlConfiguration.loadConfiguration(worldFile);

        worldConfiguration.set("world.name", String.valueOf(worldFile));
        worldConfiguration.set("world.aliases", "");
        worldConfiguration.set("world.seed", seed);
        worldConfiguration.set("world.worldType", worldType);
        worldConfiguration.set("world.environment", World.Environment.valueOf(String.valueOf(environment)));

        worldConfiguration.set("world.spawn" + ".x", location.getX());
        worldConfiguration.set("world.spawn" + ".y", location.getY());
        worldConfiguration.set("world.spawn" + ".z", location.getZ());
        worldConfiguration.set("world.spawn" + ".yaw", location.getYaw());
        worldConfiguration.set("world.spawn" + ".pitch", location.getPitch());

        worldConfiguration.set("world.settings.color", "&f");
        worldConfiguration.set("world.settings.style", "");
        worldConfiguration.set("world.settings.accessPermission", "");
        worldConfiguration.set("world.settings.exemptPermission", "");
        worldConfiguration.set("world.settings.gamemode", "SURVIVAL");
        worldConfiguration.set("world.settings.difficulty", "EASY");
        worldConfiguration.set("world.settings.changeWeather", true);
        worldConfiguration.set("world.settings.spawnMobs", true);
        worldConfiguration.set("world.settings.spawnAnimals", true);
        worldConfiguration.set("world.settings.oldCombat", true);
        worldConfiguration.set("world.settings.naturalGeneration", true);
        worldConfiguration.set("world.settings.blockbreak", true);
        worldConfiguration.set("world.settings.chat", true);
        worldConfiguration.set("world.settings.pvp", true);
        worldConfiguration.set("world.settings.fly", true);
        worldConfiguration.set("world.settings.commandTeleport", true);
        worldConfiguration.set("world.settings.signTeleport", true);
        worldConfiguration.set("world.settings.bedrespawn", true);
        worldConfiguration.set("world.settings.hunger", true);
        worldConfiguration.set("world.settings.storm", true);
        worldConfiguration.set("world.settings.damage", true);
        worldConfiguration.set("world.settings.chat", true);

        try {
            this.worldConfiguration.save(new File(XWorldCore.getInstance().getDataFolder(), worldFile + ".yml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
