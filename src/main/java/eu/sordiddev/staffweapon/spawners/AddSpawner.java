package eu.sordiddev.staffweapon.spawners;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AddSpawner {
    public AddSpawner(CommandSender sender, Command command, String label, String[] args) {

    @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        int total = plugin.getConfig().getInt("total");
        int current = total + 1;

        Player player = (Player) sender;

        String world = String.valueOf(player.getWorld().getName());
        int x = (int) player.getLocation().getX();
        int y = (int) player.getLocation().getY();
        int z = (int) player.getLocation().getZ();


        plugin.getConfig().addDefault(current+".world",world);
        plugin.getConfig().addDefault(current+".x",x);
        plugin.getConfig().addDefault(current+".y",y);
        plugin.getConfig().addDefault(current+".z",z);
        plugin.getConfig().set("total", current);
        plugin.getConfig().set(current+".world",world);
        plugin.getConfig().set(current+".x",x);
        plugin.getConfig().set(current+".y",y);
        plugin.getConfig().set(current+".z",z);


        plugin.saveDefaultConfig();
        plugin.saveConfig();

        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "You've added the point" + current + " (World: " + world + " x: " + x + " y: " + y + " z: " + z +")");



    }
}
