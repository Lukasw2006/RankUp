package de.lukas.runkup.Events;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickEvents implements Listener {
   private Economy economy;


   public InventoryClickEvents(Economy economy){
       this.economy = economy;
   }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
            Player player = (Player) event.getWhoClicked();
            if(event.getClickedInventory().getTitle().equals("Rank-Upgrade")){
                event.setCancelled(true);
                if(event.getCurrentItem().getType() == Material.WOOL) {
                    if(!economy.hasAccount(player)){
                        economy.createPlayerAccount(player);
                        player.sendMessage("Dir wurde ein Account erstellt !!!");
                    }else {
                        if(economy.has(player, 25000)) {
                            player.closeInventory();
                            player.sendMessage("§aDu hast Erfolgreich den Meister rang gekauft !!");
                            Bukkit.broadcastMessage("§7Der Spieler §7" + player.getName() + " hat sich gerade den §aMeister §7Rang gekauft!. §b/Rankup");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " group set Meister");
                            economy.withdrawPlayer(player, 25000);
                            player.kickPlayer("§5§lPixelee.net §7-> §aDein Rang wird Aktualisiert, bitte Joine neu");
                        }else{
                            player.sendMessage("§cDu hast nicht genug Geld");
                            player.closeInventory();
                        }
                    }
                }else if(event.getCurrentItem().getType() == Material.PURPUR_BLOCK) {
                    if(!economy.hasAccount(player)){
                        economy.createPlayerAccount(player);
                        player.sendMessage("Dir wurde ein Account erstellt !!!");
                    }else {
                        if(economy.has(player, 50000)) {
                            player.closeInventory();
                            player.sendMessage("§aDu hast Erfolgreich den Supreme rang gekauft !!");
                            Bukkit.broadcastMessage("§7Der Spieler §a" + player.getName() + " §7hat sich gerade den §dSupreme §7Rang gekauft!. §b/Rankup");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " group set Supreme");
                            economy.withdrawPlayer(player, 50000);
                            player.kickPlayer("§5§lPixelee.net §7-> §aDein Rang wird Aktualisiert, bitte Joine neu");
                        }else{
                            player.sendMessage("§cDu hast nicht genug Geld");
                            player.closeInventory();
                        }
                    }
                }else if(event.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                    if(!economy.hasAccount(player)){
                        economy.createPlayerAccount(player);
                        player.sendMessage("Dir wurde ein Account erstellt !!!");
                    }else {
                        if(economy.has(player, 100000)) {
                            player.closeInventory();
                            player.sendMessage("§aDu hast Erfolgreich den Platin rang gekauft !!");
                            Bukkit.broadcastMessage("§7Der Spieler §d" + player.getName() + " §7hat sich gerade den §ePlatin §7Rang gekauft!. §b/Rankup");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " group set Platin");
                            economy.withdrawPlayer(player, 100000);
                            player.kickPlayer("§5§lPixelee.net §7-> §aDein Rang wird Aktualisiert, bitte Joine neu");
                        }else{
                            player.sendMessage("§cDu hast nicht genug Geld");
                            player.closeInventory();
                        }
                    }
                }
            }
    }
}
