package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Swimming;

import java.util.ArrayList;

public class Aviary extends Enclosure{

    public Aviary(String name, int area, ArrayList<Creature> animals) {
        super(name, area, animals);
    }

    public Aviary(String name) {
        super(name);
    }

    @Override
    public void addCreature(Creature creature) {
        if(creature instanceof Flying) {
            if (getAnimals().size() < getMaxAnimal()) {
                getAnimals().add(creature);
            }
            if (getAnimals().isEmpty()){
                setCreatureType(creature);
            }
        } else {
            System.out.println("This creature can't fly, it can't be in this enclosure.");
        }
    }
}
