package eu.sordiddev.staffweapon.services;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract boolean perform(Player player, String[] args);

}
