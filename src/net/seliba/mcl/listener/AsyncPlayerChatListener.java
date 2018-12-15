package net.seliba.mcl.listener;

/*
MaxChatLength created by Seliba
*/

import net.seliba.mcl.data.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private Config config;

    public AsyncPlayerChatListener(Config config) {
        this.config = config;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission(config.getString("bypass-permission"))) {
            return;
        }
        if(event.getMessage().toCharArray().length > config.getInt("max-chat-length")) {
            event.setCancelled(true);
            player.sendMessage(config.getTranslatedString("message-too-long"));
        }
    }

}
