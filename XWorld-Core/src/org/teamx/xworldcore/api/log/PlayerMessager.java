package org.teamx.xworldcore.api.log;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;

/**
 * Created by lusu007 on 02.03.2016.
 */
public class PlayerMessager {

    StringBuilder builder = new StringBuilder();

    public PlayerMessager() {
    }

    public PlayerMessager sendMessage(Player player) {
        player.sendMessage( builder.toString() );
        return this;
    }

    public PlayerMessager addTitle() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "============" + ChatColor.GRAY + "[" + ChatColor.YELLOW + "XWorld-Information" + ChatColor.GRAY + "]" + ChatColor.GOLD + "============\n" );
        return this;
    }

    public PlayerMessager addFooter() {
        builder.append( XWorldCore.PREFIX + ChatColor.GOLD + "=========================================\n");
        return this;
    }

    public PlayerMessager addCurrentPageLine(int current, int max) {
        if ( current <= max && current > 0) {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [" + current + "/" + max + "]\n");
        } else {
            builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Page [#ERROR!/" + max + "]\n");
        }
        return this;
    }

    public PlayerMessager addNextPageLine(int nextPage) {
        builder.append( XWorldCore.PREFIX + ChatColor.BOLD + "Goto next page with /xworld [" + nextPage + "]\n");
        return this;
    }

    public PlayerMessager addEmptyLine() {
        builder.append( XWorldCore.PREFIX + " \n" );
        return this;
    }

    public PlayerMessager addInformations(String... infos) {
        for ( String info : infos ) {
            builder.append( XWorldCore.PREFIX + ChatColor.YELLOW + info + "\n");
        }
        return this;
    }


}
