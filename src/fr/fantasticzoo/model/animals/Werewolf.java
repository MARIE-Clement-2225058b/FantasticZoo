package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.Running;
import fr.fantasticzoo.model.*;
import java.util.Random;

public class Werewolf extends Viviparous implements Running {
    public Werewolf() {
        super(100, 100, SexType.MALE, "Werewolf");
    }

    /**
     *
     */
    @Override
    public void setTransformed(boolean transformed) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1;
        if (!isAsleep()) {
            if (randomNumber == 1) {
                this.transformed = true;
                System.out.println("The Werewolf has transformed.");
            }
        }
    }

    public boolean getTransformed() {
        return super.getTransformed();
    }

    /**
     *
     */
    public int getStrength() {
            return super.getStrength();
    }

    /**
     *
     */
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    /**
     * @param food
     */
    @Override
    public void eat(Food food) {
        if (!isAsleep()) {
            super.eat(food);
        } else {
            System.out.println("The Werewolf is asleep and cannot eat.");
        }
    }

    /**
     * 
     */
    @Override
    public void heal() {
        if (!isAsleep()) {
            super.heal();
        } else {
            System.out.println("The Werewolf is asleep and cannot heal.");
        }
    }

    /**
     * 
     */

    public void fallAsleep() {
        super.fallAsleep();
    }

    /**
     * 
     */

    public void aging() {
        super.aging();
    }

    /**
     * @return 
     */

    public String getName() {
        return super.getName();
    }

    /**
     * @param name 
     */

    public void setName(String name) {
        super.setName(name);
    }

    /**
     * @return 
     */

    public SexType getSex() {
        return super.getSex();
    }

    /**
     * @param sex 
     */

    public void setSex(SexType sex) {
        super.setSex(sex);
    }

    /**
     * @return 
     */

    public int getWeight() {
        return super.getWeight();
    }

    /**
     * @param weight 
     */

    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    /**
     * @return height
     */

    public int getHeight() {
        return super.getHeight();
    }

    /**
     * @param height 
     */

    public void setHeight(int height) {
        super.setHeight(height);
    }

    /**
     * @return age
     */

    public int getAge() {
        return super.getAge();
    }

    /**
     * @return type of age
     */

    public String getAgeType() {
        return super.getAgeType();
    }

    /**
     * @param age 
     */

    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * @return 
     */

    public int getHunger() {
        return super.getHunger();
    }

    /**
     * @param hunger 
     */

    public void setHunger(int hunger) {
        super.setHunger(hunger);
    }

    /**
     * @return 
     */

    public boolean isAsleep() {
        return super.isAsleep();
    }

    /**
     * @param asleep 
     */

    public void setAsleep(boolean asleep) {
        super.setAsleep(asleep);
    }

    /**
     * @return health
     */

    public int getHealth() {
        return super.getHealth();
    }

    /**
     * @param health 
     */

    public void setHealth(int health) {
        super.setHealth(health);
    }

    /**
     * @return 
     */

    public int getMaxHealth() {
        return super.getMaxHealth();
    }

    /**
     * @return 
     */

    public int getMaxHunger() {
        return super.getMaxHunger();
    }

    @Override
    public String run() {
        if (!isAsleep()) {
            System.out.println(this.name + " is running!");
            return this.name + " is running!";
        } else {
            System.out.println(this.name + " is asleep and cannot run.");
            return this.name + " is asleep and cannot run.";
        }


    }
}
