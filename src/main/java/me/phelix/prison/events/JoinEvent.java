package me.phelix.prison.events;

import me.phelix.prison.Prison;
import me.phelix.prison.XPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class JoinEvent implements Listener {

    private final Prison plugin;

    public JoinEvent(Prison plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if(!plugin.getPlayerHandler().getPlayerMap().containsKey(player.getUniqueId())) {
            final XPlayer xPlayer = new XPlayer(player.getUniqueId().toString());
            xPlayer.setMine(plugin.getMineHandler().getFirstMine());
            plugin.getPlayerHandler().getPlayerMap().put(player.getUniqueId(), xPlayer);
        }
    }

}
