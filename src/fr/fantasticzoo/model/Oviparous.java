package fr.fantasticzoo.model;

import java.util.Random;

import static java.lang.Math.random;

public class Oviparous extends Creature{
    public Oviparous(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }


    /**
     *
     */
    @Override
    public void giveBirth() {
        layEgg();

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

    public Egg layEgg() {
        System.out.println(this.name + " is giving birth!!!");

        // returns new egg with random gestation period between 10 and 30 days
        Random rand = new Random();
        int daysRemaining = rand.nextInt(20) + 10;
        return new Egg(daysRemaining, this);
    }

}