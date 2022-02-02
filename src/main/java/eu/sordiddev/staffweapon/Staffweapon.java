package eu.sordiddev.staffweapon;

import eu.sordiddev.staffweapon.services.CommandManager;
import eu.sordiddev.staffweapon.events.ExplodeProjectile;
import eu.sordiddev.staffweapon.events.FireStaffWeapon;
import eu.sordiddev.staffweapon.services.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Staffweapon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "sord1d/StaffWeapon");

        //registering the fire event
        getServer().getPluginManager().registerEvents(new FireStaffWeapon(), this);

        //registering the projectile explosion event
        getServer().getPluginManager().registerEvents( new ExplodeProjectile(),this);

        //load / create the config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //TODO FIX -> PROJECTLES NOT DESPAWNNG


       getCommand("sw").setExecutor(new CommandManager());
       getCommand("sw").setTabCompleter(new TabComplete());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
