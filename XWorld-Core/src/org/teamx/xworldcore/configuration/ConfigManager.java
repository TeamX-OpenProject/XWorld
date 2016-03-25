package org.teamx.xworldcore.configuration;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.teamx.xworldcore.XWorldCore;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @author Shustin
 * @author lusu007
 */
public class ConfigManager {

    private File config;
    private FileConfiguration configConfiguration;
    private FileConfiguration worldConfiguration;
    private static XWorldCore plugin;

    public ConfigManager() {
        this.plugin = XWorldCore.getInstance();
        this.config = new File(plugin.getDataFolder(), "config.yml");
        this.configConfiguration = YamlConfiguration.loadConfiguration(this.config);
        loadConfigurations();
    }

    /**
     * Creates the config.yml if it not exists
     */
    public void loadConfigurations() {
        if (!this.config.exists()) {
            this.configConfiguration.options().copyDefaults(true);
            saveConfig();
        }
    }

    /**
     * Saves the config.yml with default values
     */
    public void saveConfig() {
        try {
            configConfiguration.options().header(
                    "---------------------------------------------------- #" + "\n"
                    + " This configuration helps you to customize XWorld    #" + "\n"
                    + "                                                     #" + "\n"
                    + " You cant delete any value, it will be regenerated   #" + "\n"
                    + "---------------------------------------------------- #" );

            configConfiguration.addDefault( "debug", false );
            configConfiguration.addDefault( "displaypermerror", true );

            this.configConfiguration.save( this.config );
        } catch (IOException e) {
            XWorldCore.getxLogger().log(Level.CONFIG, "An unexpected error occurred while trying to save the config.", false, true);
            e.printStackTrace();
        }
    }

    /**
     * Checks if the parameter file exists
     * @param file
     * @return
     */
    public boolean exists(File file) {
        if(!file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get's the spawn from a specified world config
     * @param fileConfiguration
     * @param path
     * @return
     */
    public Location getSpawn(FileConfiguration fileConfiguration, String path) {
        double X = fileConfiguration.getDouble(path + ".X");
        double Y = fileConfiguration.getDouble(path + ".Y");
        double Z = fileConfiguration.getDouble(path + ".Z");
        double Yaw = fileConfiguration.getDouble(path + ".Yaw");
        double Pitch = fileConfiguration.getDouble(path + ".Pitch");
        World World = plugin.getServer().getWorld(fileConfiguration.getString(path + ".World"));

        Location loc = new Location(World, X, Y, Z);
        loc.setYaw((float)Yaw);
        loc.setPitch((float)Pitch);
        return loc;
    }

    /**
     * Creates a new world config
     * @param worldFile
     * @param seed
     * @param structure
     * @param worldType
     * @param environment
     * @param location
     */
    public void setupWorldConfig(File worldFile, long seed, boolean structure, WorldType worldType, World.Environment environment, Location location) {
        XWorldCore.getxLogger().log(Level.INFO, "Setting up world config for world " + String.valueOf(worldFile) + "...", true, true);
        this.worldConfiguration = YamlConfiguration.loadConfiguration(worldFile);

        worldConfiguration.set("world.name", String.valueOf(worldFile));
        worldConfiguration.set("world.aliases", "");
        worldConfiguration.set("world.seed", seed);
        worldConfiguration.set("world.worldType", worldType);
        worldConfiguration.set("world.environment", World.Environment.valueOf(String.valueOf(environment)));
        System.out.println(World.Environment.valueOf(String.valueOf(environment)));

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
            XWorldCore.getxLogger().log(Level.INFO, "Saving world config for world " + String.valueOf(worldFile) + "...", true, true);
            this.worldConfiguration.save(new File(XWorldCore.getInstance().getDataFolder(), "worlds/" + worldFile + ".yml"));
            XWorldCore.getxLogger().log(Level.INFO, "Config for world " + String.valueOf(worldFile) + " saved!", false, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return's config.yml FileConfiguration
     * @return
     */
    public FileConfiguration getConfigConfiguration() {
        return configConfiguration;
    }
}
