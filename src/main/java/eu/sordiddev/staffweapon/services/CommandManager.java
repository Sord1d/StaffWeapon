package eu.sordiddev.staffweapon.services;

import eu.sordiddev.staffweapon.commands.GetStaffWeapon;
import eu.sordiddev.staffweapon.commands.SetCharge;
import eu.sordiddev.staffweapon.commands.SetFast;
import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class CommandManager implements CommandExecutor {


    private static ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager(){

        subcommands.add(new GetStaffWeapon());
        subcommands.add(new SetFast());
        subcommands.add(new SetCharge());

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(player, args);
                    }
                }
            }else if(args.length == 0){
                player.sendMessage("",
                        ChatColor.RED +  "          sord1d/" + ChatColor.GOLD + ChatColor.BOLD + "StaffWeapon",
                        ChatColor.GOLD + "--------------------------------");
                for (int i = 0; i < getSubcommands().size(); i++){
                    player.sendMessage(ChatColor.RED + getSubcommands().get(i).getSyntax() + "  " + ChatColor.GOLD + getSubcommands().get(i).getDescription());
                }
                player.sendMessage(ChatColor.GOLD + "--------------------------------");
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }

}
