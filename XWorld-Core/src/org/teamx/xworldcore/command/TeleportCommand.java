package org.teamx.xworldcore.command;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class TeleportCommand {


    @IXCommand(name = "xworld.teleport", permission = "xworld.command.teleport", usage = "/xworld teleport {Player}[Worldname]", aliases = {"xw.teleport", "teamx.teleport"}, description = "Teleports you or another player to a specified world", minArgs = 1, maxArgs = 2 )
    public boolean teleportCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        return true;
    }
}
