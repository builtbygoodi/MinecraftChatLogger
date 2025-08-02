package me.goodi.discordLogger.commands;

import me.goodi.discordLogger.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadConfig implements CommandExecutor {

    private Config config;

    public ReloadConfig(Config config){
        this.config = config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if(sender.hasPermission("DiscordLogger.reloadconfig")){
            config.reload();
        }

        return false;
    }
}
