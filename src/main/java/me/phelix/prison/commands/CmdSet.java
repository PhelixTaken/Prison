package me.phelix.prison.commands;

import me.phelix.prison.Mine;
import me.phelix.prison.utils.FLocation;
import me.phelix.prison.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

public final class CmdSet extends SubCommand {

    public CmdSet(){
        super(new String[]{"set"}, new String[]{"<name> <value> <miny> <maxy"}, "creativemc.prison.setmine");
    }

    @Override
    public void execute(CommandSender sender, String[] args){
        if(args.length == 4){

            final String name = args[0];
            final int value = Integer.parseInt(args[1]);
            final int minY = Integer.parseInt(args[2]);
            final int maxY = Integer.parseInt(args[3]);

            if(!mineHandler.mineExists(name)) {

                final Mine mine = new Mine(name, value);
                final Location location = xPlayer.getPlayer().getLocation();
                final FLocation fLocation = new FLocation(location.getChunk().getX(), location.getChunk().getZ(), location.getWorld().getUID().toString());
                fLocation.setMinHeight(minY);
                fLocation.setMaxHeight(maxY);
                mine.addChunk(fLocation);
                chunkHandler.getMineMap().put(fLocation, mine);
                mineHandler.getMineMap().put(name, mine);
                xPlayer.setMine(mine);
                sender.sendMessage(ChatColor.GREEN + "Created a mine at" + ChatColor.WHITE +  " X: " + fLocation.getX() + " Z: " + fLocation.getZ() + " minY: " + minY + " maxY: " + maxY);

            } else {
                sender.sendMessage("Mine " + name + " already exists! Please use the add command instead for adding more chunks!");
            }

        } else {
            sender.sendMessage(toString());
        }
    }

}
