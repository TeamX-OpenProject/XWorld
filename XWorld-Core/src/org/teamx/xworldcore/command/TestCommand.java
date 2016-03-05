package org.teamx.xworldcore.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.minecraft.server.v1_9_R1.MinecraftServer;
import net.minecraft.server.v1_9_R1.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.command.IXCommand;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author Shustin
 */
public class TestCommand {

    private XWorldCore plugin;

    public TestCommand(XWorldCore plugin) {
        this.plugin = plugin;
    }

    @IXCommand(name = "xworld.test", permission = "xworld.test", usage = "/xworld test", aliases = {"xw.test", "teamx.test"}, description = "Testing some stuff!")
    public boolean testCommand(XCommand xCommand) {

        Player player = xCommand.getPlayer();
        World world = player.getWorld();
        String[] args = xCommand.getArguments();
        UUID uuid = world.getUID();

        if(xCommand.getArguments().length == 1) {
            sendClickableAndHoverable(player, ChatColor.GOLD + "If you want to confirm thath click below: \n", ChatColor.GREEN + "Confirm!", "/xworld " + "confirm", ChatColor.GOLD + "" + uuid);
            AttributeInstance attributeInstance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
            attributeInstance.setBaseValue(16D);
        } else if (xCommand.getArguments().length == 3) {
            String worldName = (String) args[1];
            String generator = (String) args[2];
            File worldFile = new File(this.plugin.getServer().getWorldContainer(), worldName);

            if (worldFile.exists()) {
                player.sendMessage("schon da");
                return false;
        }

            //WorldCreator worldCreator = new WorldCreator(worldName);

            //worldCreator.generator(generator);

            plugin.getConfigManager().newWorldConfig(new File(worldName));

           // worldCreator.createWorld();

            //Location location = Bukkit.getWorld(worldName).getSpawnLocation();

            //player.teleport(location);
        }

        return true;
    }

    public static void sendClickableAndHoverable(Player player, String ChatMsg, String ClickableMsg, String command, String HoverMsg) {
        BaseComponent[] hoverText = new ComponentBuilder(HoverMsg).create();
        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverText);
        BaseComponent[] clickableText = new ComponentBuilder(ClickableMsg).create();
        ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, command);
        BaseComponent[] message = new ComponentBuilder(ChatMsg).append(ClickableMsg).event(clickEvent).event(hoverEvent).create();
        PlayerList playerList;
        playerList = MinecraftServer.getServer().getPlayerList();
        player.spigot().sendMessage(message);
    }
}
