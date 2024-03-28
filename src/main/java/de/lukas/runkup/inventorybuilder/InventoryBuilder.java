package de.lukas.runkup.inventorybuilder;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryBuilder {
    public static Inventory fillWhithGlass(Inventory inventory){
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        for(int i = 0; i< inventory.getSize(); i++){
            inventory.setItem(i, itemStack);
        }
        return inventory;
    }

}
