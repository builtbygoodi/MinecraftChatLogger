package me.goodi.discordLogger.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.goodi.discordLogger.DiscordLogger;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class MinecraftChatListener implements Listener {

    private final DiscordLogger plugin;

    public MinecraftChatListener(DiscordLogger plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void chat(AsyncChatEvent e){
        Player player = e.getPlayer();

        String message = PlainTextComponentSerializer.plainText().serialize(e.message());

        plugin.getTextChannel().sendMessage(player.getName() + ": " + message).queue();

    }

}
