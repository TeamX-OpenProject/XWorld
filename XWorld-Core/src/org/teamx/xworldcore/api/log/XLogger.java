package org.teamx.xworldcore.api.log;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.teamx.xworldcore.XWorldCore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * @author lusu007
 */
public class XLogger {
    private File file;
    private File directory;

    /**
     * Create a new XLogger
     */
    public XLogger() {
        if (file == null) {
            if(directory == null) {
                directory = new File( XWorldCore.getInstance().getDataFolder() + "/log/" );
                directory.mkdir();
            }
            file = new File(XWorldCore.getInstance().getDataFolder() + "/log/log.txt");
        }
    }

    /**
     * Log a message to file. If the boolean is true the log message would be send to the console too.
     * @param loggingLevel
     * @param message
     * @param isDebug
     * @param console
     */
    public void log(Level loggingLevel, String message, boolean isDebug, boolean console) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
        String logDate = format.format( date );

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter( XWorldCore.getInstance().getDataFolder() + "/log/log.txt", true );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        if( isDebug == true && XWorldCore.getConfigManager().getConfigConfiguration().getBoolean( "debug" ) == false ) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( "[" + logDate + "] " )
                .append( "[XWorldCore/" + loggingLevel.getName() + "]: " )
                .append( message );

        if ( console == true ) {
            XWorldCore.getInstance().getLogger().log( loggingLevel, message );
        }

        try {
            fileWriter.write( stringBuilder.toString() );
            fileWriter.append( System.getProperty( "line.separator" ) );
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( fileWriter != null ) {
                try {
                    fileWriter.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Log messages which will be send to a player in-game. The methode split's the message by \n
     * @param info
     * @param message
     * @param player
     */
    public void logMessageToPlayer(Level info, String message, Player player) {
        XWorldCore.getxLogger().log(Level.INFO, "--- BEGINNING OF MESSAGE --- ", false, false);
        XWorldCore.getxLogger().log(Level.INFO, "Send following message to " + player.getName() + ":", false, false);
        for( String s : message.split("\n") ) {
            XWorldCore.getxLogger().log( Level.INFO, ChatColor.stripColor(s), false, false);
        }
        XWorldCore.getxLogger().log(Level.INFO, "---    END OF MESSAGE    --- ", false, false);
    }
}
