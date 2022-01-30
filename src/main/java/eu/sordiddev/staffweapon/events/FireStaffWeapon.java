package eu.sordiddev.staffweapon.events;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.block.data.type.Fire;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
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

                //spawn a new projectile (fireball)
                Snowball projectile = player.getWorld().spawn(player.getLocation().add(0,2,0), Snowball.class);
                projectile.isGlowing();
                projectile.setVisualFire(true);
                projectile.setShooter(player);
                projectile.setCustomName("StaffWeapon");
                projectile.setCustomNameVisible(false);
                projectile.setVelocity(player.getLocation().getDirection().normalize().multiply(2));
                projectile.setGravity(false);

                //play the weapon sound
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_HURT,1,1);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT,1,1);
            }
        }




        return;


    }

}

