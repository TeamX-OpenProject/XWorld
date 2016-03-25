package org.teamx.xworldcore;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.teamx.xworldcore.api.XWorld;
import org.teamx.xworldcore.api.log.XLogger;
import org.teamx.xworldcore.command.*;
import org.teamx.xworldcore.configuration.ConfigManager;
import org.teamx.xworldcore.util.WorldManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author lusu007
 * @author Shustin
 * @version 0.2
 *
 */
public class XWorldCore extends JavaPlugin {
    CommandUtil commandUtil;
    WorldManager worldManager;

    static ConfigManager configManager;
    static XLogger xLogger;

    private static XWorldCore instance;

    public static final String LOG_TAG = "[XWorldCore-Core] ";
    public static final String PREFIX = ChatColor.DARK_AQUA + "[XWorld] ";

    @Override
    public void onEnable() {
        long startTime = System.currentTimeMillis();

        instance = this;

        initClasses();

        if(isSpigot()) {
            xLogger.log( Level.INFO, "-- STARTUP ON SPIGOT --", false, false );
        } else {
            xLogger.log( Level.INFO, "-- STARTUP (We recommend Spigot!)--", false, false );
        }

        long stopTime = System.currentTimeMillis();

        xLogger.log( Level.INFO, "XWorld Plugin version "
                + "v" + this.getDescription().getVersion() + " by "
                + this.getDescription().getAuthors().toString().replaceAll( "(\\[|\\])", "" ) + " enabled! (In "
                + ( stopTime - startTime ) + "ms)", false, true );

        xLogger.log( Level.INFO, getGenerators() + " - World Generator(s) loaded", false, true );
        xLogger.log( Level.INFO, "Running on server version: " + getServer().getVersion().toString(), true, false );
    }

    @Override
    public void onDisable() {
        xLogger.log( Level.INFO, "Unloading world(s)...", true, true );
        xLogger.log( Level.INFO, "Saving config's..,", true, true );
        xLogger.log( Level.INFO, "Shutting down server...", true, false );
    }

    /**
     * Initialize all classes, registering commands
     */
    private void initClasses() {
        commandUtil = new CommandUtil();
        xLogger = new XLogger();

        configManager = new ConfigManager();
        xLogger.log( Level.INFO, "Created ConfigManager!", true, true );

        xLogger.log( Level.INFO, "Registering all commands....", true, true );

        commandUtil.registerCommands( new CloneCommand() );
        commandUtil.registerCommands( new ConfirmCommand() );
        commandUtil.registerCommands( new CreateCommand() );
        commandUtil.registerCommands( new ImportCommand() );
        commandUtil.registerCommands( new LoadCommand() );
        commandUtil.registerCommands( new ModifyPropertiesCommand() );
        commandUtil.registerCommands( new PurgeCommand() );
        commandUtil.registerCommands( new RemoveCommand() );
        commandUtil.registerCommands( new SetSpawnCommand() );
        commandUtil.registerCommands( new TeleportCommand() );
        commandUtil.registerCommands( new TestCommand() );
        commandUtil.registerCommands( new UnloadCommand() );
        commandUtil.registerCommands( new VersionCommand() );
        commandUtil.registerCommands( new WorldsCommand() );
        commandUtil.registerCommands( new XWorldCommand() );

        xLogger.log( Level.INFO, "All commands registered!", true, true );
    }

    /**
     * Get all available generator(s)
     * @return
     */
    private String getGenerators() {
        Plugin[] plugins = this.getServer().getPluginManager().getPlugins();
        List generators = new ArrayList();
        for (Plugin p : plugins) {
            if ((p.isEnabled()) && (p.getDefaultWorldGenerator("world", "") != null)) {
                generators.add(p.getDescription().getName());
            }
        }
        return String.valueOf(generators.size());
    }

    /**
     * Return's the ConfigManager instance
     * @return
     */
    public static ConfigManager getConfigManager() {
        return configManager;
    }

    /**
     * Return's the XWorldCore instance
     * @return
     */
    public static XWorldCore getInstance() {
        return instance;
    }

    /**
     * Return's the XLogger instance
     * @return
     */
    public static XLogger getxLogger() {
        return xLogger;
    }

    /**
     * Return's WorldManager
     * @return
     */
    public WorldManager getWorldManager() {
        return worldManager;
    }

    /**
     * Check's whether the server running on spigot or not
     * @return
     */
    public boolean isSpigot() {
        if(getServer().getVersion().contains("Spigot")) {
            return true;
        }

        return false;
    }
}