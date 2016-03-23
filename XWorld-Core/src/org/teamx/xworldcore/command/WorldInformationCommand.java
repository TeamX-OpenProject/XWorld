package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class WorldInformationCommand {

    @IXCommand(name = "xworld.info", permission = "xworld.command.worldinfo", usage = "/xworld info [Worldname]", aliases = {"xw", "teamx"}, description = "Send you informations from a specified world")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
