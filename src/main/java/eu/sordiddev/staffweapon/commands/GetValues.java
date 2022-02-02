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

        boolean permission = player.hasPermission("staffweapon.lookup") | player.hasPermission("staffweapon.admin");

        if (permission) {

            player.sendMessage(
                    ChatColor.RED + "Staff" + ChatColor.GOLD + "Weapon",
                    ChatColor.GOLD + "--------------",
                    ChatColor.RED + "Fast shot: " + ChatColor.GOLD + fast + " damage",
                    ChatColor.RED + "Charged shot: " + ChatColor.GOLD + charged + " damage",
                    ChatColor.RED + "Mob shot: " + ChatColor.GOLD + mob + " damage");
        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.lookup]");
        }
    }
}