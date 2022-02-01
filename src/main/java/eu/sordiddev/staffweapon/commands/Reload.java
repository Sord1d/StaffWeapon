package eu.sordiddev.staffweapon.commands;

import eu.sordiddev.staffweapon.services.SubCommand;
import org.bukkit.entity.Player;

public class Reload extends SubCommand {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "reloads the config";
    }

    @Override
    public String getSyntax() {
        return "/sw reload";
    }

    @Override
    public void perform(Player player, String[] args) {

        //TODO

    }
}
