package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.characteristics.*;

public class Dragons extends Oviparous implements Running, Swimming, Flying {

    public Dragons() {
        super();
    }

    public Dragons(int maxHealth, int maxHunger, SexType sex, String name) {

        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public Egg giveBirth() {
        return super.giveBirth();
    }

    @Override
    public String run() {
        setCurrentAction(ActionType.RUNNING);
        return getName() + " is running!";
    }

    @Override
    public String fly() {
        setCurrentAction(ActionType.FLYING);
        return getName() + " is flying!";
    }

    @Override
    public String swim() {
        setCurrentAction(ActionType.SWIMMING);
        return getName() + " is swimming!";
    }
}
