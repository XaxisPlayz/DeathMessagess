package me.xaxis.deathmessages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    private final DeathMessages plugin;

    public OnDeath(DeathMessages plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){

        if(plugin.getConfig().getBoolean("DeathMessages.enabled")){

            Player player = event.getEntity();

            String rank = plugin.getPerms().getPrimaryGroup(player);

            event.setDeathMessage(rank + player.getName());

        }

    }
}
