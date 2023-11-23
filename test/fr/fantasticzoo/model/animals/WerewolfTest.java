package fr.fantasticzoo.model.animals;

import static org.junit.jupiter.api.Assertions.*;
import fr.fantasticzoo.model.CryType;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.SexType;
import org.junit.jupiter.api.Test;

class WerewolfTest {

    Werewolf jeff = new Werewolf();

    @Test
    void cry_of_belonging() {
        jeff.cry(CryType.APPARTENANCE);
        assertEquals("APPARTENANCE", jeff.cry(CryType.APPARTENANCE));
    }
    @Test
    void isWherewolf(){
        assertEquals(jeff.getClass(), Werewolf.class);
    }

    @Test
    void eat() {
        jeff.setName("Jeff");
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
        jeff.setName("Jeff");
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
        jeff.setName("Jeff");
        assertEquals("Jeff", jeff.getName());
    }

    @Test
    void setName() {
        jeff.setName("Jeff");
        assertEquals("Jeff", jeff.getName());
    }

    @Test
    void getSex() {
        jeff.setSex(SexType.MALE);
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
}