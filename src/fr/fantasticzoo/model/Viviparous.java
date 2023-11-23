package fr.fantasticzoo.model;

public class Viviparous extends Creature{

    public Viviparous(int maxHealth, int maxHunger, String name, SexType sex) {
        super(maxHealth, maxHunger, name, sex);
    }

    @Override
    public void giveBirth() {

    }

    /**
     *
     */
    public void cry() {

    }

    public void deliver() {
        System.out.println(super.getName() + " is giving birth!!!");

        try {
            Class<?> clazz = this.getClass();
            Object newChild = clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}