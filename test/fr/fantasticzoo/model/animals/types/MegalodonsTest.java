package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Aquarium;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegalodonsTest {

    FantasticZoo zoo = new FantasticZoo("Zoo 1", null, 10);
    Aquarium aquarium = new Aquarium("Aquarium 1");

    Megalodons megamind = new Megalodons(100, 100, SexType.MALE, "Megamind");
    Megalodons megadrive = new Megalodons(100, 100, SexType.FEMALE, "Megadrive");

    @Test
    void successfulMating() {
        aquarium.addCreature(megamind);
        aquarium.addCreature(megadrive);

        megamind.mate(megadrive);
        assertEquals(1, megadrive.getPregnancyState());

        megadrive.setPregnancyState(9);
        assertEquals(0, megadrive.getPregnancyState());
        // l'oeuf est ajouté à... la couveuse ? L'enclos ? JISSÉPOH !
        // voir deliver() dans Creature.java

    }
}