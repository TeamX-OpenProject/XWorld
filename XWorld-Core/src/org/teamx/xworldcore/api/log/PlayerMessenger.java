package org.teamx.xworldcore.api.log;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;

import java.util.logging.Level;

/**
 * @author lusu007
 */
public class PlayerMessenger {

    StringBuilder builder = new StringBuilder();

    /**
     * Creates a new Instance
     */
    public PlayerMessenger() {

    }

    /**
     * Builds the message and send it to a specified player
     * @param commandSender
     * @return
     */
    public PlayerMessenger sendMessage( CommandSender commandSender) {
        if( commandSender instanceof Player) {
            XWorldCore.getxLogger().logMessageToPlayer( Level.INFO, builder.toString(), (Player) commandSender );
            commandSender.sendMessage( builder.toString() );
        } else if ( commandSender instanceof ConsoleCommandSender) {
            XWorldCore.getxLogger().log(Level.WARNING, "Can't execute command as console", true);
        }
        return this;
    }

    /**
     * Add a title to your message
     * @return
     */
    public PlayerMessenger addTitle() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "============" + ChatColor.GRAY + "[" + ChatColor.YELLOW + "XWorld-Information" + ChatColor.GRAY + "]" + ChatColor.GOLD + "============\n" );
        return this;
    }

    /**
     * Add a footer to your message
     * @return
     */
    public PlayerMessenger addFooter() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "=========================================\n");
        return this;
    }

    /**
     * Add a line with the current/maximum page
     * @param current
     * @param max
     * @return
     */
    public PlayerMessenger addCurrentPageLine( int current, int max) {
        if ( current <= max && current > 0) {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [" + current + "/" + max + "]\n");
        } else {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [#ERROR!/" + max + "]\n");
        }
        return this;
    }

    /**
     * Add a line with the command for the next page
     * @param nextPage
     * @return
     */
    public PlayerMessenger addNextPageLine( int nextPage) {
        builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Goto next page with /xworld [" + nextPage + "]\n");
        return this;
    }

    /**
     * Add an empty line
     * @return
     */
    public PlayerMessenger addEmptyLine() {
        builder.append( XWorldCore.PREFIX + " \n" );
        return this;
    }

    /**
     * Add infos to your message
     * @param infos
     * @return
     */
    public PlayerMessenger addInformations( String... infos) {
        for ( String info : infos ) {
            builder.append( XWorldCore.PREFIX + ChatColor.YELLOW + info + "\n");
        }
        return this;
    }

    /**
     * Add one info to your message
     * @param info
     * @return
     */
    public PlayerMessenger addInformation( String info) {
        builder.append( XWorldCore.PREFIX + info + "\n");
        return this;
    }

    /**
     * Reset the hole message builder
     * @return
     */
    public PlayerMessenger clear() {
        builder.delete( 0, builder.length() );
        return this;
    }

    /**
     * Returns the Builder
     * @return
     */
    public StringBuilder getBuilder() {
        return builder;
    }
}
