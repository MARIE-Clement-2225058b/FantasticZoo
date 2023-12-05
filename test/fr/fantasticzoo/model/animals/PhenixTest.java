package fr.fantasticzoo.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.SexType;
import fr.fantasticzoo.model.enclosure.Enclosure;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
 
public class PhenixTest {

    Phenix phenix = new Phenix(100,100, SexType.FEMALE, "Fainix");
    @Test
    public void rebirthTest(){
        phenix.setAge(100);
        assertEquals(100, phenix.getHealth());

    }
}