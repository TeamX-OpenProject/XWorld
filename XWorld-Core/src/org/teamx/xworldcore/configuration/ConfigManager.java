package org.teamx.xworldcore.configuration;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.teamx.xworldcore.XWorldCore;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @author Shustin
 */
public class ConfigManager {

    public File config;
    public FileConfiguration configConfiguration;
    public FileConfiguration worldConfiguration;
    public static XWorldCore plugin;

    public ConfigManager(XWorldCore xWorldCore) {
        this.plugin = xWorldCore;
        this.config = new File(plugin.getDataFolder(), "config.yml");
        this.configConfiguration = YamlConfiguration.loadConfiguration(this.config);
        loadConfigurations();
    }


    public void loadConfigurations() {
        if (!this.config.exists()) {
            this.configConfiguration.options().copyDefaults(true);
            saveConfig();
        }
    }

    public void saveConfig() {
        try {
            this.configConfiguration.save(this.config);
        } catch (IOException e) {
            XWorldCore.getxLogger().log(Level.CONFIG, "An unexpected error occurred while trying to save the config.", true);
            e.printStackTrace();
        }
    }

    public boolean exists(File file) {
        if(!file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void setString(File file, String path, String s) {

        worldConfiguration.set(path, s);
    }

    public void setLong(File file, String path, long l) {

        worldConfiguration.set(path, l);
    }

    public void setBoolean(File file, String path, boolean b) {

        worldConfiguration.set(path, b);
    }

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

    public String getString(File file, String path) {

        return worldConfiguration.getString(path);
    }

    public Long getLong(File file, String path) {

        return worldConfiguration.getLong(path);
    }

    public Boolean getBoolean(File file, String path) {

        return worldConfiguration.getBoolean(path);
    }

}
