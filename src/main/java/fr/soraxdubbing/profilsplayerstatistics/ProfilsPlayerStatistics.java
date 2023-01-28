package fr.soraxdubbing.profilsplayerstatistics;

import fr.soraxdubbing.profilsmanagercore.ProfilsManagerCore;
import fr.soraxdubbing.profilsmanagercore.manager.UsersManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProfilsPlayerStatistics extends JavaPlugin {

    private static ProfilsPlayerStatistics instance;
    private ProfilsManagerCore profilsManagerCore;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new EventRegister(), this);
    }

    @Override
    public void onLoad() {
        UsersManager.getInstance().registerClass(PlayerStats.class);
    }

    @Override
    public void onDisable() {
    }

    public ProfilsManagerCore getProfilsManagerCore() {
        return profilsManagerCore;
    }

    public static ProfilsPlayerStatistics getInstance() {
        return instance;
    }
}
