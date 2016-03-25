package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class RemoveCommand {

    @IXCommand(name = "xworld.remove", permission = "xworld.command.remove", usage = "/xworld remove [World]", aliases = {"xw.remove", "teamx.remove"}, description = "Removes an existing world from config")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
