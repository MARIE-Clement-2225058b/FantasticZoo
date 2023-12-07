package fr.fantasticzoo.model.animals.characteristics;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Oviparous;

public class Egg {
    public int gestationPeriod;
    public int hatchDate;

    public String name;
    private final Oviparous mother;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHatchDate() {
        return hatchDate;
    }

    public void setHatchDate(int hatchDate) {
        this.hatchDate = hatchDate;
    }

    public Oviparous getMother() {
        return mother;
    }

    public Egg(int daysRemaining, Oviparous mother) {
        this.gestationPeriod = 0;
        this.name = mother.getName() + "'s Egg";
        this.hatchDate = daysRemaining;
        this.mother = mother;
    }

    /**
     * Cette fonction aux œufs d'éclore et instancie un nouveau bébé
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
