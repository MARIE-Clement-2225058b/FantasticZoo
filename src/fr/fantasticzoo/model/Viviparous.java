package fr.fantasticzoo.model;

public class Viviparous extends Creature{
    public Viviparous(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    /**
     *
     */
    @Override
    public void cry() {

    }

    public void deliver() {
        System.out.println(this.name + " is giving birth!!!");

        try {
            Class<?> clazz = this.getClass();
            Object newChild = clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
