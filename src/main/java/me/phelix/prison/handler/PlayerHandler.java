package me.phelix.prison.handler;

import me.phelix.prison.XPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PlayerHandler {

    private final Map<UUID, XPlayer> playerMap = new HashMap<>();

    public Map<UUID, XPlayer> getPlayerMap() {
        return playerMap;
    }

    public XPlayer getByID(String id) {
        return playerMap.get(UUID.fromString(id));
    }

    public XPlayer getByID(UUID uuid) {
        return playerMap.get(uuid);
    }

    public XPlayer getByPlayer(Player player) {
        return playerMap.get(player.getUniqueId());
    }

    public XPlayer getByName(String name) {
        return playerMap.get(Bukkit.getOfflinePlayer(name).getUniqueId());
    }

}
