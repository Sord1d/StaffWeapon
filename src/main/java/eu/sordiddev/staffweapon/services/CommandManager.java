package eu.sordiddev.staffweapon.services;

import eu.sordiddev.staffweapon.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;



public class CommandManager implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        try {

            if (args[0].contains("get")) {
                new GetStaffWeapon(sender, command, label, args);
            } else if (args[0].contains("damage")) {
                new GetValues(sender, command, label, args);
            } else if (args[0].contains("setfast")) {
                new SetFast(sender, command, label, args);
            } else if (args[0].contains("setcharged")) {
                new SetCharge(sender, command, label, args);
            } else if (args[0].contains("setmob")) {
                new SetMobCharge(sender, command, label, args);
            } else {
                sender.sendMessage(
                        ChatColor.RED + "          sord1d/" + ChatColor.GOLD + ChatColor.BOLD + "StaffWeapon",
                        ChatColor.GOLD + "--------------------------------",
                        ChatColor.RED + "/sw get  " + ChatColor.GOLD + "get a staff weapon",
                        ChatColor.RED + "/sw damage  " + ChatColor.GOLD + "lookup damage done by the staff weapon",
                        ChatColor.RED + "/sw setfast  " + ChatColor.GOLD + "set damage amount of the fast shot",
                        ChatColor.RED + "/sw setcharged  " + ChatColor.GOLD + "set damage amount of the charged shot",
                        ChatColor.RED + "/sw setmob  " + ChatColor.GOLD + "set damage amount if a mob uses the staff weapon",
                        ChatColor.GOLD + "--------------------------------");
            }

        }catch (Exception e){

            sender.sendMessage(
                    ChatColor.RED + "          sord1d/" + ChatColor.GOLD + ChatColor.BOLD + "StaffWeapon",
                    ChatColor.GOLD + "--------------------------------",
                    ChatColor.RED + "/sw get  " + ChatColor.GOLD + "get a staff weapon",
                    ChatColor.RED + "/sw damage  " + ChatColor.GOLD + "lookup damage done by the staff weapon",
                    ChatColor.RED + "/sw setfast  " + ChatColor.GOLD + "set damage amount of the fast shot",
                    ChatColor.RED + "/sw setcharged  " + ChatColor.GOLD + "set damage amount of the charged shot",
                    ChatColor.RED + "/sw setmob  " + ChatColor.GOLD + "set damage amount if a mob uses the staff weapon",
                    ChatColor.GOLD + "--------------------------------");
        }


        return false;
    }
}
