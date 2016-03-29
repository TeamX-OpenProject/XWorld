package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class SetSpawnCommand {

    @IXCommand(name = "xworld.setspawn", permission = "xworld.command.setspawn", usage = "/xworld setspawn", aliases = {"xw.setspawn", "teamx.setspawn"}, description = "Set the spawn for the current world", minArgs = 1, maxArgs = 2 )
    public void xWorldCommand( XCommand xCommand ) {

    }
}
