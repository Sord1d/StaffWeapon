package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetFast extends SubCommand {


    @Override
    public String getName() {
        return "setfast";
    }

    @Override
    public String getDescription() {
        return "set the damage amount of the fast shot";
    }

    @Override
    public String getSyntax() {
        return "/sw setfast <number>";
    }

    @Override
    public boolean perform(Player player, String[] args) {

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        Boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            if (args.length > 1) {
                try {
                    int fast = Integer.parseInt(args[1]);
                    int fastold = plugin.getConfig().getInt("fast");

                    plugin.getConfig().set("fast", fast);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You've changed the shot damage from " + fastold + " to " + fast);
                } catch (Exception e) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "Usage: /sw setfast <number>");

                }
            }
        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }
        return false;
    }


}
