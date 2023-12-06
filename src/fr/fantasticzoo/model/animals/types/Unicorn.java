package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Unicorn extends Viviparous implements Running {

    public Unicorn() {
        super();
    }

    public Unicorn(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public String run() {
        return getName() + " is running!";
    }
}
