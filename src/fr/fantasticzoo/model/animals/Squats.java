package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.SexType;

public class Squats extends Creature {
    public Squats(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    @Override
    public void giveBirth() {

    }


    public void cry() {
        super.cry(CryType.GENERICCRY);
    }
}
