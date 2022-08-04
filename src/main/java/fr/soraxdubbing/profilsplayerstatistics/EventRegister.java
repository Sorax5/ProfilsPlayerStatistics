package fr.soraxdubbing.profilsplayerstatistics;

import fr.soraxdubbing.profilsmanagercore.event.AddonRegisterEvent;
import fr.soraxdubbing.profilsmanagercore.event.ProfilLoadedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class EventRegister implements Listener {

    @EventHandler
    public void registerAddon(AddonRegisterEvent event){
        if(!event.getData().containsClass(PlayerStats.class)){
            event.registerAddon(PlayerStats.class);
            System.out.println("Registering addon");
        }
    }

    @EventHandler
    public void onProfilLoad(ProfilLoadedEvent e){
        if(!e.getProfil().hasAddon("playerstats")){
            e.getProfil().addAddon(new PlayerStats());
        }


    }
}
