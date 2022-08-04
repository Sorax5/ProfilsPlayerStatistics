package fr.soraxdubbing.profilsplayerstatistics;

import fr.soraxdubbing.profilsmanagercore.ProfilsManagerCore;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProfilsPlayerStatistics extends JavaPlugin {

    ProfilsManagerCore profilsManagerCore;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.profilsManagerCore = ProfilsManagerCore.getInstance();
        getServer().getPluginManager().registerEvents(new EventRegister(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
