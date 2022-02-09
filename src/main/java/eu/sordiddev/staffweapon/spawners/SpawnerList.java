package eu.sordiddev.staffweapon.spawners;

import eu.sordiddev.staffweapon.Staffweapon;

import eu.sordiddev.staffweapon.services.SpawnConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnerList {

    public SpawnerList(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);
            int total = SpawnConfig.getCustomConfig().getInt("total");

            if (total > 0) {


                for (int i = 1; i <= total; i++) {

                    String world = SpawnConfig.getCustomConfig().getString(String.valueOf(i) + ".world");
                    int x = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".x");
                    int y = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".y");
                    int z = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".z");

                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + "Spawner #" + i + " World: " + world + " x: " + x + " y: " + y + " z: " + z);

                }
            } else {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "There are no spawn points defined");
            }

        } else {
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }

    }

}
