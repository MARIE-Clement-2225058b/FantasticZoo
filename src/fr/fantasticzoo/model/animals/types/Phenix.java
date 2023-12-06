package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Phenix extends Oviparous implements Flying {
    public Phenix() {
        super();
    }

    public Phenix(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    @Override
    public void giveBirth() {

    }
    @Override
    public short cry() {
        return 0;
    }

    public String cry(CryType cry) {
        return cry.toString();
    }

    /**
     * @param food
     * Pour nourrir le dragon
     */
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void heal() {
        super.heal();
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
     * @return
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
     * @return
     */

    public int getAge() {
        return super.getAge();
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
    public String fly() {
        return getName() + " is flying!";
    }
}
