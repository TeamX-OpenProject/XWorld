package org.teamx.xworldcore.command;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * @author lusu007
 */
public class XWorldCommand {

    PlayerMessenger playerMessenger = new PlayerMessenger();

    @IXCommand(name = "xworld", permission = "xworld.command.xworld", usage = "/xworld", aliases = {"xw", "teamx"}, description = "This is the XWorld base command")
    public void xWorldCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        if(args.length == 0) {
            playerMessenger.addTitle()
                    .addCurrentPageLine(-1, 5)
                    .addEmptyLine()
                    .addInformations( "You running version: " + XWorldCore.getInstance().getDescription().getVersion(),
                            "You currently loaded XX world's",
                            "Yout currently have XX unloaded world's" )
                    .addEmptyLine()
                    .addNextPageLine(2)
                    .addFooter()
                    .sendMessage(player);
        }
    }
}
