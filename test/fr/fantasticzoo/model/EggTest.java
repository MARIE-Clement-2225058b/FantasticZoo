package fr.fantasticzoo.model;

import fr.fantasticzoo.model.animals.Mermaids;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggTest {

    Mermaids ariel = new Mermaids();
    Egg oeufariel = ariel.layEgg();

    @Test
    void getHatchDate() {
        // checks that the hatch date is between 10 and 30 days
        assertTrue(oeufariel.getHatchDate() >= 10 && oeufariel.getHatchDate() <= 30);

    }

    @Test
    void getEggMother() {
        assertEquals(ariel.name, oeufariel.getMother().name);
    }

    @Test
    void successful_hatch() {
        Creature le_bebe_sirene = oeufariel.hatch();
        assertEquals(ariel.getClass(), le_bebe_sirene.getClass());


    }
}