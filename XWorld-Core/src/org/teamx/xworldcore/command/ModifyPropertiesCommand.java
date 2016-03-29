package org.teamx.xworldcore.command;

import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author lusu007
 */
public class ModifyPropertiesCommand {

    @IXCommand(name = "xworld.modify", permission = "xworld.command.modify", usage = "/xworld modify {World} [Key] [Value]", aliases = {"xw.modify", "teamx.modify"}, description = "Modify a property from the configuration file or a world configuration file", minArgs = 1, maxArgs = 2 )
    public void xWorldCommand( XCommand xCommand ) {

    }
}
