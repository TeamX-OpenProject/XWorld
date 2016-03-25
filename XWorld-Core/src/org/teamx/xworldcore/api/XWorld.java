package org.teamx.xworldcore.api;

import org.bukkit.*;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.teamx.xworldcore.XWorldCore;
import org.teamx.xworldcore.api.world.IXWorld;
import org.teamx.xworldcore.api.world.IXWorldUtil;
import org.teamx.xworldcore.configuration.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @lusu007
 * @Shustin
 */
public class XWorld implements IXWorld {

    private String worldName;
    private WorldType worldType;
    private World.Environment environment;
    private String chunkGenerator;
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
    private boolean monsters;
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

    FileConfiguration worldConfiguration;

    //TODO: edit the return statements!

    private XWorldCore plugin = XWorldCore.getInstance();

    private ConfigManager configManager = XWorldCore.getInstance().getConfigManager();


    public XWorld(String name, long seed, World.Environment env, String generator, WorldType worldType) {
        this.worldName = name;
        this.seed = seed;
        this.environment = env;
        this.chunkGenerator = generator;
        this.worldType = worldType;
        this.gameMode = GameMode.SURVIVAL;
    }

    public XWorld(String name, World.Environment env, String generator, WorldType worldType) {
        this.worldName = name;
        this.environment = env;
        this.chunkGenerator = generator;
        this.worldType = worldType;
        this.gameMode = GameMode.SURVIVAL;
    }

    @Override
    public World getXWorld() {
        return null;
    }

    @Override
    public String getWorldName() {
        return this.worldName;
    }

    @Override
    public WorldType getWorldType() {
        return this.worldType;
    }

    @Override
    public World.Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public void setEnvironment(World.Environment environment) {

    }

    @Override
    public String getGenerator() {
        return this.chunkGenerator;
    }

    @Override
    public void setGenerator(String generator) {

    }

    @Override
    public long getSeed() {
        return this.seed;
    }

    @Override
    public void setSeed(long seed) {

    }

    @Override
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    @Override
    public boolean setDifficulty(Difficulty difficulty) {
        return false;
    }

    @Override
    public GameMode getGameMode() {
        return this.gameMode;
    }

    @Override
    public boolean setGamemode(GameMode gameMode) {
        return false;
    }

    @Override
    public Permission getAccesPermission() {
        return this.accessPermission;
    }

    @Override
    public Permission getExemptPermission() {
        return this.exemptPermission;
    }

    @Override
    public ChatColor getColor() {
        return this.color;
    }

    @Override
    public boolean setColor(String color) {
        return false;
    }

    @Override
    public ChatColor getStyle() {
        return this.style;
    }

    @Override
    public void setStyle(String style) {

    }

    @Override
    public String[] getWorldAliases() {
        return this.worldAliases;
    }

    @Override
    public void setWorldAlias(String alias) {

    }

    @Override
    public Location getSpawn() {
        return this.spawn;
    }

    @Override
    public void setSpawn(Location spawnLocation) {

    }

    @Override
    public boolean getHunger() {
        return this.hunger;
    }

    @Override
    public void setHunger(boolean toggleHunger) {

    }

    @Override
    public boolean getSignTeleport() {
        return this.signTeleport;
    }

    @Override
    public void setSignTeleport(boolean toggleSignTeleport) {

    }

    @Override
    public boolean getCommandTeleport() {
        return this.commandTeleport;
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
        return this.fly;
    }

    @Override
    public void setAllowFlight(boolean toggleAllowFlight) {

    }

    @Override
    public boolean getChatAllowed() {
        return this.chat;
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
        return this.bedRespawn;
    }

    @Override
    public void setAllowBedRespawn(boolean toggleAllowBedRespawn) {

    }

    @Override
    public boolean getNaturalGeneration() {
        return this.naturalGeneration;
    }

    @Override
    public void setNaturalGeneration(boolean toggleNaturalGeneration) {

    }

    @Override
    public boolean getAllowDamage() {
        return this.damage;
    }

    @Override
    public void setAllowDamage(boolean toggleAllowDamage) {

    }

    @Override
    public boolean getDisableBlockBreak() {
        return this.blockbreak;
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
        return this.animals;
    }

    @Override
    public void setSpawnAnimals(boolean toggleSpawnAnimals) {

    }

    @Override
    public boolean getSpawnMonsters() {
        return this.monsters;
    }

    @Override
    public void setSpawnMonsters(boolean toggleSpawnMonsters) {

    }

    @Override
    public boolean getPvP() {
        return this.pvp;
    }

    @Override
    public void setPvP(boolean togglePvP) {

    }

    @Override
    public boolean getPvPType() {
        return this.old_combat;
    }

    @Override
    public void setPvPType(boolean togglePvPType) {
        if(togglePvPType == true) {
            attributeInstance.setBaseValue(16);
        }
    }

    @Override
    public boolean getWeatherChange() {
        return this.weather;
    }

    @Override
    public void setWeatherChange(boolean toggleWeatherChange) {

    }

    @Override
    public boolean getStorm() {
        return this.storm;
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
