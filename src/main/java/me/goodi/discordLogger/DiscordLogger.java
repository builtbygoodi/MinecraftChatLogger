package me.goodi.discordLogger;

import me.goodi.discordLogger.commands.ReloadConfig;
import me.goodi.discordLogger.listeners.MinecraftChatListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DiscordLogger extends JavaPlugin {

    private Config config;
    private JDA jda;
    private TextChannel discordChannel;

    @Override
    public void onEnable() {

        config = new Config();
        config.setup(new File(getDataFolder(), "/config.yml"), getLogger());

        try {
            jda = JDABuilder.createDefault(config.getToken()).build().awaitReady();
            discordChannel = jda.getTextChannelById(config.getChannelId());
            if (discordChannel == null) {
                getLogger().severe("Discord channel ID is invalid!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            getLogger().severe("Failed to initialize Discord bot.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(new MinecraftChatListener(this), this);
        getCommand("reloadconfig").setExecutor(new ReloadConfig(config));

    }

    @Override
    public void onDisable() {
        if (jda != null) {
            jda.shutdown();
        }
    }

    public JDA getJda(){
        return jda;
    }

    public TextChannel getTextChannel(){
        return discordChannel;
    }
}
