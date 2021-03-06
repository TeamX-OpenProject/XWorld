package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class WorldInformationCommand {

    @IXCommand(name = "xworld.info", permission = "xworld.command.worldinfo", usage = "/xworld info [Worldname]", aliases = {"xw.info", "teamx.info"}, description = "Send you informations from a specified world", minArgs = 1, maxArgs = 2 )
    public void xWorldCommand( XCommand xCommand ) {

    }
}
