package fr.fantasticzoo.model;

public abstract class Creature {

    private final int MAX_HEALTH;
    private final int MAX_HUNGER;
    public String name;
    public SexType sex;
    public CryType cry;
    public int weight;
    public int height;
    public int age;
    public int hunger;
    public boolean isAsleep;
    public int health;
    public int PregnancyState = 0;

    public int strength;

    public boolean transformed = false;

    public boolean getTransformed() {
        return transformed;
    }

    public void setTransformed(boolean transformed) {
        this.transformed = false;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }


    public void setPregnancyState(int state) {
        PregnancyState = state;
        if (state==9){
            this.giveBirth();
        }
    }

    public Creature(int maxHealth, int maxHunger, SexType sex, String name) {
        MAX_HEALTH = maxHealth;
        MAX_HUNGER = maxHunger;
        this.name = name;
        this.sex = sex;
    }

    public abstract void giveBirth();


    public void eat(Food food) {
        setHunger(hunger + food.getFoodStats());
        System.out.println(this.name +" ate a " + food.getFoodName());
    }

    public String cry(CryType cry) {
        return cry.toString();

    }

    public void die(){
        System.out.println(this.name + "has died...");
    }

    public void heal(){
        this.health = this.MAX_HEALTH;
    }


    public void fallAsleep() {
        this.setAsleep(true);
        System.out.println(this.name + " fell asleep.");
    }


    public void aging() {
        this.age = this.age + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
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

    public String getAgeType() {
        if (age < 1) {
            return "Baby";
        }if (age < 5) {
            return "Young";
        }if (age < 15) {
            return "Adult";
        } else {
            return "Old";
        }
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

    public abstract short cry();

    public void feed() {
    }
}

