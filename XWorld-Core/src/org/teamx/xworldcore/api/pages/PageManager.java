package org.teamx.xworldcore.api.pages;

import org.bukkit.entity.Player;
import org.teamx.xworldcore.api.log.PlayerMessenger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lusu007
 */
public class PageManager {

    Map<Integer, Page> pages = new HashMap<Integer, Page>();
    PlayerMessenger playerMessenger = new PlayerMessenger();

    public PageManager() {
    }

    /**
     * Add a page to the Manager
     * @param page
     */
    public void addPage( Page page ) {
        pages.put( pages.size() + 1, page );
    }

    /**
     * Remove a page with a specified ID
     * @param id
     */
    public void removePage( int id ) {
        pages.remove( id );
    }

    /**
     * Send a specified page to a player
     * @param player
     * @param id
     */
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

    /**
     * Test whether the page exists or not
     * @param id
     * @return
     */
    public boolean exists( int id ) {
        if( pages.containsKey( id ) ) {
            return true;
        }

        return false;
    }

    /**
     * Remove all pages from Manager
     */
    public void clearPages() {
        pages.clear();
    }
}
