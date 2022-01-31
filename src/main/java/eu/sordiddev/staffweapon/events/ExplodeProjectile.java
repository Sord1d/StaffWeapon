package eu.sordiddev.staffweapon.events;

import com.destroystokyo.paper.ParticleBuilder;
import com.destroystokyo.paper.event.entity.ProjectileCollideEvent;
import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.List;

public class ExplodeProjectile implements Listener {

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
        if (e.getEntity().getCustomName() != null) {

            if (e.getDamager().getName().contains("StaffWeapon")) {

                //TODO DAMAGE CONFIG FILE

                Snowball projectile = (Snowball) e.getDamager();
                Player player = (Player) projectile.getShooter();
                e.setDamage(15);


            } else if (e.getDamager().getName().contains("StaffLeft")) {
                //TODO DAMAGE CONFIG FILE

                Snowball projectile = (Snowball) e.getDamager();
                Player player = (Player) projectile.getShooter();
                e.setDamage(5);

            }
        }
    }

}

