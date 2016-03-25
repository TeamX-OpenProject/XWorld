package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class LoadCommand {

    @IXCommand(name = "xworld.load", permission = "xworld.command.load", usage = "/xworld load [World]", aliases = {"xw.load", "teamx.load"}, description = "Load an unloaded world")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
