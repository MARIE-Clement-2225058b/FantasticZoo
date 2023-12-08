package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.types.Dragons;

import java.util.concurrent.CopyOnWriteArrayList;

public class Enclosure {
    private String name;
    private int area;
    private int maxAnimal;
    private int cleanness;
    private Creature creatureType;
    private CopyOnWriteArrayList<Creature> animals = new CopyOnWriteArrayList<>();

    /**
     * @param name
     * @param area
     * @param animals
     */
    public Enclosure(String name, int area, CopyOnWriteArrayList<Creature> animals) {
        this.name = name;
        this.area = area;
        this.maxAnimal = area / 10;
        this.cleanness = 100;
        this.animals = animals;
    }

    /**
     * @param name
     */
    public Enclosure(String name) {
        this.name = name;
        this.cleanness = 100;
        this.area = 100;
        this.maxAnimal = area / 10;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return creatureType
     */
    public Creature getCreatureType() {
        return creatureType;
    }

    /**
     * @param creatureType
     */
    public void setCreatureType(Creature creatureType) {
        this.creatureType = creatureType;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * @return maxAnimal
     */
    public int getMaxAnimal() {
        return maxAnimal;
    }

    /**
     * @param maxAnimal
     */
    public void setMaxAnimal(int maxAnimal) {
        this.maxAnimal = maxAnimal;
    }

    /**
     * @return animalCount
     */
    public int getAnimalCount() {
        return animals.size();
    }

    /**
     * @return cleanness
     */
    public int getCleanness() {
        return cleanness;
    }

    /**
     * @param cleanness
     */
    public void setCleanness(int cleanness) {
        this.cleanness = cleanness;
        if (this.cleanness < 10) {
            // Makes all animals sick
            for (Creature animal : animals) {
                animal.setSick(1);
            }
        }
    }

    /**
     * @return animals
     */
    public CopyOnWriteArrayList<Creature> getAnimals() {
        return animals;
    }

    /**
     * @return stats of the enclosure
     */
    public String getDescription () {
        return name + " : " + animals.size() + " animaux, " + area + "m², " + cleanness + "% de propreté de type : " + getClass().getSimpleName();
    }

    /**
     * @return stats of the enclosure
     */
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

    /**
     * set cleanness to 100
     */
    public void clean() {
        setCleanness(100);
    }

    /**
     * feed all creatures in the enclosure
     */
    public void feedAllCreatures() {
        for (Creature creature : animals){
            creature.feed();
        }
    }

    /**
     * @param another
     * @param creature
     * @return true if the creature has been moved
     */
    public boolean transfertCreature(Enclosure another, Creature creature) {
        if(!this.animals.contains(creature)) return false;

        if(another.addCreature(creature))
            this.animals.remove(creature);
        else
            System.out.println("The " + creature.getClass().getSimpleName() + " can't be added to the " + another.getName() + " enclosure.");

        return true;
    }

    /**
     * @param creature
     * @return true if the creature has been added
     */
    public boolean addCreature(Creature creature) {
        if((creature instanceof Swimming
                || creature instanceof Flying
                || (creatureType != null && creatureType.getClass() != creature.getClass()) && !animals.isEmpty())
                && !(creature instanceof Dragons))
        {
            return false;
        }

        if (animals.size() < maxAnimal) {
            if (animals.isEmpty()){
                creatureType = creature;
            }

            animals.add(creature);
            System.out.println("The " + creature.getClass().getSimpleName() + " has been added to the " + this.getName() + " enclosure.");
            return true;
        }
        return false;
    }
}
