package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.animals.characteristics.*;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Nymphs;
import fr.fantasticzoo.model.animals.types.Phoenix;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import fr.fantasticzoo.view.GameEngine;

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
    private ActionType currentAction = ActionType.IDLE;
    private int health;
    private int PregnancyState = 0;
    private int strength;
    private int sick = 0;
    private SicknessType sicknessType;

    public Creature() {
        this.MAX_AGE = 100;
        this.MAX_HEALTH = 100;
        this.MAX_HUNGER = 100;
        this.name = "Creature";
        this.sex = SexType.getRandomSex();
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
        this.weight = 100;
        this.height = 160;
        this.MAX_HEALTH = maxHealth;
        this.MAX_HUNGER = maxHunger;
        this.name = name;
        this.sex = sex;
        this.health = MAX_HEALTH;
        this.hunger = MAX_HUNGER;
    }

/**
     * Returns the advancement of the sickness level
     * @return int
     */
    public int getSick() {
        return sick;
    }

    /**
     * Returns the sickness type
     * @return SicknessType
     */
    public SicknessType getSicknessType() {
        return sicknessType;
    }

    /**
     * Sets the sickness type
     * @param sicknessType
     */
    public void setSicknessType(SicknessType sicknessType) {
        this.sicknessType = sicknessType;
    }

    /**
     * Sets the advancement of the sickness level
     * If the sickness level is greater than 100, the animal dies of the sickness
     * @param sick
     */
    public void setSick(int sick) {
        this.sick = sick + 1;
    }

    /**
     * Sets the value of Strength
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
     * Mets à jour l'avancée de la grossesse
     * @param state
     */
    public void setPregnancyState(int state) {
        this.PregnancyState = state;
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
     * La fonction giveBirth permet de faire accoucher un animal. Elle dépend de l'animal, s'il est un ovipare ou un vivipare.
     */
    public abstract Object giveBirth();

    /**
     * @param mate
     * La fonction mate permet de faire se reproduire deux créatures.
     */
    public void mate(Creature mate){
        if (!isAsleep()) {
            if (mate.sex != this.sex && mate.getPregnancyState() == 0 && this.getPregnancyState() == 0) {
                if (mate.sex == SexType.FEMALE) {
                    mate.setPregnancyState(1);
                } else {
                    this.setPregnancyState(1);
                }
            }
        }
    }

    /**
     * @param food
     * Pour nourrir l'animal, on fournit un aliment.
     * Sa faim est augmentée de la valeur de l'aliment.
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

    /**
     * @param reason
     * La fonction damage permet de faire perdre de la vie à l'animal.
     * On met la vie à 0 et on affiche la raison de la mort.
     */
    public void die(String reason){
        this.health = 0;
        GameEngine.missedMessages.add(this.name + " has died of " + reason + ".");
    }

    /**
     * La fonction heal permet de soigner l'animal.
     * Elle remet sa santé au maximum.
     */
    public void heal() {
        this.setHealth(MAX_HEALTH);
        this.sick = 0;
        this.sicknessType = null;
        System.out.println(this.name + " has been healed.");
    }

    /**
     * La méthode fallAsleep permet de faire dormir l'animal.
     * Elle met son action à "dormir" et affiche un message.
     */
    public void fallAsleep() {
        this.setAsleep(true);
        System.out.println(this.name + " fell asleep.");
    }

    /**
     * La méthode aging permet de faire vieillir l'animal.
     * Elle incrémente l'âge de 1.
     */
    public void aging() {
        setAge(age + 1);
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

    public String getDescription() {
        return getName() + " is a " + getAgeType() + " " + getClass().getSimpleName() + " (" + getSex() + "). \n" +
                "It is " + getAge() + " years old, " + getHeight() + "cm tall and weighs " + getWeight() + "kg. \n" +
                "It is currently " + getCurrentAction() + " and has " + getHunger() + "% hunger and " + getHealth() + "% health.";
    }
}

