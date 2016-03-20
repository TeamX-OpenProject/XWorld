package org.teamx.xworldcore.api.pages;

import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * @author lusu007
 */
public class Page extends PlayerMessenger {

    int currentPageNumber;
    int nextPageNumber;
    int maxPageNumber;

    /**
     * Create a new Page
     * @param currentPageNumber
     * @param maxPageNumber
     */
    public Page( int currentPageNumber, int maxPageNumber ) {
        this.currentPageNumber = currentPageNumber;
        this.maxPageNumber = maxPageNumber;

        if( currentPageNumber == maxPageNumber ) {
            this.nextPageNumber = currentPageNumber;
            return;
        }

        this.nextPageNumber = currentPageNumber + 1;
    }

    /**
     * Add the content for this page
     * @param contents
     */
    public void addContent( String... contents ) {
        addTitle().
                addCurrentPageLine(currentPageNumber, maxPageNumber).
                addEmptyLine().
                addInformations( contents ).
                addEmptyLine().
                addNextPageLine(nextPageNumber).
                addFooter();
    }

    /**
     * Returns the Page as String
     * @return
     */
    @Override
    public String toString() {
        return getBuilder().toString();
    }

    /**
     * Clears the hole page
     * @return
     */
    @Override
    public PlayerMessenger clear() {
        return super.clear();
    }
}
