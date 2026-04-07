package main;

public class LootFactory {

    public static final int EXPECTED_NUM_FIELDS = 4;

    public static Loot create(String[] asCsvRecord) {

        if(asCsvRecord == null || asCsvRecord.length != EXPECTED_NUM_FIELDS){
            return null;
        }

        String typeField = asCsvRecord[0].toUpperCase();

        String name = asCsvRecord[1];
        String rarity = asCsvRecord[2];


        switch (typeField) {
            case "WEAPON":
                int damage = Integer.parseInt(asCsvRecord[3]);
                return new Weapon(name, rarity, damage);
            case "CONSUMABLE":
                int resoreAmount = Integer.parseInt(asCsvRecord[3]);
                return new Consumable(name, rarity, resoreAmount);
            default:
                System.out.printf("Skipping unknown Loot type %s", typeField);
                return null;
        }


    }
    
}
