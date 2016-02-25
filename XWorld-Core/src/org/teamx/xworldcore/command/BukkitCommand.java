package org.teamx.xworldcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * @author Shustin
 */
public class BukkitCommand extends Command {

    private final Plugin owner;
    private CommandExecutor executor;

    /**
     * A slimmed down PluginCommand
     *
     */
    protected BukkitCommand(String label, CommandExecutor executor, Plugin owner) {
        super(label);
        this.executor = executor;
        this.owner = owner;
        this.usageMessage = "";
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        boolean success = false;

        if (!owner.isEnabled()) {
            return false;
        }

        if (!testPermission(sender)) {
            return true;
        }

        try {
            success = executor.onCommand(sender, this, commandLabel, args);
        } catch (Throwable ex) {
            throw new CommandException("Executing command exception '" + commandLabel + "' in plugin "
                    + owner.getDescription().getFullName(), ex);
        }

        if (!success && usageMessage.length() > 0) {
            for (String line : usageMessage.replace("<command>", commandLabel).split("\n")) {
                sender.sendMessage(line);
            }
        }

        return success;
    }


}
