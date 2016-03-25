package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class SetSpawnCommand {

    @IXCommand(name = "xworld.setspawn", permission = "xworld.command.setspawn", usage = "/xworld setspawn", aliases = {"xw.setspawn", "teamx.setspawn"}, description = "Set the spawn for the current world")
    public void xWorldCommand( XCommand xCommand ) {

    }
}
