package me.phelix.prison.commands;

import me.phelix.prison.Prison;
import me.phelix.prison.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CommandHandler implements CommandExecutor {


    private final Prison plugin;
    private final Set<SubCommand> commands= new HashSet<>();

    public CommandHandler(Prison plugin) {
        this.plugin = plugin;
        commands.add(new CmdSet());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("minex")) {

            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You must be a player to perform this action!");
                return true;
            }

            if(args.length > 0) {

                for(final SubCommand subCommand : commands) {

                    for(int i = 0; i < subCommand.getAliases().length; i++) {

                        if(subCommand.getAliases()[i].equalsIgnoreCase(args[0])) {

                            if(subCommand.hasPermission(plugin.getPlayerHandler().getByPlayer((Player) sender))) {
                                subCommand.setDependencies(plugin.getPlayerHandler(), plugin.getChunkHandler(), plugin.getMineHandler());
                                subCommand.execute(sender, Arrays.copyOfRange(args, 1, args.length));
                            } else {
                                sender.sendMessage(ChatColor.RED + "You don't have permissions to do that!");
                            }

                        }

                    }

                }

            }

        }

        return true;
    }
}
