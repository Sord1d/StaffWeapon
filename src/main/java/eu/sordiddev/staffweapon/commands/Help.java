package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.services.CommandManager;
import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help extends SubCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return null;
    }

    @Override
    public boolean perform(Player player, String[] args) {

        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "For a full list of command use /sw ");

        return false;
    }
}
