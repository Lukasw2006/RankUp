package de.lukas.runkup.command;

import de.lukas.runkup.inventorybuilder.InventoryBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.Arrays;

public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("RankUp.Command")){
                if(args.length == 0){
                    Inventory inventory = Bukkit.createInventory(null, 9, "Rank-Upgrade");
                    items(player, inventory);
                }else
                    player.sendMessage("Benutze /RankUp");
            }else
                player.sendMessage("§cDu hast keine Rechte");
        }else
            sender.sendMessage("Du musst ein Spieler auf dem Server sein");
        return false;
    }
    public void items(Player player,Inventory inventory){
        /*
            ITEM_STACK
         */

        inventory = InventoryBuilder.fillWhithGlass(inventory);
        ItemStack meister = new ItemStack(Material.WOOL,1,(short) 5);
        ItemStack supreme = new ItemStack(Material.PURPUR_BLOCK);
        ItemStack platin = new ItemStack(Material.GOLD_BLOCK);
        ItemStack Meister_Block = new ItemStack(Material.BARRIER);
        ItemStack Legende_Block = new ItemStack(Material.BARRIER);
        ItemStack Titan_Block = new ItemStack(Material.BARRIER);
        ItemStack Ultra_RIGHT = new ItemStack(Material.GREEN_SHULKER_BOX);
        ItemStack Meister_RIGHT = new ItemStack(Material.GREEN_SHULKER_BOX);
        ItemStack Legende_RIGHT = new ItemStack(Material.GREEN_SHULKER_BOX);
        ItemStack Titan_RIGHT = new ItemStack(Material.GREEN_SHULKER_BOX);
        /*
            ITEM_META
         */
        ItemMeta Meister2 = meister.getItemMeta();
        ItemMeta supreme2 = supreme.getItemMeta();
        ItemMeta platin2 = platin.getItemMeta();
        ItemMeta Meister_B = Meister_Block.getItemMeta();
        ItemMeta Legende_B = Legende_Block.getItemMeta();
        ItemMeta Meister_R = Meister_RIGHT.getItemMeta();
        ItemMeta Legende_R = Legende_RIGHT.getItemMeta();
        ItemMeta Titan_R = Titan_RIGHT.getItemMeta();
        ItemMeta Ultra_R = Ultra_RIGHT.getItemMeta();
        /*
            DISPLAY_NAMES
         */
        Meister2.setDisplayName("§aMeister");
        supreme2.setDisplayName("§dSupreme");
        platin2.setDisplayName("§ePlatin");
        Meister_B.setDisplayName("§c§lRang gesperrt !");
        Legende_B.setDisplayName("§c§lRang gesperrt !");
        Ultra_R.setDisplayName("§aDu hast den Rang schon Freigeschaltet");
        Meister_R.setDisplayName("§aDu hast den Rang schon Freigeschaltet");
        Legende_R.setDisplayName("§aDu hast den Rang schon Freigeschaltet");
        Titan_R.setDisplayName("§aDu hast den Rang schon Freigeschaltet");
        /*
            ITEM_LORES
         */
        Meister_B.setLore(Arrays.asList("§8§l>", "§aDu musst erst den vorherigen Rang kaufen." , "§8§l>"));
        Legende_B.setLore(Arrays.asList("§8§l>", "§aDu musst erst den vorherigen Rang kaufen." , "§8§l>"));
        lores.supremeLore(supreme2);
        lores.MeisterLore(Meister2);
        lores.platinLore(platin2);

        /*
            SET ITEM_META
         */
        meister.setItemMeta(Meister2);
        supreme.setItemMeta(supreme2);
        platin.setItemMeta(platin2);
        Meister_Block.setItemMeta(Meister_B);
        Legende_Block.setItemMeta(Legende_B);
        Ultra_RIGHT.setItemMeta(Ultra_R);
        Meister_RIGHT.setItemMeta(Meister_R);
        Legende_RIGHT.setItemMeta(Legende_R);
        Titan_RIGHT.setItemMeta(Titan_R);
        /*
            SET ITEM IN INVENTORY
         */
       if (player.hasPermission("RankUp.Finish")) {
             inventory.setItem(2, Ultra_RIGHT);
             inventory.setItem(4, Meister_RIGHT);
             inventory.setItem(6, Titan_RIGHT);
         }else if(player.hasPermission("RankUp.Rank3")){
           inventory.setItem(2, Meister_RIGHT);
           inventory.setItem(4, Meister_RIGHT);
           inventory.setItem(6, platin);
       }else if(player.hasPermission("RankUp.Rank2")){
            inventory.setItem(2, Meister_RIGHT);
            inventory.setItem(4, Meister_RIGHT);
            inventory.setItem(6, platin);
        }else if(player.hasPermission("RankUp.Rank1")){
            inventory.setItem(2, Meister_RIGHT);
            inventory.setItem(4, supreme);
            inventory.setItem(6, Meister_Block);
        }else  {
             inventory.setItem(2, meister);
             inventory.setItem(4, Meister_Block);
             inventory.setItem(6, Meister_Block);
         }


        player.openInventory(inventory);

    }
}
