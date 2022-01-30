package eu.sordiddev.staffweapon.events;

import com.destroystokyo.paper.ParticleBuilder;
import com.destroystokyo.paper.event.entity.ProjectileCollideEvent;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.List;

public class ExplodeProjectile implements Listener {

    //creating a new event handler to listen for our collisions

    @EventHandler
    public void Explode(ProjectileHitEvent e){


            //the projectile should be called StaffWeapon - any other collision can be ignored
            if (e.getEntity().getCustomName().contains("StaffWeapon")){

                //patricle stuff
                ParticleBuilder explosion = new ParticleBuilder(Particle.SMOKE_NORMAL);
                ParticleBuilder flame = new ParticleBuilder(Particle.FLAME);
                explosion.allPlayers().location(e.getEntity().getLocation()).count(50).spawn();
                flame.allPlayers().location(e.getEntity().getLocation()).count(20).spawn();
                e.getEntity().remove();

               //TODO DEAL DAMAGE


                Player player = (Player) e.getEntity().getShooter();
                player.sendMessage("Boom!");


            }

    }


}

