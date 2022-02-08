package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetMobCharge {


    public SetMobCharge(CommandSender sender, Command command, String label, String[] args) {
        super();

        Player player = (Player) sender;

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        Boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            if (args.length > 1) {
                try {
                    int charged = Integer.parseInt(args[1]);
                    int chargedold = plugin.getConfig().getInt("mob");

                    plugin.getConfig().set("mob", charged);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "You've changed the shot damage from " + chargedold + " to " + charged);
                } catch (Exception e) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "Usage: /sw setmob <number>");

                }

            }
        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }


    }


}
