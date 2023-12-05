package fr.fantasticzoo.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import fr.fantasticzoo.model.SexType;
import org.junit.jupiter.api.Test;

public class RebirthTest {

    Phenix phenix = new Phenix(100,100, SexType.FEMALE, "Fainix");
    Dragons dragolosse = new Dragons(100,100,SexType.MALE,"Drago");
    Nymphs nymphus = new Nymphs(100,100,SexType.FEMALE,"Nympha");
    @Test
    public void rebirthTest(){
        phenix.setAge(100);
        dragolosse.setAge(100);
        nymphus.setAge(100);

        // Normalement les animaux meurent à 100 ans mais pas ces trois types là donc leur santé devrait être à 100
        assertEquals(100, phenix.getHealth());
        assertEquals(100, dragolosse.getHealth());
        assertEquals(100, nymphus.getHealth());
    }
}