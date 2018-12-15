package net.seliba.mcl;

/*
MaxChatLength created by Seliba
*/

import net.seliba.mcl.data.Config;
import net.seliba.mcl.listener.AsyncPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MaxChatLength extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[MCL] Started successfully!");
        Config config = new Config("config.yml", this);
        if(config.get("max-chat-length") == null) {
            config.set("max-chat-length", 100);
            config.set("bypass-permission", "mcl.bypass");
            config.set("message-too-long", "&cSorry, you are not allowed to send long messages!");
            config.save();
        }
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(config), this);
    }

}
