package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.enclosure.Enclosure;

public class Kraken extends Oviparous implements Swimming {

    public Kraken() {
        super(100, 100, SexType.MALE, "Kraken");
    }

    /**
     * @param maxHealth
     * @param maxHunger
     * @param sex
     * @param name
     */
    public Kraken(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    /**
     * @return name + is swimming.
     */
    @Override
    public String swim() {
        return getName() + " is swimming.";
    }
}
