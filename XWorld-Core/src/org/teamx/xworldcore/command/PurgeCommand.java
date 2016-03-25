package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class PurgeCommand {

    @IXCommand(name = "xworld.purge", permission = "xworld.command.purge", usage = "/xworld purge [World]", aliases = {"xw.purge", "teamx.purge"}, description = "Purge a world with config and the hole world folder")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
