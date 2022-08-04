package fr.soraxdubbing.profilsplayerstatistics;

import fr.soraxdubbing.profilsmanagercore.Addon.AddonData;
import fr.soraxdubbing.profilsmanagercore.Manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats extends AddonData {

    private List<String> enderChest;
    private List<String> inventory;
    private double maximumHealth;
    private double actualHealth;
    private int foodLevel;
    private int x;
    private int y;
    private int z;
    private float yaw;
    private float pitch;
    private String world;
    private GameMode gameMode;
    private double money;

    public PlayerStats() {
        super("playerstats");
        this.enderChest = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.maximumHealth = 20;
        this.actualHealth = 20;
        this.foodLevel = 20;
        this.setLastLocation(Bukkit.getServer().getWorld("world").getSpawnLocation());
        this.gameMode = GameMode.SURVIVAL;
        this.money = 0;
    }

    @Override
    public void updateAddonData(Player player, JavaPlugin javaPlugin) {
        this.setLastLocation(player.getLocation());

        ItemStack[] inventory = player.getInventory().getContents();
        if (inventory != null) {
            this.setInventory(inventory);
        }

        ItemStack[] enderchest = player.getEnderChest().getContents();
        if (enderchest != null) {
            this.setEnderChest(enderchest);
        }

        this.setActualHealth(player.getHealth());

        this.setMaximumHealth(player.getMaxHealth());

        this.setGameMode(player.getGameMode());

        this.setFoodLevel(player.getFoodLevel());
    }

    @Override
    public void loadAddonData(Player player, JavaPlugin javaPlugin) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(this.getMaximumHealth());
        player.setHealth(this.getActualHealth());

        ItemStack[] inventory = this.getInventory();
        if (inventory != null) {
            player.getInventory().setContents(inventory);
        }

        ItemStack[] enderchest = this.getEnderChest();
        if (enderchest != null) {
            player.getEnderChest().setContents(enderchest);
        }
        player.teleport(this.getLastLocation());
        player.setFoodLevel(this.getFoodLevel());
    }

    public ItemStack[] getInventory() {
        return ItemManager.StringListToItemStack(this.inventory);
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = ItemManager.ItemStackToStringList(inventory);
    }

    public  ItemStack[] getEnderChest() {
        return ItemManager.StringListToItemStack(this.enderChest);
    }
    public  void setEnderChest(ItemStack[] inventory) {
        this.enderChest = ItemManager.ItemStackToStringList(inventory);
    }

    public double getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(double maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public double getActualHealth() {
        return actualHealth;
    }

    public void setActualHealth(double actualHealth) {
        this.actualHealth = actualHealth;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public void setLastLocation(Location location){
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
        this.world = location.getWorld().getName();
    }
    public Location getLastLocation(){
        return new Location(Bukkit.getWorld(this.world), this.x, this.y, this.z, this.yaw, this.pitch);
    }

    public GameMode getGameMode(){
        return this.gameMode;
    }

    public void setGameMode(GameMode gameMode){
        this.gameMode = gameMode;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder().append("§a§lPlayerStats:").append("\n");
        list.append("§7").append(getActualHealth()).append(" §c❤§r -> ").append(getMaximumHealth()).append(" §c❤§r").append("\n");
        list.append("§7§lx: §r§3").append(x).append(" §7§ly: §r§3").append(y).append(" §7§lz: §r§3").append(z).append("\n");
        list.append("§7Food: ").append(getFoodLevel()).append("§6🍗").append("§r\n");
        list.append("§eGamemode ").append(getGameMode()).append("\n");

        return list.toString();
    }
}
