package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * @author lusu007
 * @author Shustin
 */
public class ConfirmCommand {

    PlayerMessenger playerMessenger = new PlayerMessenger();

    @IXCommand(name = "xworld.confirm", permission = "", description = "Confirm actions!", aliases = {"xw.confirm", "teamx.confirm"}, usage = "You can't run this command without request")
    public boolean confirmCommand(XCommand xCommand) {
        playerMessenger.addInformation( "Confirm successfully!" ).sendMessage(xCommand.getPlayer());
        return true;
    }

}
