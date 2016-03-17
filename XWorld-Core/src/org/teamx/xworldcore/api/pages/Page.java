package org.teamx.xworldcore.api.pages;

import org.teamx.xworldcore.api.log.PlayerMessenger;

/**
 * Created by lusu007 on 17.03.2016.
 */
public class Page extends PlayerMessenger {

    int currentPageNumber;
    int nextPageNumber;
    int maxPageNumber;

    public Page() {
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

    public void setPageNumbers( int current, int max ) {
        this.currentPageNumber = current;
        this.nextPageNumber = current + 1;
        this.maxPageNumber = max;

        if( nextPageNumber >= max ) {
            nextPageNumber = max;
        }
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
