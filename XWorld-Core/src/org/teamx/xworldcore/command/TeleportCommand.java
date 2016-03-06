package org.teamx.xworldcore.command;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author Shustin
 */
public class TeleportCommand {


    @IXCommand(name = "xworld.test", permission = "xworld.test", usage = "/xworld test", aliases = {"xw.test", "teamx.test"}, description = "Testing some stuff!")
    public boolean teleportCommand(XCommand xCommand) {

        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        return true;
    }
}
