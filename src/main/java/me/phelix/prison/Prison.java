package me.phelix.prison;

import me.phelix.prison.commands.CommandHandler;
import me.phelix.prison.events.BlockBreak;
import me.phelix.prison.events.JoinEvent;
import me.phelix.prison.handler.ChunkHandler;
import me.phelix.prison.handler.MineHandler;
import me.phelix.prison.handler.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Prison extends JavaPlugin {

    private PlayerHandler playerHandler;
    private MineHandler mineHandler;
    private ChunkHandler chunkHandler;

    public void onEnable() {
        getCommand("minex").setExecutor(new CommandHandler(this));
        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(this), this);
        load();
    }

    public void onDisable() {
        save();
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public MineHandler getMineHandler() {
        return mineHandler;
    }

    public ChunkHandler getChunkHandler(){
        return chunkHandler;
    }


    private void load() {
        playerHandler = new PlayerHandler();
        mineHandler = new MineHandler();
        chunkHandler = new ChunkHandler();
    }

    private void save() {

    }

}
