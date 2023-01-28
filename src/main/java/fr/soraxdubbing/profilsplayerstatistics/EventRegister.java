package fr.soraxdubbing.profilsplayerstatistics;

import fr.soraxdubbing.profilsmanagercore.API.ProfilLoadedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventRegister implements Listener {

    @EventHandler
    public void onProfilLoad(ProfilLoadedEvent e){
        if(!e.getProfil().hasAddon("playerstats")){
            e.getProfil().addAddon(new PlayerStats());
        }
    }
}
