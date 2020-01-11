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
            case "BANANE" : this.hasSeeds = false; this.peelable = true; break;
            case "FRAISE" : this.hasSeeds = false; this.peelable = false; break;
            case "FRAMBOISE" : this.hasSeeds = false; this.peelable = false; break;
            case "KIWI" : this.hasSeeds = false; this.peelable = true; break;
            case "ORANGE" : this.hasSeeds = true; this.peelable = true; break;
            case "PRUNE" : this.hasSeeds = true; this.peelable = false; break;
            case "RAISIN" : this.hasSeeds = true; this.peelable = false; break;
            case "CITRON" : this.hasSeeds = true; this.peelable = true; break;
        }
    }

    public String getName() {
        return this.name;
    }

    public Boolean getHasSeeds() {
        return this.hasSeeds;
    }

    public Boolean getPeelable() {
        return this.peelable;
    }
}
