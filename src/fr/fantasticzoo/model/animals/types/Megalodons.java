package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Megalodons extends Oviparous implements Swimming {

    public Megalodons() {
        super();
    }

    public Megalodons(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    /**
     * @return name +  swim in the water.
     */
    @Override
    public String swim() {
        return getName() + " swim in the water.";
    }
}