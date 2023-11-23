package fr.fantasticzoo.model;

public class Oviparous extends Creature{
    public Oviparous(int maxHealth, int maxHunger, String name, SexType sex) {
        super(maxHealth, maxHunger, name, sex);
    }

    /**
     *
     */
    @Override
    public void giveBirth() {
        layEgg();

    }

    /**
     *
     */
    @Override
    public void cry() {

    }

    public void layEgg() {
        System.out.println(this.getName() + " is giving birth!!!");

        try {
            Egg egg = new Egg(2);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}