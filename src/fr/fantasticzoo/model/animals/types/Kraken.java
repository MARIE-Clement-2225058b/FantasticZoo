package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.enclosure.Enclosure;

public class Kraken extends Oviparous implements Swimming {

    public Kraken() {
        super(100, 100, SexType.MALE, "Kraken");
    }

    public Kraken(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    public int getStrength() {
        return super.getStrength();
    }

    public void setPregnancyState(int state) {
        super.setPregnancyState(state);
    }

    public int getPregnancyState() {
        return super.getPregnancyState();
    }

    public void mate(Creature mate) {
        super.mate(mate);
    }

    public void eat(Food food) {
        super.eat(food);
    }

    public String cry(CryType cry) {
        return super.cry(cry);
    }

    public void die(String reason) {
        super.die(reason);
    }

    public void heal() {
        super.heal();
    }

    public void fallAsleep() {
        super.fallAsleep();
    }

    public void aging() {
        super.aging();
    }

    public void checkAge() {
        super.checkAge();
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public SexType getSex() {
        return super.getSex();
    }

    public void setSex(SexType sex) {
        super.setSex(sex);
    }

    public int getWeight() {
        return super.getWeight();
    }

    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    public int getHeight() {
        return super.getHeight();
    }

    public void setHeight(int height) {
        super.setHeight(height);
    }

    public int getAge() {
        return super.getAge();
    }

    public String getAgeType() {
        return super.getAgeType();
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public int getHunger() {
        return super.getHunger();
    }

    public void setHunger(int hunger) {
        super.setHunger(hunger);
    }

    public boolean isAsleep() {
        return super.isAsleep();
    }

    public void setAsleep(boolean asleep) {
        super.setAsleep(asleep);
    }

    public int getHealth() {
        return super.getHealth();
    }

    public void setHealth(int health) {
        super.setHealth(health);
    }

    public int getMaxHealth() {
        return super.getMaxHealth();
    }

    public int getMaxHunger() {
        return super.getMaxHunger();
    }

    public void feed() {
        super.feed();
    }

    public void giveBirth() {
        super.giveBirth();
    }

    public Class<?> getType() {
        return super.getType();
    }

    public short cry() {
        return super.cry();
    }

    public Egg layEgg() {
        return super.layEgg();
    }

    public String swim() {
        return getName() + " is swimming.";
    }
}
