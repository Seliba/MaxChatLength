package net.seliba.mcl;

/*
MaxChatLength created by Seliba
*/

import net.seliba.mcl.data.Config;
import net.seliba.mcl.listener.AsyncPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class MaxChatLength extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[MCL] Started successfully!");
        Config config = new Config("config.yml", this);
        if(config.get("max-chat-length") == null) {
            List<String> ignoredWorlds = Arrays.asList(new String[]{"IgnoredWorld"});
            List<String> ignoredUUIDs = Arrays.asList(new String[]{"f84c6a79-0a4e-45e0-879b-cd49ebd4c4e2"});
            List<String> ignoredNames = Arrays.asList(new String[]{"Steve"});

            config.set("max-chat-length", 100);
            config.set("bypass-permission", "mcl.bypass");
            config.set("ignored-worlds", ignoredWorlds);
            config.set("ignored-names", ignoredNames);
            config.set("ignored-uuids", ignoredUUIDs);
            config.set("message-too-long", "&cSorry, you are not allowed to send long messages!");
            config.save();
        }
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(config), this);
    }

}
