package me.phelix.prison.events;

import me.phelix.prison.Mine;
import me.phelix.prison.Prison;
import me.phelix.prison.XPlayer;
import me.phelix.prison.utils.FLocation;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreak implements Listener {

    private final Prison plugin;

    public BlockBreak(Prison plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final XPlayer xPlayer = plugin.getPlayerHandler().getByPlayer(player);
        final Block block = event.getBlock();
        final FLocation fLocation = plugin.getChunkHandler().getFLocation(new FLocation(block.getChunk().getX(), block.getChunk().getZ(), block.getWorld().getUID().toString()));
        final Mine mine = plugin.getChunkHandler().getFromChunk(fLocation);
        final Location location = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ());

        if(location.getBlockY() >= fLocation.getMinHeight() && location.getBlockY() <= fLocation.getMaxHeight() && mine.getValue() == xPlayer.getMine().getValue()) {
            player.sendMessage("test");

        } else {
            event.setCancelled(true);
        }


    }

}
