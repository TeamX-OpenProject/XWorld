package org.teamx.xworldcore.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.log.XLogger;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @author lusu007
 */
public class Config {

    File file;
    FileConfiguration fileConfiguration;
    XLogger xLogger;

    /**
     * Create's a new Config instance and load's the config
     */
    public Config() {
        xLogger = XWorldCore.getxLogger();

        loadConfig();

        file = new File( XWorldCore.getInstance().getDataFolder() + "/config.yml" );
        fileConfiguration = XWorldCore.getInstance().getConfig();
    }

    /**
     * Load's the config
     */
    private void loadConfig() {
        XWorldCore.getInstance().saveDefaultConfig();
    }

    /**
     * Return's File Object
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     * Return's FileConfiguration to access the data inside the File
     * @return
     */
    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    /**
     * Save the config
     */
    public void save() {
        try {
            getConfig().save( file );
        } catch ( IOException e ) {
            xLogger.log( Level.SEVERE, "Saved config uncorrectly!!! Exception: \n" + e.toString(), true, false );
        }
    }
}
