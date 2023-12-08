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

    /**
     * @return eggs
     */
    public List<Egg> getEggs() {
        return eggs;
    }

    /**
     * @param egg
     */
    public void addEgg(Egg egg) {
        this.eggs.add(egg);
    }

    /**
     * @param egg
     */
    public void removeEgg(Egg egg) {
        this.eggs.remove(egg);
    }

}
