package fr.fantasticzoo.model.zoo;

import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Enclosure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FantasticZooTest {

    static ZooMaster zooMaster = new ZooMaster();

    static FantasticZoo zoo = new FantasticZoo("Zoo de la mort", new ZooMaster(), 10);

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe FantasticZoo:");
        zooMaster.setName("Mr. Beast");
    }

    @Test
    void addEnclosure() {
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
        ZooMaster Bozo = new ZooMaster();
        zoo.setZooMaster(Bozo);
        assertEquals(Bozo, zoo.getZooMaster());
    }

    @Test
    void removeEnclosure() {
        Enclosure enclosure = new Enclosure("Enclos 1");
        zoo.addEnclosure(enclosure);
        zoo.removeEnclosure(enclosure);
        assertEquals(0, zoo.getEnclosures().size());
    }


}