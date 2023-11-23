package fr.fantasticzoo.model.animals;

import fr.fantasticzoo.model.*;

public class Werewolf extends Viviparous {
    public Werewolf() {
        super(100, 100);
    }

    public Werewolf(int i, int i1) {
        super(i, i1);
    }

    @Override
    public void cry() {
        super.cry(CryType.GENERICCRY);
    }

    // Override the action methods and include a check for asleep state before performing the action

    @Override
    public void giveBirth() {

    }

}
