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

    public String getName() {
        return this.name;
    }

    private Boolean getHasSeeds() {
        return this.hasSeeds;
    }

    private Boolean getPeelable() {
        return this.peelable;
    }
}
