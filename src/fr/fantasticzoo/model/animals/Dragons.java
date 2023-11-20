package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.CryType;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.SexType;
public class Dragons extends Creature {
    public Dragons(int maxHealth, int maxHunger) {
        super(maxHealth, maxHunger);
    }

    @Override
    public void cry() {
        super.cry(CryType.GENERICCRY);
    }

    /**
     * @param food
     */
    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    /**
     *
     */
    @Override
    public void heal() {
        super.heal();
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
