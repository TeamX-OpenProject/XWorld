package org.teamx.xworldcore.api;

import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldType;

/**
 * Created by lusu007 on 17.02.2016.
 */
public class XWorld implements IXWorld {

    @Override
    public World getXWorld() {
        return null;
    }

    @Override
    public String getWorldName() {
        return null;
    }

    @Override
    public Difficulty getDifficulty() {
        return null;
    }

    @Override
    public void setDifficulty( Difficulty difficulty ) {

    }

    @Override
    public long getSeed() {
        return 0;
    }

    @Override
    public void setSeed( long seed ) {

    }

    @Override
    public WorldType getWorldType() {
        return null;
    }

    @Override
    public void setWorldType( WorldType worldType ) {

    }

    @Override
    public GameMode getGameMode() {
        return null;
    }

    @Override
    public void setGameMode( GameMode gameMode ) {

    }

    @Override
    public World.Environment getEnviroment() {
        return null;
    }

    @Override
    public void setEnviroment(World.Environment enviroment) {

    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public void setPermission(String permission) {

    }

    @Override
    public boolean animals() {
        return false;
    }

    @Override
    public void setAnimals(boolean toggleAnimals) {

    }

    @Override
    public boolean monsters() {
        return false;
    }

    @Override
    public void setMonsters(boolean toggleMonsters) {

    }

    @Override
    public boolean getWeatherChange() {
        return false;
    }

    @Override
    public void setWeatherChange(boolean toggleWeatherChange) {

    }
}
