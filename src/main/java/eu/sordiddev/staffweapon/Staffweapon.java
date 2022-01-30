package eu.sordiddev.staffweapon;

import eu.sordiddev.staffweapon.commands.GetStaffWeapon;
import eu.sordiddev.staffweapon.events.ExplodeProjectile;
import eu.sordiddev.staffweapon.events.FireStaffWeapon;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Staffweapon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //registering the fire event
        getServer().getPluginManager().registerEvents(new FireStaffWeapon(), this);

        //registering the projectile explosion event
        getServer().getPluginManager().registerEvents( new ExplodeProjectile(),this);


        getCommand("swget").setExecutor(new GetStaffWeapon());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
