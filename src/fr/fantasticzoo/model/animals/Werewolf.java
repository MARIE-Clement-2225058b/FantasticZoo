package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.*;

import java.util.Random;

public class Werewolf extends Viviparous {

    public Werewolf(int maxHealth, int maxHunger, String name, SexType sex) {
        super(maxHealth, maxHunger, name, sex);
    }

    @Override
    public void giveBirth() {

    }

    @Override
    public void cry() {
        Random random = new Random();
        int randomNumber = 1 + random.nextInt((10 - 1) + 1);
        if (randomNumber == 1){
            this.setCry(CryType.APPARTENANCE);
            System.out.println(this.getName() + " cri de type " + this.getCry());
            for (Creature creature : this.getAnimals()){
                if (creature.getClass() == this.getClass()){
                    creature.cry();
                }
            }
        }
    }

}
