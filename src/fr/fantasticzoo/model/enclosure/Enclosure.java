package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.Creature;

import java.util.ArrayList;

public class Enclosure {
    private String name;
    private int area;
    private int maxAnimal;
    private int cleanness;
    private ArrayList<Creature> animals = new ArrayList<Creature>();

    public Enclosure(String name, int area, int maxAnimal, int cleanness, ArrayList<Creature> animals) {
        this.name = name;
        this.area = area;
        this.maxAnimal = maxAnimal;
        this.cleanness = cleanness;
        this.animals = animals;
    }

    public Enclosure() {

    }

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


    @Override
    public String toString() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", maxAnimal=" + maxAnimal +
                ", animalCount=" + animals.size() +
                ", cleanness=" + cleanness +
                ", animals=" + animals +
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

        // J'ai ajouté un attribut "enclos" aux créatures psk jsp comment récupérer l'enclos ou l'animal est rangé sinon
        // /!\ (bancal AF à changer ASAP)
        creature.enclosure = another;
        return true;
    }
}
