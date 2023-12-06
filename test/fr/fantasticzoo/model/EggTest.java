package fr.fantasticzoo.model;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Kraken;
import fr.fantasticzoo.model.animals.types.Megalodons;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggTest {

    Megalodons marge = new Megalodons(100, 100, SexType.MALE, "Marge");
    Kraken Cthulhu = new Kraken(100, 100, SexType.MALE, "Cthulhu");


    Egg oeufCthulhu = Cthulhu.layEgg();
    Egg oeufmarge = marge.layEgg();

    @Test
    void getHatchDate() {
        // checks that the hatch date is between 10 and 30 days
        assertTrue(oeufmarge.getHatchDate() >= 10 && oeufmarge.getHatchDate() <= 30);
        assertTrue(oeufCthulhu.getHatchDate() >= 10 && oeufCthulhu.getHatchDate() <= 30);

    }

    @Test
    void getEggMother() {
        assertEquals(marge.getName(), oeufmarge.getMother().getName());
        assertEquals(Cthulhu.getName(), oeufCthulhu.getMother().getName());
    }

    @Test
    void successful_hatch() {
        Creature le_bebe_sirene = oeufmarge.hatch();
        assertEquals(marge.getClass(), le_bebe_sirene.getClass());

        Creature le_bebe_poulpe = oeufCthulhu.hatch();
        assertEquals(Cthulhu.getClass(), le_bebe_poulpe.getClass());


    }
}