package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;

import java.util.ArrayList;

public class Aquarium extends Enclosure{

    public Aquarium(String name, int area, int maxAnimal, int cleanness, ArrayList<Creature> animals) {
        super(name, area, maxAnimal, cleanness, animals);
    }
}
