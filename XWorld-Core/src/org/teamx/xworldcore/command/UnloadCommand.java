package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class UnloadCommand {

    @IXCommand(name = "xworld.unload", permission = "xworld.command.unload", usage = "/xworld unload [Worldname]", aliases = {"xw.unload", "teamx.unload"}, description = "Unload's a specified world", minArgs = 1, maxArgs = 2 )
    public void xWorldCommand( XCommand xCommand ) {

    }
}
