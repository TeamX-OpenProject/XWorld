package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class CloneCommand {

    @IXCommand(name = "xworld.clone", permission = "xworld.command.clone", usage = "/xworld clone [World] [New Worldname]", aliases = {"xw.clone", "teamx.clone"}, description = "Clone an existing world", minArgs = 1, maxArgs = 2 )
    public void xWorldCommand( XCommand xCommand ) {

    }
}
