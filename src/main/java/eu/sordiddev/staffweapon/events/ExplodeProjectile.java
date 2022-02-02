package eu.sordiddev.staffweapon.events;

import com.destroystokyo.paper.ParticleBuilder;
import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jetbrains.annotations.NotNull;


public class ExplodeProjectile implements Listener {

    @NotNull Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

    //creating a new event handler to listen for our collisions

    @EventHandler
    public void Explode(ProjectileHitEvent e) {

        if (e.getEntity().getCustomName() != null) {
            //the projectile should be called StaffWeapon - any other collision can be ignored
            if (e.getEntity().getCustomName().contains("Staff")) {

                //particle stuff
                ParticleBuilder explosion = new ParticleBuilder(Particle.SMOKE_NORMAL);
                ParticleBuilder flame = new ParticleBuilder(Particle.FLAME);
                explosion.allPlayers().location(e.getEntity().getLocation()).count(50).spawn();
                flame.allPlayers().location(e.getEntity().getLocation()).count(20).spawn();
                e.getEntity().remove();

            }

        }
    }

    @EventHandler
    public void Damage(EntityDamageByEntityEvent e){



        if (e.getDamager().getName() != null) {

            if (e.getDamager().getName().contains("StaffWeapon")) {

                Snowball projectile = (Snowball) e.getDamager();

                //TODO DAMAGE CONFIG FILE
                int charged = plugin.getConfig().getInt("charged");
                int mobcharged = plugin.getConfig().getInt("mob");


                if (projectile.getShooter() instanceof Player) {

                    e.setDamage(charged);

                }else{
                    e.setDamage(mobcharged);
                }


            } else if (e.getDamager().getName().contains("StaffLeft")) {
                //TODO DAMAGE CONFIG FILE
                int fast = plugin.getConfig().getInt("fast");

                e.setDamage(fast);

            }
        }
    }

}

