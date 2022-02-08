package eu.sordiddev.staffweapon.commands;


import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;


public class Spawnmob {
    public Spawnmob(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Location location = player.getLocation();
        World world = player.getWorld();

        Drowned mob = world.spawn(location, Drowned.class);



        mob.getEquipment().setItemInMainHand(ItemStacks.createStaffWeapon());
        mob.getEquipment().setItemInMainHandDropChance(0f);
        mob.getEquipment().setBoots(ItemStacks.createBoots());

        mob.setCustomName("Jaffa");



    }
}
