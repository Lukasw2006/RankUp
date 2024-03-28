package de.lukas.runkup.command;

import de.lukas.runkup.Main;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class lores {

    public static void UltraLore(ItemMeta itemMeta){
        ArrayList<String> ultraLore = new ArrayList<>();
        ultraLore.add(" §e§lPreis:  $");
        ultraLore.add(" §cAlle rechte von §7Spieler");
        ultraLore.add(" §b- Max, 6 Plots");
        ultraLore.add(" §b- Max, 20 Kisten Shops");
        ultraLore.add(" §b- Signieren /sign");
        ultraLore.add(" §b- Free Booster /bonusbosster");
        itemMeta.setLore(ultraLore);
    }



    public static void MeisterLore(ItemMeta itemMeta){

        ArrayList<String> Meisterlore = new ArrayList<>();
        Meisterlore.add("- §eAlle Rechte vom §7Spieler - Rang");
        Meisterlore.add("- §eBuntschreiben im Chat");
        Meisterlore.add("- §eBuntschreiben auf Schildern");
        Meisterlore.add("- §eErweiterte Auswahl an Ploträndern");
        Meisterlore.add("- §eItems Signieren /sign");
        Meisterlore.add("- §eMaximal 6 Plots pro CityBuild");
        Meisterlore.add("\n");
        Meisterlore.add("- §7Preis -> §e25.000$");
        itemMeta.setLore(Meisterlore);
    }



    public static void supremeLore(ItemMeta itemMeta){
        ArrayList<String> supremelore = new ArrayList<>();
        supremelore.add("- §eAlle Rechte vom §7Spieler, §aMeister - Rang");
        supremelore.add("- §eStandartmäßig dicke Blaue Schrift im Chat");
        supremelore.add("- §eItems Bunt umbennenen");
        supremelore.add("- §eErweiterte Asuwahl an Ploträndern");
        supremelore.add("- §eSpielerköpfe geben /kopf (alle 7 Tage)");
        supremelore.add("- §eFeuerbälle schießen /fireball");
        supremelore.add("- §eChat leeren /cc");
        supremelore.add("- §eMaximal 8 Plots pro CityBuild");
        supremelore.add("\n");
        supremelore.add("- §7Preis -> §e50.000$");
        itemMeta.setLore(supremelore);
    }



    public static void platinLore(ItemMeta itemMeta){
        ArrayList<String> platinlore = new ArrayList<>();
        platinlore.add("- §eAlle Rechte vom §7Spieler, §aMeister, §dSupreme - Rang");
        platinlore.add("- §eVotekick abstimmungen starten /startkick (alle 24 Stunden)");
        platinlore.add("- §eBonusbooster /bonusbooster (alle 24 Stunden)");
        platinlore.add("- §ePay-all Rechte /pay *");
        platinlore.add("- §eKomplette Auswahl an Ploträndern");
        platinlore.add("- §eMax 10 Plots pro CityBuild");
        platinlore.add("- §7Weitere Funktionen Folgen!");
        platinlore.add("\n");
        platinlore.add("- §7Preis -> §e100.000$");
        itemMeta.setLore(platinlore);
    }
}
