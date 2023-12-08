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
    public boolean addCreature(Creature creature) {
        if(creature instanceof Swimming) {
            if (getAnimals().size() < getMaxAnimal()) {
                if (getAnimals().isEmpty()){
                    setCreatureType(creature);
                }
                getAnimals().add(creature);
                return true;
            }
        } else {
            System.out.println("This creature can't swim, it can't be in this enclosure.");
        }
        return false;
    }
}
