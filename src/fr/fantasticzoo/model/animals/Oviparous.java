package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.SexType;

import java.util.Random;

public class Oviparous extends Creature {
    public Oviparous() {
        super();
    }
    public Oviparous(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }


    /**
     * Cette méthode est héritée de la classe Creature et permet de pondre un œuf pour les ovipares.
     */
    @Override
    public Egg giveBirth() {
        return layEgg();

    }
    public Class<?> getType() {
        return (Class<?>) this.getClass();
    }

    /**
     * @return
     */
    @Override
    public short cry() {

        return 0;
    }

    /**
     * Cette fonction permet aux ovipares de pondre un œuf
     * @return Egg
     */
    public Egg layEgg() {
        // returns new egg with random gestation period between 10 and 30 days
        Random rand = new Random();
        return new Egg(this);
    }

}