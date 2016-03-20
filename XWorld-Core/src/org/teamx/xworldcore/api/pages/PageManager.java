package org.teamx.xworldcore.api.pages;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.api.log.PlayerMessenger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lusu007 on 13.03.2016.
 */
public class PageManager {

    Map<Integer, Page> pages = new HashMap<Integer, Page>();

    PlayerMessenger playerMessenger = new PlayerMessenger();

    public PageManager() {
    }

    public void addPage( Page page ) {
        pages.put( pages.size() + 1, page );
    }

    public void removePage( int id ) {
        pages.remove( id );
    }

    public void sendPageToPlayer( Player player, int id ) {
        if( !pages.containsKey( id ) ) {
            playerMessenger.addInformation( "Page " + id + " does not exists! Try another page number!" );
            playerMessenger.sendMessage( player );
            return;
        }

        if( id < 0 ) {
            pages.get( 0 ).sendMessage( player );
            return;
        }

        pages.get( id ).sendMessage( player );
    }

    public boolean exists( int id ) {
        if( pages.containsKey( id ) ) {
            return true;
        }

        return false;
    }

    public void clearPages() {
        pages.clear();
    }
}
