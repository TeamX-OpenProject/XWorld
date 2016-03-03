package org.teamx.xworldcore.event;

import org.teamx.xworldcore.api.world.IXWorld;

/**
 * @author Shustin
 */
public abstract class XWorldEvent extends XEvent{

    private final IXWorld world;

    public XWorldEvent(IXWorld world) {
        this.world = world;
    }
}
