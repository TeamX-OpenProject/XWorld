package org.teamx.xworldcore.api.pages;

import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * Created by lusu007 on 17.03.2016.
 */
public class Page extends PlayerMessenger {

    int currentPageNumber;
    int nextPageNumber;
    int maxPageNumber;

    public Page( int currentPageNumber, int maxPageNumber ) {
        this.currentPageNumber = currentPageNumber;
        this.maxPageNumber = maxPageNumber;

        if( currentPageNumber == maxPageNumber ) {
            this.nextPageNumber = currentPageNumber;
            return;
        }

        this.nextPageNumber = currentPageNumber + 1;
    }

    public void addContent( String... contents ) {
        addTitle().
                addCurrentPageLine(currentPageNumber, maxPageNumber).
                addEmptyLine().
                addInformations( contents ).
                addEmptyLine().
                addNextPageLine(nextPageNumber).
                addFooter();
    }

    @Override
    public String toString() {
        return getBuilder().toString();
    }

    @Override
    public PlayerMessenger clear() {
        return super.clear();
    }
}
