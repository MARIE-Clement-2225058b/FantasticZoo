package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;

public class Unicorn extends Creature {
    public Unicorn(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    @Override
    public void giveBirth() {

    }

    @Override
    public void cry() {
        super.cry(CryType.GENERICCRY);
    }

}
