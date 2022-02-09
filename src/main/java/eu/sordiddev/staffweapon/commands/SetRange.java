package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetRange {


    public SetRange(CommandSender sender, Command command, String label, String[] args) {
        super();

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);
        Player player = (Player) sender;

        Boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            if (args.length > 1) {
                try {
                    int range = Integer.parseInt(args[1]);
                    int rangeold = plugin.getConfig().getInt("range");

                    plugin.getConfig().set("range", range);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "You've changed the spawner range from " + rangeold + " to " + range);
                } catch (Exception e) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN +  "Usage: /sw setrange <number>");

                }

            } else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN +  "Usage: /sw setrange <number>");
            }

        } else {

            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                    ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
        }

    }








}
