package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetValues extends SubCommand {

    @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

    @Override
    public String getName() {
        return "damage";
    }

    @Override
    public String getDescription() {
        return "shows the damage dealt by the weapon";
    }

    @Override
    public String getSyntax() {
        return "/sw damage";
    }

    @Override
    public boolean perform(Player player, String[] args) {
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


        return permission;
    }
}
