package epsi.emile.dadou.fruitmastermind;

import java.util.ArrayList;
import java.util.List;

public class Fruit {
    private String name;
    private Boolean hasSeeds;
    private Boolean peelable;

    public Fruit(enumFruits fruit) {
        this.name = fruit.toString();
        switch (name) {
            case "BANANE" : this.hasSeeds = false; this.peelable = true;
            case "FRAISE" : this.hasSeeds = false; this.peelable = false;
            case "FRAMBOISE" : this.hasSeeds = false; this.peelable = false;
            case "KIWI" : this.hasSeeds = false; this.peelable = true;
            case "ORANGE" : this.hasSeeds = true; this.peelable = true;
            case "PRUNE" : this.hasSeeds = true; this.peelable = false;
            case "RAISIN" : this.hasSeeds = true; this.peelable = false;
            case "CITRON" : this.hasSeeds = true; this.peelable = true;
        }
    }

    public List<Fruit> allFruitsListInit() {
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit(enumFruits.BANANE));
        fruits.add(new Fruit(enumFruits.CITRON));
        fruits.add(new Fruit(enumFruits.FRAISE));
        fruits.add(new Fruit(enumFruits.FRAMBOISE));
        fruits.add(new Fruit(enumFruits.KIWI));
        fruits.add(new Fruit(enumFruits.ORANGE));
        fruits.add(new Fruit(enumFruits.PRUNE));
        fruits.add(new Fruit(enumFruits.RAISIN));

        return fruits;
    }
}
