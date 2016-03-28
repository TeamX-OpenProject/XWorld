package org.teamx.xworldcore.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.teamx.xworldcore.XWorldCore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lusu007
 */
public class Config {

    private YamlConfiguration configFile;
    private File file;
    private boolean loaded = false;
    private XWorldCore plugin;
    private String fileName;

    public Config( String fileName ) {
        this.plugin = XWorldCore.getInstance();
        this.fileName = fileName;
    }

    public YamlConfiguration getConfig() {
        return configFile;
    }

    public File getConfigFile() {
        if( !loaded ) {
            loadConfig();
        }
        return file;
    }

    public void loadConfig() {
        file = new File( Bukkit.getServer().getPluginManager().getPlugin( this.plugin.getName() ).getDataFolder(), fileName );

        if( file.exists() ) {
            configFile = new YamlConfiguration();

            try {
                configFile.load( file );
            } catch ( InvalidConfigurationException | IOException e ) {
                e.printStackTrace();
            }

            loaded = true;
        } else {
            try {
                Bukkit.getServer().getPluginManager().getPlugin( plugin.getName() ).getDataFolder().mkdir();
                InputStream jarURL = Config.class.getResourceAsStream( "/" + fileName );
                copyFile( jarURL, file );
                configFile = new YamlConfiguration();
                configFile.load( file );
                loaded = true;
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

    private void copyFile( InputStream in, File out ) throws Exception {
        InputStream inputStream = in;
        FileOutputStream fileOutputStream = new FileOutputStream(out);
        try {
            byte[] buf = new byte[1024];
            int i = 0;

            while ( ( i = inputStream.read( buf ) ) != -1 ) {
                fileOutputStream.write( buf, 0, i );
            }
        } catch ( Exception e ) {
            throw e;
        } finally {
            if( inputStream != null ) {
                inputStream.close();
            }

            if( fileOutputStream != null ) {
                fileOutputStream.close();
            }
        }
    }
}
