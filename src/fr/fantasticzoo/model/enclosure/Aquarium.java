package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Swimming;

import java.util.ArrayList;

public class Aquarium extends Enclosure{
    public Aquarium(String name) {
        super(name);
    }
    public Aquarium(String name, int area, ArrayList<Creature> animals) {
        super(name, area, animals);
    }

    @Override
    public void addCreature(Creature creature) {
        if(creature instanceof Swimming) {
            if (getAnimals().size() < getMaxAnimal()) {
                getAnimals().add(creature);
            }
            if (getAnimals().isEmpty()){
                setCreatureType(creature);
            }
        } else {
            System.out.println("This creature can't swim, it can't be in this enclosure.");
        }
    }
}
