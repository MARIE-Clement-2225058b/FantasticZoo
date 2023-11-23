package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.SexType;

public class Nymphs extends Creature {
    public Nymphs(int maxHealth, int maxHunger, String name, SexType sex) {
        super(maxHealth, maxHunger, name, sex);
    }

    @Override
    public void giveBirth() {

    }


    public void cry() {
        super.cry(CryType.GENERICCRY);
    }
}
