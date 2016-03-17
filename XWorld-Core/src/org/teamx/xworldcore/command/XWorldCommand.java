package org.teamx.xworldcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;
import org.teamx.xworldcore.api.pages.PageManager;

/**
 * @author lusu007
 */
public class XWorldCommand {

    PageManager pageManager = new PageManager();

    @IXCommand(name = "xworld", permission = "xworld.command.xworld", usage = "/xworld", aliases = {"xw", "teamx"}, description = "This is the XWorld base command")
    public void xWorldCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        pageManager.addPage();
        pageManager.addPage();
        pageManager.setPageContent( 0, 2, "You running version: " + XWorldCore.getInstance().getDescription().getVersion(),
                "You currently loaded XX world's",
                "You currently have XX unloaded world's");
        pageManager.setPageContent( 1, 2, "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player");

        if( args.length == 0 ) {
            player.sendMessage( pageManager.getPage( 0 ) );
        }

        if( args.length > 0 ) {
            player.sendMessage( pageManager.getPage( Integer.parseInt( args[0] ) ) );
        }
    }
}
