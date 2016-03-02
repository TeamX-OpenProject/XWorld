package org.teamx.xworldcore.api.log;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;

/**
 * @author lusu007
 */
public class PlayerMessager {

    StringBuilder builder = new StringBuilder();

    /**
     *
     */
    public PlayerMessager() {
    }

    /**
     *
     * @param player
     * @return
     */
    public PlayerMessager sendMessage(Player player) {
        player.sendMessage( builder.toString() );
        return this;
    }

    /**
     *
     * @return
     */
    public PlayerMessager addTitle() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "============" + ChatColor.GRAY + "[" + ChatColor.YELLOW + "XWorld-Information" + ChatColor.GRAY + "]" + ChatColor.GOLD + "============\n" );
        return this;
    }

    /**
     *
     * @return
     */
    public PlayerMessager addFooter() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "=========================================\n");
        return this;
    }

    /**
     *
     * @param current
     * @param max
     * @return
     */
    public PlayerMessager addCurrentPageLine(int current, int max) {
        if ( current <= max && current > 0) {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [" + current + "/" + max + "]\n");
        } else {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [#ERROR!/" + max + "]\n");
        }
        return this;
    }

    /**
     *
     * @param nextPage
     * @return
     */
    public PlayerMessager addNextPageLine(int nextPage) {
        builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Goto next page with /xworld [" + nextPage + "]\n");
        return this;
    }

    /**
     *
     * @return
     */
    public PlayerMessager addEmptyLine() {
        builder.append( XWorldCore.PREFIX + " \n" );
        return this;
    }

    /**
     *
     * @param infos
     * @return
     */
    public PlayerMessager addInformations(String... infos) {
        for ( String info : infos ) {
            builder.append( XWorldCore.PREFIX + ChatColor.YELLOW + info + "\n");
        }
        return this;
    }


}
