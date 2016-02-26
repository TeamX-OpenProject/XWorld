package org.teamx.xworldcore;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.teamx.xworldcore.command.*;

import java.util.logging.Level;

/**
 *
 * @author lusu007
 * @author Shustin
 * @version 0.1
 *
 */
public class XWorldCore extends JavaPlugin {

    CommandUtil commandUtil;
    XWorldCommand xWorldCommand;
    CloneCommand cloneCommand;
    TestCommand testCommand;
    ConfirmCommand confirmCommand;

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

        //Here everything else..

        long stopTime = System.currentTimeMillis();

        this.getLogger().log( Level.INFO, "XWorld Plugin version "
                + this.getDescription().getVersion() + " by "
                + this.getDescription().getAuthors().toString().replaceAll( "(\\[|\\])", "" ) + " enabled! (In "
                + (stopTime - startTime) + "ms)");
    }

    @Override
    public void onDisable() {

    }

    private void initClasses() {
        commandUtil = new CommandUtil(this);
        xWorldCommand = new XWorldCommand();
        cloneCommand = new CloneCommand();
        testCommand = new TestCommand();
        confirmCommand = new ConfirmCommand();
    }

    public static XWorldCore getInstance() {
        return instance;
    }
}