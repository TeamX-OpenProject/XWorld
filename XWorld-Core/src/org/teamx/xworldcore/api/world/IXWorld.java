package org.teamx.xworldcore.api.world;

import org.bukkit.*;
import org.bukkit.permissions.Permission;
import org.teamx.xworldcore.api.XWorld;

/**
 * World-Properties
 * @author Shustin
 */

public abstract interface IXWorld {

    /**
     *
     * Return a Bukkit world object
     *
     * @return <b>A {@link World}
     */

    World getXWorld();

    /**
     * Gets the name of this world object.
     * No way to change the name.
     * <p>
     * It is possible that you are looking for the alias
     *
     * @return <b>the name of this world as a string.
     */

    String getWorldName();

    /**
     * Gets the type of this world object.
     * It will be:
     * FLAT, NORMAL or VERSION_1_1
     *
     * @return <b>the type of this world.
     */

    WorldType getWorldType();

    /**
     * Gets the environment of this world
     *
     * @return <b> {@link org.bukkit.World.Environment}
     */

    World.Environment getEnvironment();

    /**
     * Sets the environment of this world.
     *
     * @param environment <b> {@link org.bukkit.World.Environment}
     */

    void setEnvironment(World.Environment environment);

    /**
     * Gets the generator of the world.
     *
     *
     * @return <b>the generator of this world.
     */

    String getGenerator();

    /**
     * Sets the generator of this world.
     * It could be a custom generator like EmptyWorldGenerator
     *
     * @param generator
     */

    void setGenerator(String generator);

    /**
     * Gets the seed of this world. I hope you know what a seed is.
     *
     * @return <b>the seed of the world as a long.
     */

    long getSeed();

    /**
     * Sets the seed of this world.
     *
     *
     * @param seed
     */

    void setSeed(long seed);

    /**
     * Gets the difficulty of this world.
     *
     * @return <b>the difficulty of this world.
     */

    Difficulty getDifficulty();

    /**
     * Sets the difficulty of this world.
     * The difficulty must be:
     * EASY, NORMAL, HARD or PEACEFUL.
     *
     * @param difficulty
     * @return <b>true on success.
     */

    boolean setDifficulty(Difficulty difficulty);

    /**
     * Gets the Gamemode of this world.
     *
     * @return the Gamemode of this world.
     */

    GameMode getGameMode();

    /**
     * Sets the Gamemode of this world.
     * The Gamemode must be:
     * SURVIVAL, ADVENTURE, CREATIVE or SPECTATOR.
     * default is SURVIVAL.
     *
     *
     * @param gameMode <b>true if changing Gamemode was successful.
     */

    boolean setGamemode(GameMode gameMode);

    /**
     * Gets the AccessPermission of this world.
     * A player needs the AccessPermission to go in this world.
     *
     * @return <b>AccessPermission as String
     */

    Permission getAccesPermission();

    /**
     * Gets the ExemptPermission of this world.
     * A player needs the ExemptPermission to go in this world.
     *
     * @return <b>ExemptPermission as String
     */

    Permission getExemptPermission();

    /**
     * Gets the ColorCode of this world name/alias.
     *
     * default is <b>ChatColor.WHITE</b>.
     *
     * @return <b>the ColorCode of this world name/alias.
     */

    ChatColor getColor();

    /**
     * Sets the ColorCode of this world name/alias.
     *
     * default is <b>ChatColor.WHITE</b>.
     *
     * @param color Require a valid ColorCode
     */

    boolean setColor(String color);

    /**
     * Gets the style of this world name/alias.
     *
     * @return <b>the ColorStyle of this world name/alias.
     */

    ChatColor getStyle();

    /**
     * Sets the ColorStyle of this world name/alias.
     * A valid ColorStyle is for example italic oder bold.
     *
     * @param style <b>Require a valid StyleCode like <p>&n</p>.
     */

    void setStyle(String style);

    /**
     * Gets the alias of this world name.
     *
     * @return <b>the alias of this world name as String.
     */

    String[] getWorldAliases();

    /**
     * Sets the alias of this world name.
     *
     * @param alias <b>the alias as String.
     */

    void setWorldAlias(String alias);

    /**
     * Gets the Spawn Location of this world.
     *
     * @return <b>the Spawn Location of this world.
     */

    Location getSpawn();

    /**
     * Sets the Spawn Location of this world.
     *
     * @param spawnLocation <b>Location where the spawn should be.
     */

    void setSpawn(Location spawnLocation);

    /**
     * Gets the hunger state of this world.
     *
     * @return <b>true if hunger is on and false if hunger is off.
     */

    boolean getHunger();

    /**
     * Sets the hunger state of this world.
     *
     * @param toggleHunger <b>Sets the hunger off/on.
     */

    void setHunger(boolean toggleHunger);

    /**
     * Gets whether or not SignTeleport is enabled for this world.
     * On true a player can teleport with a sign for this world.
     *
     * @return <b>true if SignTeleport is allowed, false if SignTeleport is disabled.
     */

    boolean getSignTeleport();

    /**
     * Sets whether or not SignTeleport is enabled in this world.
     *
     * @param toggleSignTeleport <b>Enable or disable SignTeleport.
     */

    void setSignTeleport(boolean toggleSignTeleport);

    /**
     * Gets whether or not CommandTeleport is enabled for this world.
     * On true a player can teleport with a sign for this world.
     *
     * @return <b>true if CommandTeleport is allowed, false if CommandTeleport is disabled.
     */

    boolean getCommandTeleport();

    /**
     * Sets whether or not CommandTeleport is enabled in this world.
     *
     * @param toggleCommandTeleport <b>Enable or disable CommandTeleport.
     */

    void setCommandTeleport(boolean toggleCommandTeleport);

    /**
     * Gets the time of this world.
     *
     * @return <b>the time of this world.
     */

    String getTime();

    /**
     * Sets the time in this world.
     *
     * @param time <b>The time of this world as String.
     */

    void setTime(String time);

    /**
     * Gets whether flying is allowed for this world.
     *
     * @return <b>true if flying is allowed, false if not.
     */

    boolean getAllowFlight();

    /**
     * Sets whether or not flying is allowed in this world.
     *
     * @param toggleAllowFlight <b>Allow or disable flying for this world.
     */

    void setAllowFlight(boolean toggleAllowFlight);

    /**
     * Gets whether the chat is enabled or disabled of this world.
     *
     * @return <b>true if allowed, false if not.
     */

    boolean getChatAllowed();

    /**
     * Sets whether the chat is enabled or disabled in this world.
     *
     * @param toggleChat <b>true for enable chat, false for disbale chat.
     */

    void setChatAllowed(boolean toggleChat);

    /**
     * Gets the respawn world.
     *
     * @return <b>the respawn world.
     */

    World getRespawnWorld();

    /**
     * Sets the respawn world.
     *
     * @param toggleRespawnWorld <b>Set world as respawn world.
     * @return <b>true if setting respawn world was successful.
     */

    boolean setRespawnWorld(String toggleRespawnWorld);

    /**
     * Gets whether bed respawn is enabled in this world.
     *
     * @return <b>true if enabled, false if not
     */

    boolean getAllowBedRespawn();

    /**
     * Sets whether bed respawn is enabled in this world.
     *
     * @param toggleAllowBedRespawn <b>true for enable, false for disable bed respawn.
     */

    void setAllowBedRespawn(boolean toggleAllowBedRespawn);

    /**
     * Gets whether natural generation is enabled or not in this world.
     *
     * @return <b>true if enabled, false if disabled.
     */

    boolean getNaturalGeneration();

    /**
     * Sets whether or not natural generation is enabled in this world.
     *
     * by default it is enabled.
     *
     * @param toggleNaturalGeneration <b>true for enable, false for disable.
     */

    void setNaturalGeneration(boolean toggleNaturalGeneration);

    /**
     * Gets whether or not damage on players is enabled in this world.
     *
     * @return <b>true for enabled, false for disabled.
     */

    boolean getAllowDamage();

    /**
     * Sets whether or not damage on players is enabled in this world.
     *
     * @param toggleAllowDamage <b>true for enable, false for disable.
     */

    void setAllowDamage(boolean toggleAllowDamage);

    /**
     * Gets whether or not BlockBreakEvent is canceled.
     *
     * by default it is false
     *
     * @return <b>true if canceled, false if not.
     */

    boolean getDisableBlockBreak();

    /**
     * Sets whether or not BlockBreakEvent is canceled.
     *
     * by default it is false
     *
     * @param toggleBlockBreak <b>true for cancel, false for nothing.
     */

    void setDisableBlockBreak(boolean toggleBlockBreak);

    /**
     * Gets whether or not the world generate structure.
     *
     * by default it is true
     *
     * @return <b>true if structure was generated, false if not.
     */

    boolean getGenerateStructure();

    /**
     * Sets whether or not structure should be generate in this world
     *
     * by default it is true
     *
     * @param toggleStructure <b>true for generate structure, false for not.
     */

    void setGenerateStructure(boolean toggleStructure);

    /**
     * Gets whether or not animals can spawn in this world.
     *
     * by default it is true
     *
     * @return <b>true if animals can spawn, false if not.
     */

    boolean getSpawnAnimals();

    /**
     * Sets whether or not animals can spawn in this world.
     *
     * by default it is true
     *
     * @param toggleSpawnAnimals <b>true for animals can spawn, false for not.
     */

    void setSpawnAnimals(boolean toggleSpawnAnimals);

    /**
     * Gets whether or not monsters can spawn in this world.
     *
     * by default it is true
     *
     * @return <b>true if monsters can spawn, false if not.
     */

    boolean getSpawnMonsters();

    /**
     * Sets whether or not monsters can spawn in this world.
     *
     * by default it is true
     *
     * @param toggleSpawnMonsters <b>true for monsters can spawn, false for not.
     */

    void setSpawnMonsters(boolean toggleSpawnMonsters);

    /**
     * Gets whether or not PvP is enabled in this world.
     *
     * by default it is true
     *
     * @return <b>true if enabled, false if not.
     */

    boolean getPvP();

    /**
     * Sets whether or not PvP is enabled in this world.
     *
     * by default it is true
     *
     * @param togglePvP <b>true for enable, false for disable.
     */

    void setPvP(boolean togglePvP);

    /**
     * Gets whether or not 1.9 combat is enabled in this world.
     *
     * by default it is true
     *
     * @return <b>true if enabled, false if not.
     */

    boolean getPvPType();

    /**
     * Sets whether or not 1.9 combat is enabled in this world.
     *
     * by default it is true
     *
     * @param togglePvPType <b>true for enable, false for disable.
     */

    void setPvPType(boolean togglePvPType);

    /**
     * Gets whether or not WeatherChange is enabled in this world.
     *
     * by default it is true
     *
     * @return <b>true if enabled, false if not.
     */

    boolean getWeatherChange();

    /**
     * Sets whether or not WeatherChange is enabled in this world.
     *
     * by default it is true
     *
     * @param toggleWeatherChange <b>true for enable, false for not.
     */

    void setWeatherChange(boolean toggleWeatherChange);

    /**
     * Gets whether or not storm is enabled in this world.
     *
     * by default it is true
     *
     * @return <b>true if enabled, false if not.
     */
    boolean getStorm();

    /**
     * Sets whether or not storm is enabled in this world.
     *
     * by default it is true
     *
     * @param toggleStorm <b>true for enable, false for not.
     */

    void setStorm(boolean toggleStorm);

    /**
     * Gets whether or not a new inventory is enabled in this world.
     *
     * by default it is false
     *
     * @return <b>true if enabled, false if not.
     */

    boolean getNewInventory();

    /**
     * Sets whether or not a new inventory is enabled in this world.
     *
     * by default it is false
     *
     * @param toggleNewInventory <b>true for enable, false for not.
     */

    void setNewInventory(boolean toggleNewInventory);


}
