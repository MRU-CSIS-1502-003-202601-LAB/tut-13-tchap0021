package main;

public class Consumable extends Loot{
    
    private int restoreAmount;
    
    public Consumable(String name, String rarity, int restoreAmount){
        super(name, rarity);
        this.restoreAmount = restoreAmount;
    }

    @Override
    public String getEffectDescription(){
        return String.format("A %s %s that has %d uses left.", getRarity(), getName(), restoreAmount);
    }
}