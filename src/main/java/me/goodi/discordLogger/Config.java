package me.goodi.discordLogger;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Config {

    private Logger logger;
    private File file;
    private YamlConfiguration yml;

    public void setup(File file, Logger logger){
        this.logger = logger;
        this.file = file;

        if(!file.exists()){
            file.mkdir();
        }

        yml = YamlConfiguration.loadConfiguration(file);

        yml.addDefault("token", "YOUR_DISCORD_BOT_TOKEN_HERE");
        yml.addDefault("discord-channel-id", "YOUR_CHANNEL_ID_HERE");

        yml.options().copyDefaults(true);
        save();

    }

    public void save(){
        try {
            yml.save(file);
        } catch (IOException e) {
            logger.severe("Failed to save config!");
        }
    }

    public void reload(){
        yml = YamlConfiguration.loadConfiguration(file);
    }

    public String getToken(){
        return yml.getString("token");
    }

    public String getChannelId(){
        return yml.getString("discord-channel-id");
    }


}
