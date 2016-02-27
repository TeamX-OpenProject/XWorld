package org.teamx.xworldcore.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;

import java.io.File;

/**
 * @author Shustin
 */
public class CreateCommand {

    private static XWorldCore plugin;
    private static final String PREFIX = plugin.PREFIX;

    public CreateCommand(XWorldCore plugin) {
        this.plugin = plugin;
    }

    @IXCommand()
    public void createCommand(XCommand xCommand) {



        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        String name = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', args[0].toLowerCase()));
        File world = new File(plugin.getDataFolder(), name + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(world);
        Location loc = player.getLocation();

        if (world.exists()) {
            player.sendMessage(PREFIX + ChatColor.RED + "This world already exists");
        }


    }
}
