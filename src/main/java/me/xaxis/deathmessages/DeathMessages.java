package me.xaxis.deathmessages;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathMessages extends JavaPlugin {

    private Permission perms = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        new OnDeath(this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setupPerms(){
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);

        perms = rsp.getProvider();
    }

    public Permission getPerms(){
        return perms;
    }

}
