package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.types.Mermaids;
import fr.fantasticzoo.model.animals.types.Werewolf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;

class CreatureTest {

    Enclosure enclosure = new Enclosure("Enclos 1");

    @Test
    void setEnclosure() {
        enclosure.setCleanness(0);
        enclosure.clean();
        assertEquals(100, enclosure.getCleanness());
    }

    @Test
    void getEnclosure() {
        Mermaids mermaids = new Mermaids();
        mermaids.setHunger(0);

        Werewolf werewolf = new Werewolf();
        werewolf.setHunger(0);

        ArrayList<Creature> animals = new ArrayList<>();

        enclosure.setAnimals(animals);

        enclosure.feedAllCreatures();

        for (Creature animal : enclosure.getAnimals()) {
            assertEquals(100, animal.getHunger());
        }
    }

    @Test
    void setStrength() {
        Mermaids ariel = new Mermaids();

        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(ariel);
        enclosure.setAnimals(animals);

        Enclosure enclosure2 = new Enclosure("Enclos 2");
        ArrayList<Creature> animals2 = new ArrayList<>();
        enclosure2.setAnimals(animals2);

        enclosure.transfertCreature(enclosure2, ariel);

        assertEquals(0, enclosure.getAnimalCount());
    }

    @Test
    void getStrength() {
        Mermaids ariel = new Mermaids();

        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(ariel);
        enclosure.setAnimals(animals);

        Enclosure enclosure2 = new Enclosure("Enclos 2");
        ArrayList<Creature> animals2 = new ArrayList<>();
        enclosure2.setAnimals(animals2);

        enclosure.transfertCreature(enclosure2, ariel);

        assertEquals(1, enclosure2.getAnimalCount());
    }

    @Test
    void setPregnancyState() {
        Mermaids ariel = new Mermaids();
        ariel.setPregnancyState(1);
        assertEquals(1, ariel.getPregnancyState());

        Mermaids ariel2 = new Mermaids();
        ariel2.setPregnancyState(9);
        assertEquals(9, ariel2.getPregnancyState());
    }

    @Test
    void getPregnancyState() {
        Mermaids ariel = new Mermaids();
        ariel.setPregnancyState(7);
        assertEquals(7, ariel.getPregnancyState());
    }

    @Test
    void giveBirth() {
        Mermaids ariel = new Mermaids();
        ariel.setPregnancyState(9);
        assertEquals(9, ariel.getPregnancyState());
    }

    @Test
    void mate() {
        Mermaids ariel = new Mermaids();
        Mermaids eric = new Mermaids();

        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(ariel);
        animals.add(eric);
        enclosure.setAnimals(animals);

        ariel.mate(eric);

        assertEquals(0, ariel.getPregnancyState());
    }

    @Test
    void eat() {
    }

    @Test
    void cry() {
    }

    @Test
    void heal() {
    }

    @Test
    void fallAsleep() {
    }

    @Test
    void aging() {
    }

    @Test
    void checkAge() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getSex() {
    }

    @Test
    void setSex() {
    }

    @Test
    void getWeight() {
    }

    @Test
    void setWeight() {
    }

    @Test
    void getHeight() {
    }

    @Test
    void setHeight() {
    }

    @Test
    void getAge() {
    }

    @Test
    void getAgeType() {
    }

    @Test
    void setAge() {
    }

    @Test
    void getHunger() {
    }

    @Test
    void setHunger() {
    }

    @Test
    void isAsleep() {
    }

    @Test
    void setAsleep() {
    }

    @Test
    void getHealth() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void getMaxHealth() {
    }

    @Test
    void getMaxHunger() {
    }

    @Test
    void testCry() {
    }

    @Test
    void feed() {
        Mermaids ariel = new Mermaids();
        ariel.setHunger(0);

        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(ariel);
        enclosure.setAnimals(animals);

        enclosure.feedAllCreatures();

        for (Creature animal : enclosure.getAnimals()) {
            assertEquals(100, animal.getHunger());
        }
    }
}