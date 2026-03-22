# MinecraftChatLogger

**MinecraftChatLogger** is a lightweight and easy-to-use Minecraft plugin that forwards all in-game chat messages directly to a designated Discord channel. Perfect for community servers, staff monitoring, or just keeping up with conversations while away from the game.

---

## 🔧 Features

-  Relays in-game chat to a specific Discord channel
-  Clean and readable message formatting
-  Simple configuration with just a bot token and channel ID
-  Asynchronous and lightweight — no lag on the main thread
-  Supports Minecraft 1.19–1.20+ (Spigot, Paper)

---



After first run, edit `config.yml`:

```yaml
token: "YOUR_DISCORD_BOT_TOKEN"
discord-channel-id: "123456789012345678"
```

## Notes
Only in-game chat is forwarded to Discord (no Discord → Minecraft)

Uses the JDA (Java Discord API) library
