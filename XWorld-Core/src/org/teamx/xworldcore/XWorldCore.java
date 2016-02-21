package org.teamx.xworldcore;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 *
 * @author lusu007
 * @author Shustin
 * @version 0.1
 *
 */
public class XWorldCore extends JavaPlugin {

    public static final String LOG_TAG = "[XWorldCore-Core] ";

    @Override
    public void onEnable() {
        long startTime = System.currentTimeMillis();

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
}
