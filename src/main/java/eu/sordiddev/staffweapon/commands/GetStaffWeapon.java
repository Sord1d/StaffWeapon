package eu.sordiddev.staffweapon.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class GetStaffWeapon {


    public GetStaffWeapon(CommandSender sender, Command command, String label, String[] args) {
        super();

        Player player = (Player) sender;

        if (sender instanceof Player) {


            boolean permission = player.hasPermission("staffweapon.get") | player.hasPermission("staffweapon.admin");

            if (permission) {


                //Defining the weapon object
                ItemStack staffweapon = new ItemStack(Material.TRIDENT);

                ItemMeta meta = staffweapon.getItemMeta();
                meta.displayName(Component.text(ChatColor.GOLD + "Staff Weapon"));
                meta.lore(Collections.singletonList(Component.text(ChatColor.GOLD + "Staff Weapon")));
                staffweapon.setItemMeta(meta);


                player.getInventory().addItem(staffweapon);
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "Here's your weapon!");


            }else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                        ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.get]");
            }
        }else{
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "ERROR - This command must be executed by a player!"); //TODO Message Design
        }

    }
}

