package fr.fantasticzoo.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Nymphs;
import fr.fantasticzoo.model.animals.types.Phoenix;
import org.junit.jupiter.api.Test;

public class RebirthTest {

    Phoenix phoenix = new Phoenix(100,100, SexType.FEMALE, "Fainix");
    Dragons dragolosse = new Dragons(100,100,SexType.MALE,"Drago");
    Nymphs nymphus = new Nymphs(100,100,SexType.FEMALE,"Nympha");
    @Test
    public void rebirthTest(){
        phoenix.setAge(100);
        dragolosse.setAge(100);
        nymphus.setAge(100);

        // Normalement les animaux meurent à 100 ans mais pas ces trois types là donc leur santé devrait être à 100 et leur âge à 0
        assertEquals(100, phoenix.getHealth());
        assertEquals(0, phoenix.getAge());

        assertEquals(100, dragolosse.getHealth());
        assertEquals(0, dragolosse.getAge());

        assertEquals(100, nymphus.getHealth());
        assertEquals(0, nymphus.getAge());
    }
}