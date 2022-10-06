package me.xaxis.deathmessages;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class DeathMessages  extends JavaPlugin{

    private Chat chat = null;

    @Override
    public void onEnable() {

        if(getServer().getPluginManager().getPlugin("Vault") == null){
            getLogger().log(Level.SEVERE, ChatColor.translateAlternateColorCodes('&', "DeathMessages couldn't find the plugin Vault!"));
            getPluginLoader().disablePlugin(this);
            return;
        } else if (getServer().getPluginManager().getPlugin("PermissionsEx") == null){
            getLogger().log(Level.SEVERE, ChatColor.translateAlternateColorCodes('&', "DeathMessages couldn't find the plugin PermissionsEx!"));
            getPluginLoader().disablePlugin(this);
            return;

        }

        // Plugin startup logic
        setupChat();
        new OnDeath(this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setupChat(){
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);

        chat = rsp.getProvider();
    }

    public Chat getChat(){
        return chat;
    }
}
