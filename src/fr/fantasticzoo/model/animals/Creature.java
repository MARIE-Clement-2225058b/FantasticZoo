package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.characteristics.ActionType;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Nymphs;
import fr.fantasticzoo.model.animals.types.Phoenix;

public abstract class Creature {

    private final int MAX_HEALTH;
    private final int MAX_HUNGER;

    private final int MAX_AGE;

    private String name;

    private SexType sex;

    private CryType cry;
    private int weight;
    private int height;
    private int age;
    private int hunger;
    private ActionType currentAction;
    private int health;
    private int PregnancyState = 0;
    private int strength;


    public Creature() {
        this.MAX_AGE = 100;
        this.MAX_HEALTH = 100;
        this.MAX_HUNGER = 100;
        this.name = "Creature";
        this.sex = SexType.MALE;
        this.health = MAX_HEALTH;
        this.hunger = MAX_HUNGER;
    }
    public Creature(int maxHealth, int maxHunger, int maxAge, SexType sex, String name) {
        this.MAX_AGE = maxAge;
        this.MAX_HEALTH = maxHealth;
        this.MAX_HUNGER = maxHunger;
        this.name = name;
        this.sex = sex;
        this.health = MAX_HEALTH;
        this.hunger = MAX_HUNGER;
    }
    public Creature(int maxHealth, int maxHunger, SexType sex, String name) {
        this.MAX_AGE = 100;
        this.MAX_HEALTH = maxHealth;
        this.MAX_HUNGER = maxHunger;
        this.name = name;
        this.sex = sex;
        this.health = MAX_HEALTH;
        this.hunger = MAX_HUNGER;
    }

    /**
     * Sets the value of Enclosure
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Returns the value of Strength
     * @return int
     */
    public int getStrength() {
        return strength;
    }


    /**
     * Sets the value of pregnancyState
     * @param state
     */
    public void setPregnancyState(int state) {
        PregnancyState = state;
        if (state==9){
            this.giveBirth();
        }
    }

    /**
     * Returns the value of pregnancyState
     * @return int
     */
    public int getPregnancyState() {
        return PregnancyState;
    }


    // Quand un bébé naît faudra penser à l'ajouter à l'enclos

    /**
     * La fonction giveBirth permet de faire accoucher un animal. Elle dépend de l'animal, s'il est une ovipare ou un vivipare.
     */
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

    /**
     * @param food
     * Pour nourrir l'animal
     */
    public void eat(Food food) {
        if (!isAsleep()) {
            setHunger(hunger + food.getFoodStats());
            System.out.println(this.name +" ate a " + food.getFoodName());
        } else {
            System.out.println(this.name + " is asleep and cannot eat.");
        }
    }

    /**
     * @param cry
     * Le cri par défaut de l'animal
     */
    public String cry(CryType cry) {
        return cry.toString();

    }

    public void die(String reason){
        this.health = 0;
        System.out.println(this.name + " has died of " + reason + ".");
    }

    public void heal() {
        this.setHealth(MAX_HEALTH);
        System.out.println(this.name + " has been healed.");
    }

    public void fallAsleep() {
        this.setAsleep(true);
        System.out.println(this.name + " fell asleep.");
    }


    public void aging() {
        this.age = this.age + 1;
    }

    /**
     * La méthode checkAge permet de vérifier l'âge de l'animal et de le faire mourir s'il est trop vieux.
     * Par contre, si c'est un animal qui peut renaître, il ne meurt pas !
     */
    public void checkAge(){
        if (this.age >= MAX_AGE){
            if (this instanceof Phoenix || this instanceof Dragons || this instanceof Nymphs){
                setAge(0);
                this.setHealth(MAX_HEALTH);
                System.out.println(this.name + " has been reborn.");
            }
            else {
                this.die("old age");
            }
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

    public ActionType getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(ActionType action) {
        this.currentAction = action;
    }

    /**
     * @return String
     * Retourne le stade de vie de l'animal en fonction de son âge
     */
    public String getAgeType() {
        if (age < 5) {
            return "Baby";
        }if (age < 20) {
            return "Young";
        }if (age < 60) {
            return "Adult";
        } else {
            return "Old";
        }
    }

    public void setAge(int age) {
        this.age = age;
        checkAge();
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isAsleep() {
        return this.currentAction == ActionType.SLEEPING;
    }

    public void setAsleep(boolean asleep) {
        if (asleep) {
            this.currentAction = ActionType.SLEEPING;
        } else {
            this.currentAction = ActionType.IDLE;
        }
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
        this.hunger = MAX_HUNGER;
    }


}

