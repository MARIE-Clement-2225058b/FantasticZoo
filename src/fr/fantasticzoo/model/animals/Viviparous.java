package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.Names;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Viviparous extends Creature {
    public Viviparous() {
        super();
    }
    public Viviparous(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    /**
     * Cette méthode est héritée de la classe Creature et permet de mettre bas pour les vivipares.
     * Elle est appelée quand l'animal est enceinte et que le temps de gestation (PregnancyState) est arrivé à son prime (9).
     */
    @Override
    public Creature giveBirth() {
        return deliver();
    }

    @Override
    public short cry() {
        return 0;
    }

    /**
     * Cette fonction permet aux vivipares de mettre bas
     * @return Creature
     */
    public Creature deliver() {
        try {
            Class<?> mother = this.getClass();
            Creature baby = (Creature) mother.getDeclaredConstructor().newInstance();
            baby.setName(Names.getRandomName());
            return baby;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}