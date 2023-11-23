package fr.fantasticzoo.model;

import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.Random;

public abstract class Creature {

    private final int MAX_HEALTH;
    private final int MAX_HUNGER;
    private String NAME;
    private SexType SEX;
    public CryType cry;
    public int weight;
    public int height;
    public int age;
    public int hunger;
    public boolean isAsleep;
    public int health;
    public int PregnancyState = 0;

    public Boolean isSick = false;

    public void setPregnancyState(int state) {
        PregnancyState = state;
        if (state==9){
            this.giveBirth();
        }
    }

    public int getPregnancyState() {
        return this.PregnancyState;
    }

    public Creature(int maxHealth, int maxHunger, String name, SexType sex) {
        MAX_HEALTH = maxHealth;
        MAX_HUNGER = maxHunger;
        NAME = name;
        SEX = sex;
    }

    public abstract void giveBirth();


    public void eat(Food food) {
        if (!isAsleep()) {
            this.hunger = Math.min(this.hunger + food.getFoodStats(), this.MAX_HUNGER);
            System.out.println(this.NAME +" ate a " + food.getFoodName());
        } else {
            System.out.println(this.NAME + " is asleep and cannot eat.");
        }
    }

    public void cry(CryType cry) {
        if (this.isAsleep) {
            System.out.println(this.NAME + " is asleep and cannot cry.");
        }
        else {
            System.out.println(this.NAME + " cried " + cry);
        }
    }

    public void setCry(CryType cry) {
        this.cry = cry;
    }

    public CryType getCry() {
        return this.cry;
    }

    public void die(){
        if (this.health <= 0) {
            System.out.println(this.NAME + " has died...");
        }
        if (this.hunger <= 0) {
            System.out.println(this.NAME + " has died of hunger...");
        }
        if (this.age >= 100) {
            System.out.println(this.NAME + " has died of old age...");
        }
        if (this.isSick = this.health <= 0) {
            System.out.println(this.NAME + " has died of sickness...");
        }
    }

    public void heal(){
        this.health = this.MAX_HEALTH;
    }


    public void fallAsleep() {
        this.setAsleep(true);
        System.out.println(this.NAME + " fell asleep.");
    }


    public void aging() {
        this.age = this.age + 1;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public SexType getSex() {
        return SEX;
    }

    public void setSex(SexType sex) {
        this.SEX = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isAsleep() {
        return isAsleep;
    }

    public void setAsleep(boolean asleep) {
        isAsleep = asleep;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getMaxHunger() {
        return MAX_HUNGER;
    }

    public abstract void cry();

    public void feed() {

    }

    public boolean getSick() {
        return this.isSick;
    }

    public void setSick(Boolean sick) {
        Random random = new Random();
        int randomNumber = 1 + random.nextInt((15 - 1) + 1);
        if(randomNumber == 1){
            this.isSick = true;
            System.out.println(this.NAME + " is sick");
        }
    }


    protected Iterable<? extends Creature> getAnimals() {
        return null;
    }
}

