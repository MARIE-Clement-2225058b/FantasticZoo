package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Phoenix extends Oviparous implements Flying {
    public Phoenix() {
        super();
    }

    public Phoenix(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    /**
     * @return name +  is flying!
     */
    @Override
    public String fly() {
        return getName() + " is flying!";
    }
}
