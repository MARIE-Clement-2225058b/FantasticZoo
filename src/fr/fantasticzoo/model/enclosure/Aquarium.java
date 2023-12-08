package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Swimming;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Aquarium extends Enclosure{
    public Aquarium(String name) {
        super(name);
    }
    public Aquarium(String name, int area, CopyOnWriteArrayList<Creature> animals) {
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
        }
        return false;
    }
}
