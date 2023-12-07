package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.characteristics.Egg;

import java.util.ArrayList;
import java.util.List;

public class Incubator extends Enclosure {

    private List<Egg> eggs;

    public Incubator(String name) {
        super(name);
        this.eggs = new ArrayList<>();
    }

    public List<Egg> getEggs() {
        return eggs;
    }

    public void addEgg(Egg egg) {
        this.eggs.add(egg);
    }

    public void removeEgg(Egg egg) {
        this.eggs.remove(egg);
    }

    public void isHatch() {
        for (Egg egg : eggs) {
            if (egg.getHatchDate() == 0) {
                egg.hatch();
                removeEgg(egg);
            }
        }
    }
}