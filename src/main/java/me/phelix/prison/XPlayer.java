package me.phelix.prison;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public final class XPlayer {

    private final String id;
    private Mine mine;

    public XPlayer(String id) {
        this.id = id;
    }

    public Mine getMine(){
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public String getId(){
        return id;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(UUID.fromString(id));
    }

}
