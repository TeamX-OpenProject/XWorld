package org.teamx.xworldcore.command;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;
import org.teamx.xworldcore.api.pages.Page;
import org.teamx.xworldcore.api.pages.PageManager;

/**
 * @author lusu007
 */
public class XWorldCommand {



    @IXCommand(name = "xworld", permission = "xworld.command.xworld", usage = "/xworld [page]", aliases = {"xw", "teamx"}, description = "This is the XWorld base command")
    public void xWorldCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();
        PlayerMessenger playerMessenger = new PlayerMessenger();

        Page page1 = new Page( 1, 2 );
        page1.addContent( "You running version: " + XWorldCore.getInstance().getDescription().getVersion(),
                "You currently loaded XX world's",
                "You currently have XX unloaded world's" );

        Page page2 = new Page( 2, 2 );
        page2.addContent( "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player",
                "world - Loaded - NORMAL - 0 Player" );

        PageManager pageManager = new PageManager();
        pageManager.addPage( page1 );
        pageManager.addPage( page2 );

        if( args.length == 0 ) {
            pageManager.sendPageToPlayer( player, 1 );
        }

        if( args.length > 0 ) {
            pageManager.sendPageToPlayer( player, Integer.parseInt( args[0] ) );
        }
    }
}
