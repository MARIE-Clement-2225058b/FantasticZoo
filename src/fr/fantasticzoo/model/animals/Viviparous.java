package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Viviparous extends Creature {
    public Viviparous(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public void giveBirth() {
        deliver();

    }

    /**
     * @return
     */
    public short cry() {

        return 0;
    }

    public Class<?> getType() {
        return (Class<?>) this.getClass();
    }

    public void deliver() {
        System.out.println(this.name + " is giving birth!!!");

        try {
            Class<?> clazz = this.getClass();
            Object newChild = clazz.getDeclaredConstructor().newInstance();
            // add child to enclosure
            this.enclosure.getAnimals().add((Creature) newChild);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}