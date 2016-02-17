package org.teamx.xworldcore.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/**
 *
 * @author lusu007
 *
 */
public class NMSPacket {

    private String packageName = Bukkit.getServer().getClass().getPackage().getName();
    private String version = packageName.substring(packageName.lastIndexOf(".") + 1);

    private Object packet;
    private Class<?> nmsPacket;

    /**
     * Creates a new NMSPacket
     * @param packetName
     */
    public NMSPacket(String packetName) {
        try {
            nmsPacket = Class.forName("net.minecraft.server." + version + "." + packet);
            packet = nmsPacket.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            packet = null;
            nmsPacket = null;
        }
    }

    /**
     * Sets the specified field
     * @param fieldName
     * @param value
     */
    public void setField(String fieldName, Object value) {
        try {
            Field field = packet.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(packet, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the specified declared field
     * @param fieldName
     * @param value
     */
    public void setDeclaredField(String fieldName, Object value) {
        try {
            Field field = packet.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(packet, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the specified field
     * @param fieldName
     * @return
     */
    public Object getField(String fieldName) {
        try {
            Field field = packet.getClass().getField(fieldName);
            field.setAccessible(true);
            Object object = field.get(packet);
            field.setAccessible(false);
            return object;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Returns the specified declared field
     * @param fieldName
     * @return
     */
    public Object getDeclaredField(String fieldName) {
        try {
            Field field = packet.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object object = field.get(packet);
            field.setAccessible(false);
            return object;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Returns the packet class
     * @return
     */
    public Class<?> getPacketClass() {
        return nmsPacket;
    }

    /**
     * Returns the packet as object
     * @return
     */
    public Object getPacket() {
        return packet;
    }

    /**
     * Checks if the packet is usable
     * @return
     */
    public boolean isUsable() {
        return packet != null;
    }

    /**
     * Send packet to a specified Player
     * @param player
     */
    public void sendPacket(Player player) {
        try {
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer" );

            if(!nmsPacket.isAssignableFrom(packet.getClass())) {
                throw new IllegalArgumentException("This Object is not a Packet!");
            }

            Object cp = craftPlayer.cast(player);
            Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
            Object con = handle.getClass().getField("playerConnection").get(handle);
            con.getClass().getMethod("sendPacket", nmsPacket).invoke(con, packet);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Send packet to all online Players
     */
    public void sendPacketToAll() {
        try {
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer" );

            Bukkit.getOnlinePlayers().forEach( player -> {
                try {
                    if(!nmsPacket.isAssignableFrom(packet.getClass())) {
                        throw new IllegalArgumentException("This Object is not a Packet!");                    }

                    Object cp = craftPlayer.cast(player);
                    Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
                    Object con = handle.getClass().getField("playerConnection").get(handle);
                    con.getClass().getMethod("sendPacket", nmsPacket).invoke(con, packet);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
