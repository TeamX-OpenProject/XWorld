package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class ImportCommand {

    @IXCommand(name = "xworld.import", permission = "xworld.command.import", usage = "/xworld import [World]", aliases = {"xw.import", "teamx.import"}, description = "Import a world from a world folder")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
