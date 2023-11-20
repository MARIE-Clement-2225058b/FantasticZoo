package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.*;

public class Werewolf extends Viviparous {
    public Werewolf(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    @Override
    public void cry() {
        super.cry(CryType.GENERICCRY);
    }

    // Override the action methods and include a check for asleep state before performing the action

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
    @Override
    public void fallAsleep() {
        super.fallAsleep();
    }

    /**
     * 
     */
    @Override
    public void aging() {
        super.aging();
    }

    /**
     * @return 
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @param name 
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * @return 
     */
    @Override
    public SexType getSex() {
        return super.getSex();
    }

    /**
     * @param sex 
     */
    @Override
    public void setSex(SexType sex) {
        super.setSex(sex);
    }

    /**
     * @return 
     */
    @Override
    public int getWeight() {
        return super.getWeight();
    }

    /**
     * @param weight 
     */
    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    /**
     * @return 
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }

    /**
     * @param height 
     */
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    /**
     * @return 
     */
    @Override
    public int getAge() {
        return super.getAge();
    }

    /**
     * @param age 
     */
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * @return 
     */
    @Override
    public int getHunger() {
        return super.getHunger();
    }

    /**
     * @param hunger 
     */
    @Override
    public void setHunger(int hunger) {
        super.setHunger(hunger);
    }

    /**
     * @return 
     */
    @Override
    public boolean isAsleep() {
        return super.isAsleep();
    }

    /**
     * @param asleep 
     */
    @Override
    public void setAsleep(boolean asleep) {
        super.setAsleep(asleep);
    }

    /**
     * @return health
     */
    @Override
    public int getHealth() {
        return super.getHealth();
    }

    /**
     * @param health 
     */
    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    /**
     * @return 
     */
    @Override
    public int getMaxHealth() {
        return super.getMaxHealth();
    }

    /**
     * @return 
     */
    @Override
    public int getMaxHunger() {
        return super.getMaxHunger();
    }
}