package org.teamx.xworldcore.api.command;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

/**
 * @author Shustin
 */
public interface IXCommand {

    CommandSender getSender();

    String getLabel();

    boolean hasPermission();

    String[] getArguments();

    Location getLocation();

    public interface CommandBuilder {

        void setSender(CommandSender commandSender);

        void setLabel(String label);

        void setPermission(Permission permission);

        void setArguments(String[] arguments);

        void setLocation(Location location);

        public abstract IXCommand build();

    }

}
