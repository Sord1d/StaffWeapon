package eu.sordiddev.staffweapon.events;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class FireStaffWeapon implements Listener {


    //TODO PLAYER CHECK

    @EventHandler
    public void onweaponshot(ProjectileLaunchEvent e) {


        //if it's not a trident it doesn't matter to us
        if ((e.getEntity() instanceof Trident)) {

            //get shooter's name


            //get the held item and check for out staff weapon lore
            //if present we will cancel the throwing event to create our own


            if (e.getEntity().getShooter() instanceof Player) {
                Player player = (Player) e.getEntity().getShooter();
                assert player != null;
                ItemStack helditem = player.getInventory().getItemInMainHand();
                if (helditem.lore() != null) {
                    if (helditem.lore().toString().contains("Staff Weapon")) {
                        e.setCancelled(true);

                        Boolean permission = player.hasPermission("staffweapon.admin") | player.hasPermission("staffweapon.shoot.charge");

                        if (permission) {

                            World world = player.getWorld();

                            //spawn a new projectile (fireball)
                            Snowball projectile = player.getWorld().spawn(player.getLocation().add(0, 1.7, 0), Snowball.class);
                            projectile.setGlowing(true);
                            projectile.setVisualFire(true);
                            projectile.setShooter(player);
                            projectile.setCustomName("StaffWeapon");
                            projectile.setCustomNameVisible(false);
                            projectile.setVelocity(player.getLocation().getDirection().normalize().multiply(5));

                            //play the weapon sound
                            world.playSound(player.getLocation(), Sound.ENTITY_WITHER_HURT, 1, 1);
                            world.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);

                        } else {
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                                    ChatColor.DARK_GRAY + "[Lacking the permission node staffweapon.shoot.charge]");
                        }
                    }
                }
            } else  if (e.getEntity().getShooter() instanceof Monster) {

                Monster monster = (Monster) e.getEntity().getShooter();
                ItemStack helditem = monster.getActiveItem();

                if (helditem.lore() != null){

                    e.setCancelled(true);

                    if (String.valueOf(helditem.lore()).contains("Staff Weapon")){

                        Location location = monster.getLocation().add(0,1.7,0);
                        World world = monster.getWorld();

                        world.playSound(location, Sound.ENTITY_WITHER_HURT, 1, 1);
                        world.playSound(location, Sound.ENTITY_WITHER_HURT, 1, 1);

                        Snowball projectile = world.spawn(location, Snowball.class);
                        projectile.setGlowing(true);
                        projectile.setVisualFire(true);
                        projectile.setShooter(monster);
                        projectile.setCustomName("StaffWeapon");
                        projectile.setCustomNameVisible(false);
                        projectile.setVelocity(monster.getLocation().getDirection().normalize().multiply(3));

                    }
                }

            }


        }
    }


    @EventHandler
    public void ontridentklick(PlayerInteractEvent e) throws InterruptedException {

        Player player = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR && player.getInventory().getItemInMainHand().lore() != null) {

                if (player.getInventory().getItemInMainHand().lore().toString().contains("Staff Weapon")) {
                    Boolean permission = player.hasPermission("staffweapon.admin") | player.hasPermission("staffweapon.shoot.fast");

                    Snowball projectile = null;
                    if (permission) {

                        //spawn a new projectile (fireball)
                        projectile = player.getWorld().spawn(player.getLocation().add(0, 1.7, 0), Snowball.class);
                        projectile.setGlowing(true);
                        projectile.setVisualFire(true);
                        projectile.setShooter(player);
                        projectile.setCustomName("StaffLeft");
                        projectile.setCustomNameVisible(false);
                        projectile.setVelocity(player.getLocation().getDirection().normalize().multiply(5));

                        //TODO remove projectile somehow


                        //play the weapon sound
                        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_HURT, 1, 1);
                        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);


                    } else {
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.GOLD + "You are not permitted to do this",
                                ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.shoot.fast]");
                    }


                }
        }
    }
}



