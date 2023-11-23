package fr.fantasticzoo.model;

public class Viviparous extends Creature{
    public Viviparous(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public void giveBirth() {

    }

    /**
     * @return
     */
    public short cry() {

        return 0;
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