package fr.fantasticzoo.model.animals.characteristics;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Oviparous;

import java.util.Random;

public class Egg {
    public int timeRemainingBeforeHatch;

    public String name;
    private final Oviparous mother;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Oviparous getMother() {
        return mother;
    }

    public int getTimeRemainingBeforeHatch() {
        return timeRemainingBeforeHatch;
    }

    public void setTimeRemainingBeforeHatch(int timeRemainingBeforeHatch) {
        this.timeRemainingBeforeHatch = timeRemainingBeforeHatch;
    }

    public Egg(Oviparous mother) {
        this.name = mother.getName() + "'s Egg";
        Random rand = new Random();
        // entre 400 et 800 unités de temps
        this.timeRemainingBeforeHatch = rand.nextInt(400) + 400;
        this.mother = mother;
    }

    /**
     * Cette fonction permet aux œufs d'éclore et instancie un nouveau bébé
     * @return Creature
     */
    public Creature hatch(){
        System.out.println(this.name + " is hatching!!!");

        try {
            Creature baby = (Creature) this.mother.getType().getDeclaredConstructor().newInstance();
            System.out.println(this.name + " has hatched!");
            baby.setName(Names.getRandomName().name());
            return baby;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
