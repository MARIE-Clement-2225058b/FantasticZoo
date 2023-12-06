package fr.fantasticzoo.model.animals.types;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Werewolf extends Viviparous implements Running {

    public Werewolf() {
        super(100, 100, SexType.MALE, "Werewolf");
        this.setStrength(10);
        this.setdFactor(10);
        this.setRank(0);
        this.setTransformed(false);
        this.setAge(0);
        this.setHunger(0);
    }

    private int dominationFactor;

    private int rank = 0;

    private boolean transformed = false;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void getRank() {
        List<String> greekAlphabet = Arrays.asList(
                "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda",
                "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Upsilon", "Phi", "Chi", "Psi", "Omega"
        );
        if (rank < greekAlphabet.size()) {
            System.out.println(getName() + " is ranked " + greekAlphabet.get(rank) + ".");
        } else {
            System.out.println(getName() + " is ranked " + rank + ".");
        }
    }

    public void setdFactor(int dominationFactor) {
        this.dominationFactor = dominationFactor;
    }

    public int getdFactor() {
        return dominationFactor;
    }

    /**
     *
     */

    public void setTransformed(boolean transformed) {
        this.transformed = transformed;
    }

    public boolean getTransformed() {
        return this.transformed;
    }

    /**
     *
     */
    public int getStrength() {
            return super.getStrength();
    }


    @Override
    public void mate(Creature mate) {
        super.mate(mate);

    }


    /**
     *
     */
    public void setStrength(int strength) {
        super.setStrength(strength);
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
     * Cette fonction renvoie le maximum de santé qu'un loup peut avoir
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
            System.out.println(getName() + " is running!");
            return getName() + " is running!";
        } else {
            System.out.println(getName() + " is asleep and cannot run.");
            return getName() + " is asleep and cannot run.";
        }
    }


    public void giveBirth() {
        super.giveBirth();
    }

    public String cry(CryType cry) {
        //cryTypeWerewolf();
        return super.cry(cry);
    }
/*
    public String cryTypeWerewolf(){
       this.getClass();
       for (super: this.getClass() )
            System.out.println(this.name + " is howling!");
            return this.name + " is howling!";

    }
*/
}
