package fr.fantasticzoo.model.zoo;

import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Megalodons;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Aquarium;
import fr.fantasticzoo.model.enclosure.Aviary;
import fr.fantasticzoo.model.enclosure.Enclosure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FantasticZooTest {

    static ZooMaster zooMaster = new ZooMaster();

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe FantasticZoo:");
        zooMaster.setName("Mr. Beast");
    }

    @Test
    void addEnclosure() {
        FantasticZoo zoo = new FantasticZoo("Zoo de la mort", new ZooMaster(), 10, new ArrayList<Enclosure>());

        zoo.addEnclosure(new Enclosure("Enclos 1"));
        assertEquals(1, zoo.getEnclosures().size());

        for (int i = 0; i < 10; i++) {
            zoo.addEnclosure(new Enclosure("Enclos " + (i + 2)));
        }

        assertEquals(10, zoo.getEnclosures().size());

        zoo.addEnclosure(new Enclosure("Enclos 11"));
        assertEquals(10, zoo.getEnclosures().size());
    }

    @Test
    void setZooMaster() {
        FantasticZoo zoo = new FantasticZoo("Zoo de la mort", new ZooMaster(), 10, new ArrayList<Enclosure>());

        ZooMaster Bozo = new ZooMaster();
        zoo.setZooMaster(Bozo);
        assertEquals(Bozo, zoo.getZooMaster());
    }

    @Test
    void removeEnclosure() {
        FantasticZoo zoo = new FantasticZoo("Zoo de la mort", new ZooMaster(), 10, new ArrayList<Enclosure>());

        Enclosure enclosure = new Enclosure("Enclos 1");
        zoo.addEnclosure(enclosure);
        zoo.removeEnclosure(enclosure);
        assertEquals(0, zoo.getEnclosures().size());
    }

    @Test
    void getAnimalsInZoo() {
        FantasticZoo zoo = new FantasticZoo("Zoo de la mort", new ZooMaster(), 10, new ArrayList<Enclosure>());

        Enclosure enclosure = new Enclosure("Enclos 1");
        Aquarium aquarium = new Aquarium("Aquarium 1");
        Aviary aviary = new Aviary("Aviary 1");

        Werewolf werewolf = new Werewolf();
        werewolf.setName("Jeff");
        Megalodons megalodons = new Megalodons();
        megalodons.setName("Bob");
        Dragons dragons = new Dragons();
        dragons.setName("Gérard");

        enclosure.addCreature(werewolf);
        aquarium.addCreature(megalodons);
        aviary.addCreature(dragons);

        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(aquarium);
        zoo.addEnclosure(aviary);

        //zoo.displayAnimals();
        assertEquals(3, zoo.getCreatedAnimalsNumber());
    }


}