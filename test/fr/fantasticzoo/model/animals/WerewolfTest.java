package fr.fantasticzoo.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.enclosure.Enclosure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class WerewolfTest {

    static Werewolf jeff = new Werewolf();

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe Werewolf");
        jeff.setName("Jeff");
        jeff.setSex(SexType.MALE);
    }


    @Test
    void cry_of_belonging() {
        jeff.cry(CryType.APPARTENANCE);
        assertEquals("APPARTENANCE", jeff.cry(CryType.APPARTENANCE));
    }

    @Test
    void isWherewolf(){
        assertEquals(jeff.getClass(), Werewolf.class);
    }

    /**
     * Teste si les animaux peuvent manger et regarde si leur niveau de faim n'est bien plus à 0 après avoir mangé.
     */
    @Test
    void eat() {
        jeff.setAsleep(false);
        jeff.setHunger(0);
        jeff.eat(Food.MEAT);
        assertEquals(20, jeff.getHunger());
        jeff.setAsleep(true);
        jeff.eat(Food.MEAT);
        assertEquals(20, jeff.getHunger());
    }

    @Test
    void heal() {
        jeff.setHealth(0);
        jeff.heal();
        assertEquals(100, jeff.getHealth());
    }

    @Test
    void fallAsleep() {
        jeff.setAsleep(false);
        jeff.fallAsleep();
        assertTrue(jeff.isAsleep());
    }

    @Test
    void aging() {
        jeff.setAge(0);
        jeff.aging();
        assertEquals(1, jeff.getAge());
    }

    @Test
    void getName() {
        assertEquals("Jeff", jeff.getName());
    }

    @Test
    void setName() {
        assertEquals("Jeff", jeff.getName());
    }

    @Test
    void getSex() {
        assertEquals(SexType.MALE, jeff.getSex());
    }

    @Test
    void setWeight() {
        jeff.setWeight(100);
        assertEquals(100, jeff.getWeight());
    }

    @Test
    void getHeight() {
        jeff.setHeight(100);
        assertEquals(100, jeff.getHeight());
    }

    @Test
    void setHeight() {
        jeff.setHeight(100);
        assertEquals(100, jeff.getHeight());
    }

    @Test
    void getAge() {
        jeff.setAge(100);
        assertEquals(100, jeff.getAge());
    }

    /**
     * Teste si l'animal peut changer d'âge.
     * @see Creature#setAge(int)
     * Il ne devrait pas être mort normalement (à 100 ans) ?
     */
    @Test
    void setAge() {
        jeff.setAge(100);
        assertEquals(100, jeff.getAge());
    }

    @Test
    void getHunger() {
        jeff.setHunger(100);
        assertEquals(100, jeff.getHunger());
    }

    @Test
    void setHunger() {
        jeff.setHunger(100);
        assertEquals(100, jeff.getHunger());
    }

    @Test
    void isAsleep() {
        jeff.setAsleep(true);
        assertTrue(jeff.isAsleep());
    }

    @Test
    void setAsleep() {
        jeff.setAsleep(true);
        assertTrue(jeff.isAsleep());
    }

    @Test
    void getHealth() {
        jeff.setHealth(100);
        assertEquals(100, jeff.getHealth());
    }

    @Test
    void setHealth() {
        jeff.setHealth(100);
        assertEquals(100, jeff.getHealth());
    }

    @Test
    void getMaxHealth() {
        jeff.setHealth(100);
        assertEquals(100, jeff.getHealth());
    }

    @Test
    void getMaxHunger() {
        jeff.setHunger(100);
        assertEquals(100, jeff.getHunger());
    }

    @Test
    void CanRun() {
        jeff.setAsleep(false);
        jeff.run();
        assertEquals(jeff.name + " is running!", jeff.run());

        jeff.setAsleep(true);
        jeff.run();
        assertEquals(jeff.name + " is asleep and cannot run.", jeff.run());
    }

    /**
     * Teste si les femelles peuvent tomber enceinte.
     */
    @Test
    public void canGetPregnant(){
        jeff.setName("Jeff");

        Werewolf jeffina = new Werewolf();
        jeffina.setName("Jeffina");

        Werewolf joe = new Werewolf();
        joe.setName("Joe");
        joe.setSex(SexType.MALE);

        jeffina.setSex(SexType.FEMALE);
        jeffina.mate(jeff);
        assertEquals(1, jeffina.getPregnancyState());
        assertEquals(0, jeff.getPregnancyState());

        jeff.mate(joe);
        assertEquals(0, jeff.getPregnancyState());
        assertEquals(0, joe.getPregnancyState());
    }


    @Test
    void CanDeliver() {
        Werewolf jeffina = new Werewolf();
        jeffina.setName("Jeffina");

        // Je sais pas comment faire pour récupérer l'enclos ou est rangé l'animal sans lui donner un attribut "enclos" ce qui est dégueulasse mais
        // du coup faudra changer ça
        Enclosure enclosure = new Enclosure("Enclos 1");
        jeffina.enclosure = enclosure;

        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(jeffina);
        enclosure.setAnimals(animals);

        jeffina.setAsleep(false);
        jeffina.deliver();
        assertEquals(2,enclosure.getAnimalCount());
    }

    @Test
    void transformation() {
        jeff.setTransformed(false);
        jeff.transformed = true;
        assertEquals(true, jeff.transformed);
    }

    @Test
    void dieofoldage() {
        // peut être penser à implémenter une MAX_AGE pour chaque animal
        jeff.setAge(100);
        jeff.checkAge();
        assertEquals(0, jeff.getHealth());
    }

    @Test
    void hierarchy() {
        
    }
}