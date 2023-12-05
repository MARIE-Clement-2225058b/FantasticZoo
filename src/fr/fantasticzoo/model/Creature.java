package fr.fantasticzoo.model;

import fr.fantasticzoo.model.animals.Phenix;
import fr.fantasticzoo.model.enclosure.Enclosure;

public abstract class Creature {

    private final int MAX_HEALTH;
    private final int MAX_HUNGER;
    //private final int MAX_AGE;
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
    public Enclosure enclosure;
    public int strength;

    public Creature(int maxHealth, int maxHunger, SexType sex, String name) {
        MAX_HEALTH = maxHealth;
        MAX_HUNGER = maxHunger;
        this.name = name;
        this.sex = sex;
    }


    public Enclosure getEnclosure(){
        return this.enclosure;
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

    public int getPregnancyState() {
        return PregnancyState;
    }


    // Quand un bébé naît faudra penser à l'ajouter à l'enclos
    public abstract void giveBirth();

    /**
     * @param mate
     * La fonction mate permet de faire se reproduire deux Werewolf.
     * Normalement elle prend comme param un Werewolf mais pour l'instant on va faire avec un Creature.
     */
    public void mate(Creature mate){
        if (!isAsleep()) {
            if (mate.sex != this.sex) {
                System.out.println(this.name + " is mating with " + mate.getName() + ".");
                if (mate.sex == SexType.FEMALE) {
                    mate.setPregnancyState(1);
                    System.out.println(mate.getName() + " is pregnant.");
                } else {
                    this.setPregnancyState(1);
                    System.out.println(this.name + " is pregnant.");
                }
            }
        } else {
            System.out.println(this.name + " is asleep and cannot mate.");
        }
    };


    public void eat(Food food) {
        if (!isAsleep){
            setHunger(hunger + food.getFoodStats());
            System.out.println(this.name +" ate a " + food.getFoodName());
        } else {
            System.out.println(this.name + " is asleep and cannot eat.");
        }
    }

    public String cry(CryType cry) {
        return cry.toString();

    }

    public void die(String reason){
        this.health = 0;
        System.out.println(this.name + " has died of " + reason + ".");
    }

    public void heal(){
        if (!isAsleep()) {
            this.setHealth(MAX_HEALTH);
            System.out.println(this.name + " has been healed.");
        } else {
            System.out.println(this.name + " is asleep and cannot heal.");
        }
    }


    public void fallAsleep() {
        this.setAsleep(true);
        System.out.println(this.name + " fell asleep.");
    }


    public void aging() {
        this.age = this.age + 1;
    }

    public void checkAge(){
        if (this.age > 99){
            if (this.getClass() = Phenix.class){
                this.die("old age");
            }
            this.die("old age");
        }
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

