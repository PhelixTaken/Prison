package me.phelix.prison.api;

import me.phelix.prison.Prison;
import me.phelix.prison.handler.ChunkHandler;
import me.phelix.prison.handler.MineHandler;
import me.phelix.prison.handler.PlayerHandler;

public class API {

    private final Prison plugin;

    public API(Prison plugin) {
        this.plugin = plugin;
    }

    public PlayerHandler getPlayerHandler() {
        return plugin.getPlayerHandler();
    }

    public ChunkHandler getChunkHandler() {
        return plugin.getChunkHandler();
    }

    public MineHandler getMineHandler() {
        return plugin.getMineHandler();
    }

}
