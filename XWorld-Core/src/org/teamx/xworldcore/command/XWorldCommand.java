package org.teamx.xworldcore.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class XWorldCommand {

    @IXCommand(name = "xworld", permission = "xworld.command.xworld", usage = "/xworld", aliases = {"xw", "teamx"}, description = "This is the XWorld base command")
    public void xWorldCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        if(args.length == 0) {
            StringBuilder builder = new StringBuilder();
            builder.append( XWorldCore.PREFIX + "============[XWorld-Informations]============" );
            builder.append( XWorldCore.PREFIX + ChatColor.ITALIC + "Page [1/x]\n"); //TODO: Get max Pages
            builder.append( XWorldCore.PREFIX + "You running version: " + XWorldCore.getInstance().getDescription().getVersion() + "\n");
            builder.append( XWorldCore.PREFIX + "You currently loaded XX world's" + "\n"); //TODO: Get currently loaded world's
            builder.append( XWorldCore.PREFIX + "You currently have XX unloaded world's\n" ); //TODO: Get currently unloaded world's
            builder.append( XWorldCore.PREFIX + ChatColor.ITALIC + "Goto next page with /xworld [page]"); //TODO: Get max Pages
            builder.append( XWorldCore.PREFIX + "=============================================\n");

            player.sendMessage( builder.toString() );
        }
    }
}
