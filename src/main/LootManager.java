package main;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - " +
            item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    public static LootManager load(String START_FILE_PATH) throws FileNotFoundException {

        LootManager lootmanager = new LootManager();

        Scanner fileScanner = new Scanner(new File(START_FILE_PATH));

        fileScanner.nextLine();

        while(fileScanner.hasNextLine()){
            String[] csvParts = fileScanner.nextLine().split(",");

            Loot loot = LootFactory.create(csvParts);
            lootmanager.add(loot);
        }

        fileScanner.close();

        return lootmanager;
        
    }

    public void save(String END_FILE_PATH) throws FileNotFoundException {

        PrintWriter fileWriter = new PrintWriter(new File(END_FILE_PATH));

        fileWriter.println("TYPE, NAME, RARITY, SPECIAL_1");

        for(Loot loot : inventory) {
            fileWriter.println(loot.asCsvRecord());
        }
        fileWriter.close();
    }

    public void add(Loot loot){
        if(loot != null){
            inventory.add(loot);
        }

    }
}