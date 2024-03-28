package de.lukas.runkup;

import de.lukas.runkup.Events.InventoryClickEvents;
import de.lukas.runkup.command.InventoryCommand;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin{
     Economy eco = null;
    public static Main plugin;


    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("RankUp").setExecutor(new InventoryCommand());
        if(setupEconomy()){
            System.out.println("Das Plugin wurde mit Economy verbunden");
            Bukkit.getPluginManager().registerEvents(new InventoryClickEvents(eco), this);
        }else{
            System.out.println("Vault nicht gefunden!!!");
        }
    }

    @Override
    public void onDisable() {

    }
    private boolean setupEconomy(){
        if(getServer().getPluginManager().getPlugin("Vault") == null){
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if(rsp == null){
            return false;
        }
        eco = rsp.getProvider();
        return (eco != null);
    }

    public static Main getPlugin() {
        return plugin;
    }
}
