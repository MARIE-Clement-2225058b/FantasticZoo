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

    /**
     * @param maxHealth
     * @param maxHunger
     * @param sex
     * @param name
     */
    public Dragons(int maxHealth, int maxHunger, SexType sex, String name) {

        super(maxHealth, maxHunger, sex, name);
    }

    /**
     * @return giveBirth()
     */
    @Override
    public Egg giveBirth() {
        return super.giveBirth();
    }

    /**
     * @return name + is running!
     */
    @Override
    public String run() {
        setCurrentAction(ActionType.RUNNING);
        return "(" + this.getClass().getSimpleName() + ") " +  getName() + " is running!";
    }

    /**
     * @return name + is flying!
     */
    @Override
    public String fly() {
        setCurrentAction(ActionType.FLYING);
        return getName() + "(" + this.getClass().getSimpleName() + ") is flying!";
    }

    /**
     * @return name + is swimming!
     */
    @Override
    public String swim() {
        setCurrentAction(ActionType.SWIMMING);
        return getName() + "(" + this.getClass().getSimpleName() + ") is swimming!";
    }
}
