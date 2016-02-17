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
    public GameMode getGamemode() {
        return null;
    }

    @Override
    public void setGameMode( GameMode gameMode ) {

    }
}
