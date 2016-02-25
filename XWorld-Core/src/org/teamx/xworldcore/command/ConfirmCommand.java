package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author Shustin
 */
public class ConfirmCommand {

    @IXCommand(name = "xworld.confirm", description = "Confirm actions!", aliases = {"xw.confirm", "teamx.confirm"}, usage = "You can't run this command without request", permission = "")
    public boolean confirmCommand(XCommand xCommand) {
        xCommand.getCommandSender().sendMessage("CONFIRM SUCCESSFUL");
        return true;
    }

}
