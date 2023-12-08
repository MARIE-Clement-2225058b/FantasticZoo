package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.types.Megalodons;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IncubatorTest {

    FantasticZoo zoo = new FantasticZoo("Zoo 1", null, 10, new ArrayList<Enclosure>());

    Aquarium aquarium = new Aquarium("Aquarium 1");

    Incubator incubator = new Incubator("Incubateur 1");

    static Megalodons megamind = new Megalodons();

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe Incubator:");
        megamind.setName("Megamind");
    }

    /**
     * L'ajout des eoufs à l'incubateur doit être géré par le game engine.
     */
    @Test
    void addEgg() {
        incubator.addEgg(megamind.layEgg());
        assertEquals(1, incubator.getEggs().size());
    }

    @Test
    void removeEgg() {
    }

    @Test
    void isHatch() {
    }
}