package org.teamx.xworldcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Shustin
 */
public class XCommand {

    private CommandSender commandSender;
    private Command command;
    private String[] arguments;
    private String label;


    protected XCommand(CommandSender commandSender, Command command, int multiCommand, String label, String[] args) {

        String[] subCommands = new String[args.length - multiCommand];

        for(int i = 0; i < args.length - multiCommand; i++) {
            subCommands[i] = args[i + multiCommand];
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(label);
        for(int i = 0; i < multiCommand; i++) {
            stringBuilder.append("." + args[i]);
        }

        String commandLabel = stringBuilder.toString();
        this.commandSender = commandSender;
        this.command = command;
        this.label = label;
        this.arguments = args;
    }


    public CommandSender getCommandSender() {
        return commandSender;
    }

    public Player getPlayer() {
        if (commandSender instanceof Player) {
            return (Player) commandSender;
        }
        return null;
    }

    public boolean isPlayer() {
        return commandSender instanceof Player;
    }


    public Command getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getLabel() {
        return label;
    }

    public int length() {
        return arguments.length;
    }

    public String getArgumentsAt(int index) {
        return arguments[index];
    }

    public String getKeyG() {
        String key = null;
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].equalsIgnoreCase("-g")) {
                key = arguments[i] + 1;
            }
        }

        if(key != null) {
            return key;
        } else {
            return null;
        }
    }

    public String getKeyS() {
        String key = null;
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].equalsIgnoreCase("-s")) {
                key = arguments[i] + 1;
            }
        }

        if(key != null) {
            return key;
        } else {
            return null;
        }
    }


}
