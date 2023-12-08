package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Swimming;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Aviary extends Enclosure{

    public Aviary(String name, int area, CopyOnWriteArrayList<Creature> animals) {
        super(name, area, animals);
    }

    public Aviary(String name) {
        super(name);
    }

    @Override
    public boolean addCreature(Creature creature) {
        if(creature instanceof Flying) {
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
