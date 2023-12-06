package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Swimming;

import java.util.ArrayList;

public class Enclosure {
    private String name;
    private int area;
    private int maxAnimal;
    private int cleanness;
    private ArrayList<Creature> animals = new ArrayList<>();

    public Enclosure(String name, int area, int cleanness, ArrayList<Creature> animals) {
        this.name = name;
        this.area = area;
        this.maxAnimal = area / 10;
        this.cleanness = cleanness;
        this.animals = animals;
    }

    public Enclosure(String name) {
        this.name = name;
        this.area = 100;
        this.maxAnimal = area / 10;
    };

    public String getName() {
        return name;
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
    }

    public ArrayList<Creature> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Creature> animals) {
        this.animals = animals;
    }

    public String getDescription () {
        return name + " : " + animals.size() + " animaux, " + area + "m², " + cleanness + "% de propreté";
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
        another.animals.add(creature);

        return true;
    }

    public void addCreature(Creature creature) {
        if(creature instanceof Swimming || creature instanceof Flying) {
            System.out.println("This enclosure is not suitable for this animal.");
            return;
        }
        if (animals.size() < maxAnimal) {
            animals.add(creature);
        }
    }
}
