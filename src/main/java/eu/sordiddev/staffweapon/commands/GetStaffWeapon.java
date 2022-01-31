package eu.sordiddev.staffweapon.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;

public class GetStaffWeapon implements @Nullable CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {


            Player player = (Player) sender;

            boolean permission = player.hasPermission("staffweapon.get") | player.hasPermission("staffweapon.admin");

            if (permission) {


                //Defining the weapon object
                ItemStack staffweapon = new ItemStack(Material.TRIDENT);

                ItemMeta meta = staffweapon.getItemMeta();
                meta.displayName(Component.text(ChatColor.GOLD + "Staff Weapon"));
                meta.lore(Collections.singletonList(Component.text(ChatColor.GOLD + "Staff Weapon")));
                staffweapon.setItemMeta(meta);


                player.getInventory().addItem(staffweapon);
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.WHITE + "Here's your weapon!");

            }else {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.WHITE +"You are not permitted to do this",
                        ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.get]");
            }
        }else{
            sender.sendMessage("ERROR This command must be executed by a player!"); //TODO Message Design
        }
        return false;
    }
}
