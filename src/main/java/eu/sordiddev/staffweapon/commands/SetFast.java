package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetFast {


    public SetFast(CommandSender sender, Command command, String label, String[] args) {
        super();


        Player player = (Player) sender;

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        Boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            if (args.length > 1) {
                try {
                    int fast = Integer.parseInt(args[1]);
                    int fastold = plugin.getConfig().getInt("fast");

                    plugin.getConfig().set("fast", fast);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN +  "You've changed the shot damage from " + fastold + " to " + fast);
                } catch (Exception e) {
                    player.sendMessage((ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN +  "Usage: /sw setfast <number>"));

                }
            }else {
                player.sendMessage((ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN +  "Usage: /sw setfast <number>"));
            }
        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }
    }


}
