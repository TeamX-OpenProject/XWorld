package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessager;

/**
 * @author lusu007
 * @author Shustin
 */
public class ConfirmCommand {

    PlayerMessager playerMessager = new PlayerMessager();

    @IXCommand(name = "xworld.confirm", description = "Confirm actions!", aliases = {"xw.confirm", "teamx.confirm"}, usage = "You can't run this command without request", permission = "")
    public boolean confirmCommand(XCommand xCommand) {
        playerMessager.addInformation( "Confirm successfully!" ).sendMessage(xCommand.getPlayer());
        return true;
    }

}
