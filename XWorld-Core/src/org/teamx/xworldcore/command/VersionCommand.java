package org.teamx.xworldcore.command;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * @author lusu007
 */
public class VersionCommand {

    @IXCommand(name = "xworld.version", permission = "xworld.command.version", usage = "/xworld", aliases = {"xw", "teamx"}, description = "Print's out the current version of XWorld")
    public void xWorldCommand( XCommand xCommand ) {
        Player player = xCommand.getPlayer();
        PlayerMessenger playerMessenger = new PlayerMessenger();

        playerMessenger.addTitle()
                .addEmptyLine()
                .addInformation( "You are using version: " + XWorldCore.getInstance().getDescription().getVersion() )
                .addEmptyLine()
                .addFooter()
                .sendMessage( player )
                .clear();
        return;
    }
}
