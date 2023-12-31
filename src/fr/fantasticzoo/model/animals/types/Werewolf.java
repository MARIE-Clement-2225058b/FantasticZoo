package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Pack;
import fr.fantasticzoo.model.animals.characteristics.SexType;

import java.util.*;

public class Werewolf extends Viviparous implements Running {

    private int rank;

    private int dominationFactor = 10;

    private boolean transformed = false;

    private int lvl = 0;

    private static final List<Werewolf> allWerewolves = new ArrayList<>();

    public Werewolf() {
        super(100, 100, SexType.MALE, "Werewolf");
        allWerewolves.add(this);
    }

    /**
     * make a werewolf couple with another werewolf, and they are all the strongest
     */
    public String formStrongestCouple() {
        Werewolf strongestMale = null;
        Werewolf strongestFemale = null;

        for (Werewolf werewolf : allWerewolves) {
            if (werewolf.getSex() == SexType.MALE && (strongestMale == null || werewolf.getStrength() > strongestMale.getStrength())) {
                strongestMale = werewolf;
            } else if (werewolf.getSex() == SexType.FEMALE && (strongestFemale == null || werewolf.getStrength() > strongestFemale.getStrength())) {
                strongestFemale = werewolf;
            }
        }

        if (strongestMale != null && strongestFemale != null) {
            System.out.println("The strongest couple is formed by " + strongestMale.getName() + " and " + strongestFemale.getName() + ".");
            Pack pack = new Pack(strongestMale + " and " + strongestFemale , 2, 15);
            pack.addWolf(strongestMale);
            pack.addWolf(strongestFemale);
            return "The strongest couple is formed by " + strongestMale.getName() + " and " + strongestFemale.getName() + ".";
        } else {
            System.out.println("Could not form a couple. Make sure there is at least one male and one female in the pack.");
            return "Could not form a couple. Make sure there is at least one male and one female in the pack.";
        }
    }


    /**
     * @return all werewolves
     */
    public static List<Werewolf> getAllWerewolves() {
        return allWerewolves;
    }

    /**
     * @param lvl
     */
    public void setLvL(int lvl) {
        this.lvl = lvl;
    }

    /**
     * @return lvl
     */
    public int getLvl() {
        if (Objects.equals(this.getAgeType(), "Baby")){
            this.lvl = 0;
            return this.lvl;
        } else if (Objects.equals(this.getAgeType(), "Young")){
            this.lvl = 1;
        } else if (Objects.equals(this.getAgeType(), "Adult")){
            this.lvl = 2;
        } else if (Objects.equals(this.getAgeType(), "Old")){
            this.lvl = 3;
        }

        return this.lvl + this.rank + this.dominationFactor;
    }

    /**
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return name + rank
     */
    public String getRank() {
        List<String> greekAlphabet = Arrays.asList(
                "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda",
                "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Upsilon", "Phi", "Chi", "Psi", "Omega"
        );
        if (rank < greekAlphabet.size()) {
            System.out.println(getName() + " is ranked " + greekAlphabet.get(rank) + ".");
        }
        return getName() + " is ranked " + rank + ".";
    }

    /**
     * @param dominationFactor
     */
    public void setdFactor(int dominationFactor) {
        this.dominationFactor = dominationFactor;
    }

    /**
     * @return dominationFactor
     */
    public int getdFactor() {
        return dominationFactor;
    }

    /**
     * @param transformed
     */
    public void setTransformed(boolean transformed) {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt == 1) {
            transformed = true;
        }
        this.transformed = transformed;
    }

    /**
     * @return transformed
     */
    public boolean getTransformed() {
        return this.transformed;
    }

    /**
     * @param mate
     */
    @Override
    public void mate(Creature mate) {
        super.mate(mate);
    }

    /**
     * @return name +  is running!
     */
    @Override
    public String run() {
        if (!isAsleep()) {
            return getName() + " is running!";
        } else {
            System.out.println(getName() + " is asleep and cannot run.");
            return getName() + " is asleep and cannot run.";
        }
    }

    /**
     * @param cry
     * @return name +  is howling for  cry +  !
     */
    public String cry(CryType cry) {
        for (Werewolf wolf : allWerewolves) {
            if (!isAsleep() && wolf.getSick() < 50) {
                System.out.println(wolf.getName() + " is howling for " + cry + " !");
            } else if (wolf.getSick() > 50) {
                System.out.println(wolf.getName() + " is sick so he cannot howl.");
            } else {
                System.out.println(wolf.getName() + " is asleep and cannot howl.");
            }
        }
        return super.cry(cry);
    }
}
