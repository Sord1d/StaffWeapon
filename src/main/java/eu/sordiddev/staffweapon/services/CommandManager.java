package eu.sordiddev.staffweapon.services;

import eu.sordiddev.staffweapon.commands.*;
import eu.sordiddev.staffweapon.spawners.AddSpawner;
import eu.sordiddev.staffweapon.spawners.SpawnAtSpawner;
import eu.sordiddev.staffweapon.spawners.SpawnerList;
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
            } else if (args[0].contains("values")) {
                new GetValues(sender, command, label, args);
            } else if (args[0].contains("setfast")) {
                new SetFast(sender, command, label, args);
            } else if (args[0].contains("setcharged")) {
                new SetCharge(sender, command, label, args);
            } else if (args[0].contains("setmob")) {
                new SetMobCharge(sender, command, label, args);
            } else if (args[0].contains("spawnmob")) {
                    new Spawnmob(sender, command, label, args);
            } else if (args[0].contains("addspawner")) {
                new AddSpawner(sender, command, label, args);
            } else if (args[0].contains("listspawners")) {
                new SpawnerList(sender, command, label, args);
            } else if (args[0].contains("setrange")) {
                new SetRange(sender, command, label, args);
            } else if (args[0].contains("test")) {
                new SpawnAtSpawner(sender, command, label, args);
            } else {
                sender.sendMessage(
                        ChatColor.DARK_GREEN + "          sord1d/" + ChatColor.GREEN + ChatColor.BOLD + "StaffWeapon",
                        ChatColor.DARK_GRAY + "--------------------------------",
                        ChatColor.DARK_GREEN + "/sw get  " + ChatColor.GREEN + "get a staff weapon",
                        ChatColor.DARK_GREEN + "/sw values  " + ChatColor.GREEN + "lookup plugin values",
                        ChatColor.DARK_GREEN + "/sw setfast  " + ChatColor.GREEN + "set damage amount of the fast shot",
                        ChatColor.DARK_GREEN + "/sw setcharged  " + ChatColor.GREEN + "set damage amount of the charged shot",
                        ChatColor.DARK_GREEN + "/sw setmob  " + ChatColor.GREEN + "set damage amount dealt by a mob",
                        ChatColor.DARK_GREEN + "/sw setrange  " + ChatColor.GREEN + "set spawner range",
                        ChatColor.DARK_GREEN + "/sw addpawner  " + ChatColor.GREEN + "add a spawner",
                        ChatColor.DARK_GREEN + "/sw listspawners  " + ChatColor.GREEN + "show all spawners");
            }

        }catch (Exception e){

            sender.sendMessage(
                    ChatColor.DARK_GREEN + "          sord1d/" + ChatColor.GREEN + ChatColor.BOLD + "StaffWeapon",
                    ChatColor.DARK_GRAY + "--------------------------------",
                    ChatColor.DARK_GREEN + "/sw get  " + ChatColor.GREEN + "get a staff weapon",
                    ChatColor.DARK_GREEN + "/sw values  " + ChatColor.GREEN + "lookup plugin values",
                    ChatColor.DARK_GREEN + "/sw setfast  " + ChatColor.GREEN + "set damage amount of the fast shot",
                    ChatColor.DARK_GREEN + "/sw setcharged  " + ChatColor.GREEN + "set damage amount of the charged shot",
                    ChatColor.DARK_GREEN + "/sw setmob  " + ChatColor.GREEN + "set damage amount dealt by a mob",
                    ChatColor.DARK_GREEN + "/sw setrange  " + ChatColor.GREEN + "set spawner range",
                    ChatColor.DARK_GREEN + "/sw addpawner  " + ChatColor.GREEN + "add a spawner",
                    ChatColor.DARK_GREEN + "/sw listspawners  " + ChatColor.GREEN + "show all spawners");

        }


        return false;
    }
}
