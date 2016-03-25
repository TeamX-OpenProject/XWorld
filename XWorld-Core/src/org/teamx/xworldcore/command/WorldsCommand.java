package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class WorldsCommand {

    @IXCommand(name = "xworld.worlds", permission = "xworld.command.worlds", usage = "/xworld worlds", aliases = {"xw", "teamx"}, description = "Print's out a list of all existing world's")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
