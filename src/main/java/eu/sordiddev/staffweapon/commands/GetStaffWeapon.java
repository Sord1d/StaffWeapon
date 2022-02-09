package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.services.ItemStacks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetStaffWeapon {


    public GetStaffWeapon(CommandSender sender, Command command, String label, String[] args) {
        super();

        Player player = (Player) sender;

        if (sender instanceof Player) {


            boolean permission = player.hasPermission("staffweapon.get") | player.hasPermission("staffweapon.admin");

            if (permission) {


                player.getInventory().addItem(ItemStacks.createStaffWeapon());
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "Here's your weapon!");


            }else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                        ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.get]");
            }
        }else{
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CNStaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "ERROR - This command must be executed by a player!"); //TODO Message Design
        }

    }
}

