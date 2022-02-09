package eu.sordiddev.staffweapon.spawners;

import eu.sordiddev.staffweapon.Staffweapon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SpawnerList {

    public SpawnerList(CommandSender sender, Command command, String label, String[] args) {


   // public void spawner() {


        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);
        int total = plugin.getConfig().getInt("total");

        if (total > 0) {


            for (int i = 1; i <= total; i++) {

                String world = plugin.getConfig().getString(String.valueOf(i) + ".world");
                int x = plugin.getConfig().getInt(String.valueOf(i) + ".x");
                int y = plugin.getConfig().getInt(String.valueOf(i) + ".y");
                int z = plugin.getConfig().getInt(String.valueOf(i) + ".z");

                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + "Spawner #" + i + " World: " + world + " x: " + x + " y: " + y + " z: " + z);

            }
        }else {
            sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "There are no spawn points defined");
        }

   // }
    }

}
