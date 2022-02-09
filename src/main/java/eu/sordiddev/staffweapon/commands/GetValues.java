package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetValues {

    @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

    public GetValues(CommandSender sender, Command command, String label, String[] args) {
        super();

        Player player = (Player) sender;

        int fast = plugin.getConfig().getInt("fast");
        int charged = plugin.getConfig().getInt("charged");
        int mob = plugin.getConfig().getInt("mob");
        int range = plugin.getConfig().getInt("range");

        boolean permission = player.hasPermission("staffweapon.lookup") | player.hasPermission("staffweapon.admin");

        if (permission) {

            player.sendMessage(
                    ChatColor.DARK_GREEN + "          sord1d/" + ChatColor.GREEN + ChatColor.BOLD + "StaffWeapon",
                    ChatColor.DARK_GRAY + "--------------------------------",
                    ChatColor.DARK_GREEN + "Fast shot: " + ChatColor.GREEN + fast + " damage",
                    ChatColor.DARK_GREEN + "Charged shot: " + ChatColor.GREEN + charged + " damage",
                    ChatColor.DARK_GREEN + "Mob shot: " + ChatColor.GREEN + mob + " damage",
                    ChatColor.DARK_GREEN + "Spawner Range: " + ChatColor.GREEN + range + " blocks");
        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.lookup]");
        }
    }
}