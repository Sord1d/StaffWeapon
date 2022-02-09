package eu.sordiddev.staffweapon.spawners;

import eu.sordiddev.staffweapon.Staffweapon;
import eu.sordiddev.staffweapon.services.SpawnConfig;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class AddSpawner {
    public AddSpawner(CommandSender sender, Command command, String label, String[] args) throws UnsupportedEncodingException {

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        Player player = (Player) sender;
        boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            int total = SpawnConfig.getCustomConfig().getInt("total");
            int current = total + 1;


            String world = String.valueOf(player.getWorld().getName());
            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();


            SpawnConfig.getCustomConfig().addDefault(current + ".world", world);
            SpawnConfig.getCustomConfig().addDefault(current + ".x", x);
            SpawnConfig.getCustomConfig().addDefault(current + ".y", y);
            SpawnConfig.getCustomConfig().addDefault(current + ".z", z);
            SpawnConfig.getCustomConfig().set("total", current);
            SpawnConfig.getCustomConfig().set(current + ".world", world);
            SpawnConfig.getCustomConfig().set(current + ".x", x);
            SpawnConfig.getCustomConfig().set(current + ".y", y);
            SpawnConfig.getCustomConfig().set(current + ".z", z);
            SpawnConfig.saveCustomConfig();


            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "You've added the point" + current + " (World: " + world + " x: " + x + " y: " + y + " z: " + z + ")");

        } else {
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }


    }
}

