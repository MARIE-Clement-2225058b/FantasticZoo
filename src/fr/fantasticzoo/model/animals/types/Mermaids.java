package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.characteristics.Food;
import fr.fantasticzoo.model.animals.characteristics.SexType;

public class Mermaids extends Viviparous implements Swimming {
    public Mermaids(int maxHealth, int maxHunger, SexType sex, String name) {
        super(maxHealth, maxHunger, sex, name);
    }

    public Mermaids(){
        super(100, 100, SexType.FEMALE, "Mermaid");
    }

    /**
     * @return name +  swim in the water.
     */
    @Override
    public String swim() {
        return this.getName() + " is swimming.";
    }
}
