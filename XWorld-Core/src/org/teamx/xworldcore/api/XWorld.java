package org.teamx.xworldcore.api;

import org.bukkit.*;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.permissions.Permission;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.world.IXWorld;
import org.teamx.xworldcore.api.world.IXWorldUtil;

import java.util.logging.Level;

/**
 * @lusu007
 * @Shustin
 */
public class XWorld implements IXWorld, IXWorldUtil {

    private String worldName;
    private WorldType worldType;
    private World.Environment environment;
    private ChunkGenerator chunkGenerator;
    private long seed;
    private Difficulty difficulty;
    private GameMode gameMode;
    private Permission accessPermission;
    private Permission exemptPermission;
    private ChatColor color;
    private ChatColor style;
    private String[] worldAliases;
    private Location spawn;
    private boolean animals;
    private boolean weather;
    private boolean mobs;
    private boolean storm;
    private boolean damage;
    private boolean bedRespawn;
    private boolean hunger;
    private boolean signTeleport;
    private boolean commandTeleport;
    private boolean fly;
    private boolean chat;
    private boolean blockbreak;
    private boolean pvp;
    private boolean naturalGeneration;
    private boolean old_combat;

    AttributeInstance attributeInstance;

    //TODO: edit the return statement!

    //XWorldCore.getInstance.getConfigManager

    public XWorld() {
    }




    @Override
    public void buildXWorld() {

    }

    @Override
    public void deleteXWorld(XWorld xWorld) {

    }

    @Override
    public void loadXWorld(World world) {
        Bukkit.getServer().getWorlds().add( Bukkit.getWorld( getWorldName() ) );
        XWorldCore.getInstance().getLogger().log( Level.INFO, XWorldCore.LOG_TAG + "Loaded world " + getWorldName() + "sucessfully!");
    }

    @Override
    public void unloadXWorld(XWorld xWorld) {

    }

    @Override
    public World getXWorld() {
        return null;
    }

    @Override
    public XWorld getXWorld(XWorld xworld) { //TODO: HOTFIX return type
        return new XWorld();
    }

    @Override
    public XWorld[] getXWorlds() {
        return new XWorld[ 0 ];
    }


    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public String getName() {
        return getXWorld().getName();
    }


    @Override
    public String getWorldName() {
        return null;
    }

    @Override
    public WorldType getWorldType() {
        return null;
    }

    @Override
    public World.Environment getEnvironment() {
        return null;
    }

    @Override
    public void setEnvironment(World.Environment environment) {

    }

    @Override
    public String getGenerator() {
        return null;
    }

    @Override
    public void setGenerator(String generator) {

    }

    @Override
    public long getSeed() {
        return 0;
    }

    @Override
    public void setSeed(long seed) {

    }

    @Override
    public Difficulty getDifficulty() {
        return null;
    }

    @Override
    public boolean setDifficulty(Difficulty difficulty) {
        return false;
    }

    @Override
    public GameMode getGameMode() {
        return null;
    }

    @Override
    public boolean setGamemode(GameMode gameMode) {
        return false;
    }

    @Override
    public Permission getAccesPermission() {
        return null;
    }

    @Override
    public Permission getExemptPermission() {
        return null;
    }

    @Override
    public ChatColor getColor() {
        return null;
    }

    @Override
    public boolean setColor(String color) {
        return false;
    }

    @Override
    public ChatColor getStyle() {
        return null;
    }

    @Override
    public void setStyle(String style) {

    }

    @Override
    public String[] getWorldAliases() {
        return null;
    }

    @Override
    public void setWorldAlias(String alias) {

    }

    @Override
    public Location getSpawn() {
        return null;
    }

    @Override
    public void setSpawn(Location spawnLocation) {

    }

    @Override
    public boolean getHunger() {
        return false;
    }

    @Override
    public void setHunger(boolean toggleHunger) {

    }

    @Override
    public boolean getSignTeleport() {
        return false;
    }

    @Override
    public void setSignTeleport(boolean toggleSignTeleport) {

    }

    @Override
    public boolean getCommandTeleport() {
        return false;
    }

    @Override
    public void setCommandTeleport(boolean toggleCommandTeleport) {

    }

    @Override
    public String getTime() {
        return null;
    }

    @Override
    public void setTime(String time) {

    }

    @Override
    public boolean getAllowFlight() {
        return false;
    }

    @Override
    public void setAllowFlight(boolean toggleAllowFlight) {

    }

    @Override
    public boolean getChatAllowed() {
        return false;
    }

    @Override
    public void setChatAllowed(boolean toggleChat) {

    }

    @Override
    public World getRespawnWorld() {
        return null;
    }

    @Override
    public boolean setRespawnWorld(String toggleRespawnWorld) {
        return false;
    }

    @Override
    public boolean getAllowBedRespawn() {
        return false;
    }

    @Override
    public void setAllowBedRespawn(boolean toggleAllowBedRespawn) {

    }

    @Override
    public boolean getNaturalGeneration() {
        return false;
    }

    @Override
    public void setNaturalGeneration(boolean toggleNaturalGeneration) {

    }

    @Override
    public boolean getAllowDamage() {
        return false;
    }

    @Override
    public void setAllowDamage(boolean toggleAllowDamage) {

    }

    @Override
    public boolean getDisableBlockBreak() {
        return false;
    }

    @Override
    public void setDisableBlockBreak(boolean toggleBlockBreak) {

    }

    @Override
    public boolean getGenerateStructure() {
        return false;
    }

    @Override
    public void setGenerateStructure(boolean toggleStructure) {

    }

    @Override
    public boolean getSpawnAnimals() {
        return false;
    }

    @Override
    public void setSpawnAnimals(boolean toggleSpawnAnimals) {

    }

    @Override
    public boolean getSpawnMonsters() {
        return false;
    }

    @Override
    public void setSpawnMonsters(boolean toggleSpawnMonsters) {

    }

    @Override
    public boolean getPvP() {
        return this.getXWorld().getPVP();
    }

    @Override
    public void setPvP(boolean togglePvP) {

    }

    @Override
    public boolean getPvPType() {
        return old_combat;
    }

    @Override
    public void setPvPType(boolean togglePvPType) {
        if(togglePvPType == true) {
            attributeInstance.setBaseValue(16);
        }
    }

    @Override
    public boolean getWeatherChange() {
        return false;
    }

    @Override
    public void setWeatherChange(boolean toggleWeatherChange) {

    }

    @Override
    public boolean getStorm() {
        return false;
    }

    @Override
    public void setStorm(boolean toggleStorm) {

    }

    @Override
    public boolean getNewInventory() {
        return false;
    }

    @Override
    public void setNewInventory(boolean toggleNewInventory) {

    }
}
