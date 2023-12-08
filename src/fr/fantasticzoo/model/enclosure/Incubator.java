package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.characteristics.Egg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Incubator extends Enclosure {

    private CopyOnWriteArrayList<Egg> eggs;

    public Incubator(String name) {
        super(name);
        this.eggs = new CopyOnWriteArrayList<>();
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

/*    public void isHatch() {
        for (Egg egg : eggs) {
            if (egg.getDaysRemainingBeforeHatch() == 0) {
                egg.hatch();
                removeEgg(egg);
            }
        }
    }*/
}
