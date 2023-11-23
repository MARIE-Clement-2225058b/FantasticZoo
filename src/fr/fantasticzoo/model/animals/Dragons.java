package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;

public class Dragons extends Creature {
    public Dragons(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    @Override
    public void giveBirth() {

    }


    public void cry() {
        super.cry(CryType.GENERICCRY);
    }

}
