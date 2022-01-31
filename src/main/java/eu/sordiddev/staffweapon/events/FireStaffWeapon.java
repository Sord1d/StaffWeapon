package eu.sordiddev.staffweapon.events;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.block.data.type.Fire;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FireStaffWeapon implements Listener {


    @EventHandler
    public void onweaponshot (ProjectileLaunchEvent e){

        //TODO permission check

        //if it's not a trident it doesn't matter to us
        if ((e.getEntity() instanceof Trident)) {

            //get shooter's name
            Player player = (Player) e.getEntity().getShooter();
            assert player != null;

            //get the held item and check for out staff weapon lore
            //if present we will cancel the throwing event to create our own
            ItemStack helditem = player.getInventory().getItemInMainHand();
            if(Objects.requireNonNull(helditem.lore()).toString().contains("Staff Weapon")) {
                e.setCancelled(true);

                Boolean permission = player.hasPermission("staffweapon.admin") | player.hasPermission("staffweapon.shoot.charge");

                if (permission) {

                    //spawn a new projectile (fireball)
                    Snowball projectile = player.getWorld().spawn(player.getLocation().add(0, 1.7, 0), Snowball.class);
                    projectile.isGlowing();
                    projectile.setVisualFire(true);
                    projectile.setShooter(player);
                    projectile.setCustomName("StaffWeapon");
                    projectile.setCustomNameVisible(false);
                    projectile.setVelocity(player.getLocation().getDirection().normalize().multiply(2));
                    projectile.setGravity(false);

                    //play the weapon sound
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_HURT, 1, 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);

                }else{
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.WHITE +"You are not permitted to do this",
                            ChatColor.DARK_GRAY + "[Lacking the permission node staffweapon.shoot.charge]");
                }
            }
        }



    }

    @EventHandler
    public void ontridentklick (PlayerInteractEvent e){

    Player player = e.getPlayer();
    if (e.getAction() == Action.LEFT_CLICK_AIR){

        if (Objects.requireNonNull(player.getInventory().getItemInMainHand().lore()).toString().contains("Staff Weapon")) {

            Boolean permission = player.hasPermission("staffweapon.admin") | player.hasPermission("staffweapon.shoot.fast");

            if (permission) {

                //spawn a new projectile (fireball)
                Snowball projectile = player.getWorld().spawn(player.getLocation().add(0, 1.7, 0), Snowball.class);
                projectile.isGlowing();
                projectile.setVisualFire(true);
                projectile.setShooter(player);
                projectile.setCustomName("StaffLeft");
                projectile.setCustomNameVisible(false);
                projectile.setVelocity(player.getLocation().getDirection().normalize().multiply(2));
                projectile.setGravity(false);

                //play the weapon sound
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_HURT, 1, 1);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);
            }else{
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "StaffWeapon" + ChatColor.GRAY + "] " + ChatColor.WHITE +"You are not permitted to do this",
                        ChatColor.DARK_GRAY + "[You are lacking the permission node staffweapon.shoot.fast]");
            }

        }

    }

    }

}

