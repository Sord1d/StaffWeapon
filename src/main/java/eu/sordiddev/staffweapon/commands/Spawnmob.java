package eu.sordiddev.staffweapon.commands;


import eu.sordiddev.staffweapon.services.ItemStacks;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Player;


public class Spawnmob {
    public Spawnmob(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Location location = player.getLocation();
        World world = player.getWorld();

        Drowned mob = world.spawn(location, Drowned.class);



        mob.getEquipment().setItemInMainHand(ItemStacks.createStaffWeapon());
        mob.getEquipment().setItemInMainHandDropChance(0f);

        mob.getEquipment().setHelmet(ItemStacks.createHelmet());
        mob.getEquipment().setItemInMainHandDropChance(0.01f);

        mob.getEquipment().setChestplate(ItemStacks.createTunic());
        mob.getEquipment().setItemInMainHandDropChance(0.01f);

        mob.getEquipment().setLeggings(ItemStacks.createPants());
        mob.getEquipment().setItemInMainHandDropChance(0.01f);

        mob.getEquipment().setBoots(ItemStacks.createBoots());
        mob.getEquipment().setItemInMainHandDropChance(0.01f);


        mob.setCustomName("Jaffa");



    }
}
