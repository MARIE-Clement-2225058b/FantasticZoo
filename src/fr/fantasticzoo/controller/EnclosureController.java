package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;

public class EnclosureController {
    private final UIController uiController;

    public EnclosureController(UIController uiController) {
        this.uiController = uiController;
    }


    public Enclosure chooseEnclosure(ArrayList<Enclosure> enclosures) {
        int enclosureIndex = uiController.selectFromList(enclosures, Enclosure::getDescription, "Choose an enclosure:");
        if(enclosureIndex == 0) {
            return null;
        }
        return enclosures.get(enclosureIndex - 1);
    }

    public Enclosure chooseEnclosure(int firstEnclosureIndex, ArrayList<Enclosure> otherEnclosures) {
        otherEnclosures.remove(firstEnclosureIndex);
        return otherEnclosures.get(uiController.selectFromList(otherEnclosures, Enclosure::getDescription, "Choose a second enclosure:") - 1);
    }
}
