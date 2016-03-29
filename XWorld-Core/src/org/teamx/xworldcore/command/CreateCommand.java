package org.teamx.xworldcore.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;
import org.teamx.xworldcore.api.log.PlayerMessenger;

import java.io.File;

/**
 * @author lusu007
 * @author Shustin
 */
public class CreateCommand {

    private static XWorldCore plugin;

    PlayerMessenger playerMessenger = new PlayerMessenger();

    public CreateCommand() {
        this.plugin = XWorldCore.getInstance();
    }

    @IXCommand(name = "xworld.create", permission = "xworld.command.create", usage = "/xworld create [name]", aliases = {"xw.create", "teamx.create"}, description = "Creates a new world", minArgs = 1, maxArgs = 2 )
    public void createCommand(XCommand xCommand) {
        Player player = xCommand.getPlayer();
        String[] args = xCommand.getArguments();

        String name = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', args[0].toLowerCase()));
        File world = new File(plugin.getDataFolder() + "/worlds", name + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(world);
        Location loc = player.getLocation();

        if (world.exists()) {
            playerMessenger.addInformation(ChatColor.RED + "This world already exists").sendMessage(player);
        }
    }
}
