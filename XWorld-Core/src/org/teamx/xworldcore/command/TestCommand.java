package org.teamx.xworldcore.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PlayerList;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.api.command.IXCommand;

/**
 * @author Shustin
 */
public class TestCommand {

    @IXCommand(name = "xworld.test", permission = "xworld.test", usage = "/xworl test", aliases = {"xw.test", "teamx.test"}, description = "Testing some stuff!")
    public void testCommand(XCommand xCommand) {

        Player player = xCommand.getPlayer();

        printHoverable(player, ChatColor.GOLD + "If you want to confirm thath click below: \n", ChatColor.GREEN + "Confirm!", "/xworld " + "confirm", ChatColor.GOLD + "Click here to confirm!");
    }

    public static void printHoverable(Player player, String ChatMsg, String ClickableMsg, String command, String HoverMsg) {
        BaseComponent[] hoverText = new ComponentBuilder(HoverMsg).create();
        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverText);
        BaseComponent[] clickableText = new ComponentBuilder(ClickableMsg).create();
        ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, command);
        BaseComponent[] message = new ComponentBuilder(ChatMsg).append(ClickableMsg).event(clickEvent).event(hoverEvent).create();
        PlayerList playerList = MinecraftServer.getServer().getPlayerList();
        player.spigot().sendMessage(message);
    }
}
