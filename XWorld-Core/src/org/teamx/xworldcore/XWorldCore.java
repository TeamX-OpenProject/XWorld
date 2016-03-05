package org.teamx.xworldcore;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.teamx.xworldcore.api.log.XLogger;
import org.teamx.xworldcore.command.*;
import org.teamx.xworldcore.configuration.ConfigManager;

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
    XWorldCommand xWorldCommand;
    CloneCommand cloneCommand;
    TestCommand testCommand;
    ConfirmCommand confirmCommand;
    ConfigManager configManager;

    static XLogger xLogger;

    private static XWorldCore instance;

    public static final String LOG_TAG = "[XWorldCore-Core] ";
    public static final String PREFIX = ChatColor.DARK_AQUA + "[XWorld] ";

    @Override
    public void onEnable() {
        long startTime = System.currentTimeMillis();

        instance = this;

        initClasses();

        commandUtil.registerCommands(xWorldCommand);
        commandUtil.registerCommands(cloneCommand);
        commandUtil.registerCommands(testCommand);
        commandUtil.registerCommands(confirmCommand);

        xLogger = new XLogger();
        //Here everything else..

        long stopTime = System.currentTimeMillis();

        xLogger.log( Level.INFO, "XWorld Plugin version "
                + this.getDescription().getVersion() + " by "
                + this.getDescription().getAuthors().toString().replaceAll( "(\\[|\\])", "" ) + " enabled! (In "
                + (stopTime - startTime) + "ms)", true);

        xLogger.log(Level.INFO, getGenerators() + " - World Generator(s) loaded", true);
    }

    @Override
    public void onDisable() {

    }

    private void initClasses() {
        commandUtil = new CommandUtil(this);
        xWorldCommand = new XWorldCommand();
        cloneCommand = new CloneCommand();
        testCommand = new TestCommand(this);
        confirmCommand = new ConfirmCommand();

        configManager = new ConfigManager(this);
    }

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

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public static XWorldCore getInstance() {
        return instance;
    }

    public static XLogger getxLogger() {
        return xLogger;
    }
}