package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.enclosure.Aquarium;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonsTest {
    FantasticZoo zoo = new FantasticZoo("Zoo 1", null, 10, null);
    Enclosure enclosure = new Enclosure("Enclosure 1");

    Dragons dragons = new Dragons();

    Dragons femaleDragon = new Dragons();

    @Test
    void successfulMating() {
        femaleDragon.setSex(SexType.FEMALE);
        dragons.setSex(SexType.MALE);

        enclosure.addCreature(femaleDragon);
        enclosure.addCreature(dragons);

        dragons.mate(femaleDragon);
        assertEquals(1, femaleDragon.getPregnancyState());

        femaleDragon.setPregnancyState(9);
        assertEquals(9, femaleDragon.getPregnancyState());

    }
}