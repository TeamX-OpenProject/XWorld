package org.teamx.xworldcore.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * @author Shustin
 */
public abstract class XEvent extends Event {

    public void event() {
        Bukkit.getPluginManager().callEvent(this);
    }

}
