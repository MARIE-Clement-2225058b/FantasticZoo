package fr.fantasticzoo.model.animals.types;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.Pack;
import fr.fantasticzoo.model.animals.characteristics.SexType;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Werewolf extends Viviparous implements Running {

    private int rank;

    private int dominationFactor = 10;

    private boolean transformed = false;

    private int lvl = 0;


    public Werewolf() {
        super(100, 100, SexType.MALE, "Werewolf");
    }

    public void setLvL(int lvl) {
        this.lvl = lvl;
    }

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

    public void setRank(int rank) {
        this.rank = rank;
    }

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


    public void setdFactor(int dominationFactor) {
        this.dominationFactor = dominationFactor;
    }

    public int getdFactor() {
        return dominationFactor;
    }

    public void setTransformed(boolean transformed) {
        this.transformed = transformed;
    }

    public boolean getTransformed() {
        return this.transformed;
    }

    @Override
    public void mate(Creature mate) {
        super.mate(mate);
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
