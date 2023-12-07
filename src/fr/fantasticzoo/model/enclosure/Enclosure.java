package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.types.Dragons;

import java.util.ArrayList;

public class Enclosure {
    private String name;
    private int area;
    private int maxAnimal;
    private int cleanness;
    private Creature creatureType;
    private ArrayList<Creature> animals = new ArrayList<>();

    public Enclosure(String name, int area, ArrayList<Creature> animals) {
        this.name = name;
        this.area = area;
        this.maxAnimal = area / 10;
        this.cleanness = 100;
        this.animals = animals;
    }

    public Enclosure(String name) {
        this.name = name;
        this.cleanness = 100;
        this.area = 100;
        this.maxAnimal = area / 10;
    };

    public String getName() {
        return name;
    }

    public Creature getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(Creature creatureType) {
        this.creatureType = creatureType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getMaxAnimal() {
        return maxAnimal;
    }

    public void setMaxAnimal(int maxAnimal) {
        this.maxAnimal = maxAnimal;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public int getCleanness() {
        return cleanness;
    }

    public void setCleanness(int cleanness) {
        this.cleanness = cleanness;
        if (this.cleanness < 10) {
            // Makes all animals sick
            for (Creature animal : animals) {
                animal.setSick(1);
            }
        }
    }

    public ArrayList<Creature> getAnimals() {
        return animals;
    }

    public String getDescription () {
        return name + " : " + animals.size() + " animaux, " + area + "m², " + cleanness + "% de propreté de type : " + getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", maxAnimal=" + maxAnimal +
                ", animalCount=" + animals.size() +
                ", cleanness=" + cleanness +
                ", animals=" + animals +
                ", type=" + this.getClass().getSimpleName() +
                '}';
    }

    public void clean() {
        setCleanness(100);
    }

    public void feedAllCreatures() {
        for (Creature creature : animals){
            creature.feed();
        }
    }

    public boolean transfertCreature(Enclosure another, Creature creature) {
        if(!this.animals.contains(creature)) return false;
        this.animals.remove(creature);
        another.addCreature(creature);

        return true;
    }

    public void addCreature(Creature creature) {
        if((creature instanceof Swimming
                || creature instanceof Flying
                || (creatureType != null && creatureType.getClass() != creature.getClass()) && !animals.isEmpty())
                && !(creature instanceof Dragons))
        {
            System.out.println("This enclosure is not suitable for this animal.");
            return;
        }
        if (animals.isEmpty()){
            creatureType = creature;
        }
        if (animals.size() < maxAnimal) {
            animals.add(creature);
        }
    }
}
