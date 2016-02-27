package org.teamx.xworldcore.configuration;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.teamx.xworldcore.XWorldCore;

import java.io.File;
import java.io.IOException;

/**
 * @author Shustin
 */
public class ConfigManager {

    public File config;
    public FileConfiguration configConfiguration;
    public static XWorldCore plugin;

    public ConfigManager(XWorldCore xWorldCore) {
        this.plugin = xWorldCore;
        this.config = new File(plugin.getDataFolder(), "config.yml");
        this.configConfiguration = YamlConfiguration.loadConfiguration(this.config);
        loadConfigurations();
    }


    public void loadConfigurations()
    {
        if (!this.config.exists()) {
            this.configConfiguration.options().copyDefaults(true);
            saveConfig();
        }
    }

    public void saveConfig() {
        try {
            this.configConfiguration.save(this.config);
        } catch (IOException e) {
            System.out.println("An unexpected error occurred while trying to save the config.");
            e.printStackTrace();
        }
    }

    public void setSpawn(FileConfiguration fileConfiguration, Location loc, String path) {
        fileConfiguration.set(path + ".X", Double.valueOf(loc.getX()));
        fileConfiguration.set(path + ".Y", Double.valueOf(loc.getY()));
        fileConfiguration.set(path + ".Z", Double.valueOf(loc.getZ()));
        fileConfiguration.set(path + ".Yaw", Float.valueOf(loc.getYaw()));
        fileConfiguration.set(path + ".Pitch", Float.valueOf(loc.getPitch()));
        fileConfiguration.set(path + ".World", loc.getWorld().getName());
    }

    public Location loadSpawnLocation(FileConfiguration fileConfiguration, String path) {
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


}
