package eu.sordiddev.staffweapon.spawners;

import eu.sordiddev.staffweapon.Staffweapon;
import eu.sordiddev.staffweapon.services.ItemStacks;
import eu.sordiddev.staffweapon.services.SpawnConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SpawnAtSpawner {
    public SpawnAtSpawner(CommandSender sender, Command command, String label, String[] args) {


       // public void spawnMobs() {
            @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);
            int total = SpawnConfig.getCustomConfig().getInt("total");
        Player player = (Player) sender;

            if (total > 0) {


                for (int i = 1; i <= total; i++) {

                    //random number of mobs 1-5

                    double random = Math.random() * 5;

                    for (int j = 1; j <= random; j++) {

                        String world = SpawnConfig.getCustomConfig().getString(String.valueOf(i) + ".world");
                        World world1 = Bukkit.getWorld(world);
                        int x = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".x");
                        int y = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".y") + 1;
                        int z = SpawnConfig.getCustomConfig().getInt(String.valueOf(i) + ".z");



                        Location location = new Location(world1, x, y, z);

                       //TODO check for nearby players

                            Drowned mob = world1.spawn(location, Drowned.class);

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
            } else {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GREEN + "There are no spawn points defined");
            }


    }
}
