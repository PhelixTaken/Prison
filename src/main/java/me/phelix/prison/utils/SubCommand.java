package me.phelix.prison.utils;

import me.phelix.prison.XPlayer;
import me.phelix.prison.handler.ChunkHandler;
import me.phelix.prison.handler.MineHandler;
import me.phelix.prison.handler.PlayerHandler;
import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    private final String[] aliases;
    private final String[] args;
    private final String permission;

    public XPlayer xPlayer;
    public PlayerHandler playerHandler;
    public ChunkHandler chunkHandler;
    public MineHandler mineHandler;

    protected SubCommand(String[] aliases, String[] args, String permission) {
        this.aliases = aliases;
        this.args = args;
        this.permission = permission;
    }

    public abstract void execute(CommandSender sender, String[] args);

    public void setDependencies(PlayerHandler playerHandler, ChunkHandler chunkHandler, MineHandler mineHandler) {
        this.playerHandler = playerHandler;
        this.chunkHandler = chunkHandler;
        this.mineHandler = mineHandler;
    }

    public boolean hasPermission (XPlayer xPlayer){
        this.xPlayer = xPlayer;
        return xPlayer.getPlayer().hasPermission(permission);
    }

    public String[] getAliases() {
        return aliases;
    }

    public String[] getArgs() {
        return args;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public final String toString() {
        return String.format("/f %s %s", String.join(" | ", aliases), String.join(" ", args));
    }

}
