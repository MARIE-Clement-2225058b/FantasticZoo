package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;
import fr.fantasticzoo.view.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class EnclosureController {
    private final UIController uiController;
    public EnclosureController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     *
     * @param enclosures
     */
    public void dirtyEnclosure(ArrayList<Enclosure> enclosures) {
        for(Enclosure enclosure : enclosures) {
            if(enclosure.getCleanness() > 0) {
                enclosure.setCleanness(enclosure.getCleanness() - 3);
                if(enclosure.getCleanness() < 50)
                    GameEngine.missedMessages.add("The " + enclosure.getName() + " is getting dirtier.");
            }
        }
    }

    /**
     *
     * @param enclosures
     */
    public Enclosure chooseEnclosure(ArrayList<Enclosure> enclosures) {
        int enclosureIndex = uiController.selectFromList(enclosures, Enclosure::getDescription, "Choose an enclosure:");
        if(enclosureIndex == 0) {
            return null;
        }
        return enclosures.get(enclosureIndex - 1);
    }

    /**
     *
     * @param firstEnclosureIndex, otherEnclosures
     */
    public Enclosure chooseEnclosure(int firstEnclosureIndex, ArrayList<Enclosure> otherEnclosures) {
        //otherEnclosures.remove(firstEnclosureIndex);
        return otherEnclosures.get(uiController.selectFromList(otherEnclosures, Enclosure::getDescription, "Choose a second enclosure:") - 1);
    }
}
