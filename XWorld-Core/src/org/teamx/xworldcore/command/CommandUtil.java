package org.teamx.xworldcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * @author Shustin
 */

public class CommandUtil implements CommandExecutor {

    private Map<String, Map.Entry<Method, Object>> commandMap = new HashMap<String, Map.Entry<Method, Object>>();
    private CommandMap map;
    private XWorldCore plugin;

    public CommandUtil() {
        this.plugin = XWorldCore.getInstance();

        if (plugin.getServer().getPluginManager() instanceof SimplePluginManager) {
            SimplePluginManager manager = (SimplePluginManager) plugin.getServer().getPluginManager();
            try {
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);
                map = (CommandMap) field.get(manager);
            } catch (IllegalArgumentException | SecurityException | IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return handleCommand(sender, cmd, label, args);
    }

    public boolean handleCommand(CommandSender commandSender, Command command, String label, String[] args) {
        for (int i = args.length; i >= 0; i--) {
            StringBuffer sb = new StringBuffer();
            sb.append(label.toLowerCase());
            for (int x = 0; x < i; x++) {
                sb.append("." + args[x].toLowerCase());
            }

            String cmdLabel = sb.toString();
            if (commandMap.containsKey(cmdLabel)) {
                Method method = commandMap.get(cmdLabel).getKey();
                Object methodObject = commandMap.get(cmdLabel).getValue();
                IXCommand cmd = method.getAnnotation(IXCommand.class);
                if (cmd.permission() != "" && !commandSender.hasPermission(cmd.permission())) {
                    commandSender.sendMessage(cmd.noPermission());
                    return true;
                }
                try {
                    method.invoke(methodObject, new XCommand(commandSender, command, cmdLabel.split("\\.").length - 1, label, args));
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return true;
    }


    public void registerCommands(Object object) {
        for (Method m : object.getClass().getMethods()) {
            if (m.getAnnotation(IXCommand.class) != null) {
                IXCommand command = m.getAnnotation(IXCommand.class);
                if (m.getParameterTypes().length > 1 || m.getParameterTypes()[0] != XCommand.class) {
                    XWorldCore.getxLogger().log( Level.WARNING, "In register commands is a failure!", false, true);
                    continue;
                }
                registerCommand(command, command.name(), m, object);
                for (String alias : command.aliases()) {
                    registerCommand(command, alias, m, object);
                }

            }
        }
    }

    public void registerCommand(IXCommand command, String label, Method method, Object object) {
        commandMap.put(label.toLowerCase(), new AbstractMap.SimpleEntry<Method, Object>(method, object));
        commandMap.put(this.plugin.getName() + ':' + label.toLowerCase(), new AbstractMap.SimpleEntry<Method, Object>(method, object));
        String cmdLabel = label.replace(".", ",").split(",")[0].toLowerCase();
        if (map.getCommand(cmdLabel) == null) {
            Command cmd = new BukkitCommand(cmdLabel, this, plugin);
            map.register(plugin.getName(), cmd);
        }
        if (!command.description().equalsIgnoreCase("") && cmdLabel == label) {
            map.getCommand(cmdLabel).setDescription(command.description());
        }
        if (!command.usage().equalsIgnoreCase("") && cmdLabel == label) {
            map.getCommand(cmdLabel).setUsage(command.usage());
        }
    }
}