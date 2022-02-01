package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.Staffweapon;
import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetCharge extends SubCommand {


    @Override
    public String getName() {
        return "setcharged";
    }

    @Override
    public String getDescription() {
        return "set the damage amount of the charged shot";
    }

    @Override
    public String getSyntax() {
        return "/sw setcharged <number>";
    }

    @Override
    public void perform(Player player, String[] args) {

        @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

        Boolean permission = player.hasPermission("staffweapon.admin");

        if (permission) {

            if (args.length > 1) {
                try {
                    int charged = Integer.parseInt(args[1]);
                    int chargedold = plugin.getConfig().getInt("charged");

                    plugin.getConfig().set("charged", charged);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You've changed the shot damage from " + chargedold + " to " + charged);
                } catch (Exception e) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "Usage: /sw setcharged <number>");

                }

            }
        } else {

        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.admin]");
    }




    }


}
