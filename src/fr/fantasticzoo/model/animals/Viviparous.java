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

    public Creature deliver() {
        System.out.println(getName() + " is giving birth!!!");

        try {
            Class<?> mother = this.getClass();
            return (Creature) mother.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}