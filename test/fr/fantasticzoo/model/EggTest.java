package fr.fantasticzoo.model;

import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Megalodons;
import fr.fantasticzoo.model.enclosure.Aquarium;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggTest {

    Megalodons marge = new Megalodons(100, 100, SexType.FEMALE, "Marge");
    Megalodons homer = new Megalodons(100, 100, SexType.MALE, "Homer");

    Egg oeufmarge = marge.layEgg();

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe Egg:");
    }

    @Test
    void getDays() {
        // checks that the hatch date is between 400 and 800 time units
        System.out.println(oeufmarge.getTimeRemainingBeforeHatch());
        assertTrue(oeufmarge.getTimeRemainingBeforeHatch() >= 400 && oeufmarge.getTimeRemainingBeforeHatch() <= 800);
    }

    @Test
    void getEggMother() {
        assertEquals(marge.getName(), oeufmarge.getMother().getName());
    }

    @Test
    void successful_hatch() {
        Aquarium aquarium = new Aquarium("Aquarium 1");
        aquarium.addCreature(marge);
/*        Creature le_bebe_megalodon = oeufmarge.hatch();

        // il faut bien que le GameEngine puisse ajouter l'enfant à l'enclos
        if(le_bebe_megalodon != null) {
            System.out.println(oeufmarge.getMother().getName() + " has delivered a " + le_bebe_megalodon.getClass().getSimpleName() + " named " + le_bebe_megalodon.getName() + ".");
            aquarium.addCreature(le_bebe_megalodon);
        }

        // On vérifie que le bébé est bien un megalodon et qu'il est bien ajouté à l'aquarium
        assertEquals(marge.getClass(), le_bebe_megalodon.getClass());
        assertEquals(2, aquarium.getAnimalCount());
        assertEquals(0, le_bebe_megalodon.getAge());*/

    }
}