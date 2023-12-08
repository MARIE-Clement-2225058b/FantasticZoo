package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.Pack;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WerewolfTest {

    static Werewolf jeff = new Werewolf();
    static Werewolf pedro = new Werewolf();
    static Werewolf loup = new Werewolf();

    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe Werewolf (compte aussi comme test pour les Vivipares):");
        jeff.setName("Jeff");
        jeff.setSex(SexType.MALE);

        pedro.setName("Pedro");
        pedro.setSex(SexType.MALE);

        loup.setName("Loup");
        loup.setSex(SexType.MALE);

    }


    @Test
    void cry_of_belonging() {
        jeff.cry(CryType.APPARTENANCE);
        assertEquals("APPARTENANCE", jeff.cry(CryType.APPARTENANCE));
    }

    @Test
    void cryEveryWereWolf(){
        assertEquals("APPARTENANCE", jeff.cry(CryType.APPARTENANCE));

        loup.setSick(60);
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
    void getSex() {
        assertEquals(SexType.MALE, jeff.getSex());
    }

    @Test
    void setWeight() {
        jeff.setWeight(100);
        assertEquals(100, jeff.getWeight());
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
        assertEquals(jeff.getName() + " is running!", jeff.run());

        jeff.setAsleep(true);
        jeff.run();
        assertEquals(jeff.getName() + " is asleep and cannot run.", jeff.run());
    }

    /**
     * Teste si les femelles peuvent tomber enceinte.
     */
    @Test
    public void canGetPregnant(){
        jeff.setName("Jeff");

        Werewolf jeffina = new Werewolf();
        jeffina.setName("Jeffina");
        jeffina.setAge(20);
        jeffina.setAsleep(false);

        Werewolf joe = new Werewolf();
        joe.setName("Joe");
        joe.setSex(SexType.MALE);
        joe.setAge(20);

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

        FantasticZoo zoo = new FantasticZoo("Zoo 1", null, 10, new ArrayList<Enclosure>());
        Enclosure enclosure = new Enclosure("Enclos 1");
        enclosure.addCreature(jeffina);
        zoo.addEnclosure(enclosure);
        assertEquals(1,enclosure.getAnimalCount());


        jeffina.setAsleep(false);
        jeffina.setPregnancyState(9);

        assertEquals(9, jeffina.getPregnancyState());
    }

    @Test
    void transformation() {
        jeff.setTransformed(false);
        jeff.setTransformed(true);
        assertTrue(jeff.getTransformed());
    }

    @Test
    void dieofoldage() {
        // peut être penser à implémenter une MAX_AGE pour chaque animal
        jeff.setAge(100);
        jeff.checkAge();
        assertEquals(0, jeff.getHealth());
    }


    @Test
    void whatRank(){
        Pack pack = new Pack("Pack", 0, 10);
        pack.addWolf(jeff);
        pack.addWolf(pedro);
        pack.addWolf(loup);

        jeff.setStrength(100);
        pedro.setStrength(50);
        loup.setStrength(20);

        pack.whatRank();
        assertEquals("Jeff is ranked 0.", pack.getWolves().get(0).getRank());
        assertEquals("Pedro is ranked 1.", pack.getWolves().get(1).getRank());
        assertEquals("Loup is ranked 2.", pack.getWolves().get(2).getRank());
    }

    @Test
    void testformStrongestCouple(){
        Werewolf jeffina = new Werewolf();
        jeffina.setName("Jeffina");
        jeffina.setStrength(100);
        jeffina.setSex(SexType.FEMALE);

        Werewolf joe = new Werewolf();
        joe.setName("Joe");
        joe.setStrength(100);
        joe.setSex(SexType.MALE);

        assertEquals("The strongest couple is formed by Joe and Jeffina.", jeffina.formStrongestCouple());
    }

    @Test
    void getLvl(){
        jeff.setAge(1);
        jeff.setStrength(1);
        jeff.setdFactor(1);
        jeff.setRank(1);
        assertEquals(0, jeff.getLvl());

        pedro.setAge(20);
        pedro.setStrength(20);
        pedro.setdFactor(20);
        pedro.setRank(20);
        assertEquals(42, pedro.getLvl());

    }
}