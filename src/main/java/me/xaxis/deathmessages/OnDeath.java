package me.xaxis.deathmessages;


import org.bukkit.ChatColor;
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

            String rank = plugin.getChat().getPlayerPrefix(player) + plugin.getChat().getPlayerSuffix(player);

            if(player.getKiller() != null){

                Player killer = player.getKiller();

                String killerRank = plugin.getChat().getPlayerPrefix(killer) + plugin.getChat().getPlayerSuffix(killer);

                if(event.getDeathMessage().contains("was shot by")){

                    event.setDeathMessage(chat(killerRank + "&f" + killer.getName() + "&7 has shot " + rank + "&f" + player.getName()));

                    return;

                }

                event.setDeathMessage(chat(killerRank + "&f" + killer.getName() + "&7 has killed " + rank + "&f" + player.getName()));

                return;

            }

            event.setDeathMessage(null);

        }

    }

    public String chat(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
