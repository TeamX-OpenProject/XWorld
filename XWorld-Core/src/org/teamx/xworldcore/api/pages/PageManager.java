package org.teamx.xworldcore.api.pages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusu007 on 13.03.2016.
 */
public class PageManager {

    List<Page> pages = new ArrayList<>();

    public PageManager() {
    }

    public void addPage() {
        Page page = new Page();
        pages.add( page );
    }

    public void removePage(int id) {
        pages.remove( id );
    }

    public void setPageContent( int id, int maxPages, String... contents ) {
        pages.get( id ).setPageNumbers( id + 1, maxPages );
        pages.get( id ).addContent( contents );
    }

    public String getPage( int id ) {
        if( id < 0 ) {
            return pages.get( 0 ).toString();
        }

        return pages.get( id ).toString();
    }

    public void clearPages() {
        pages.clear();
    }
}
