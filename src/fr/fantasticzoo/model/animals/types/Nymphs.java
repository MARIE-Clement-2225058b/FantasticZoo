package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Nymphs extends Viviparous implements Flying {
    public Nymphs() {
        super();
    }
    public Nymphs(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public String fly() {
        return "(" + this.getClass().getSimpleName() + ") " + getName() + " is flying!";
    }
}
