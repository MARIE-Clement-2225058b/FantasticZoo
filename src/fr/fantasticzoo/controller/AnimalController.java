package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.ActionType;
import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalController {
    private final UIController uiController;
    private final List<String> missedMessages ;
    private final ArrayList<Enclosure> enclosures;

    public AnimalController(UIController uiController, List<String> missedMessages, ArrayList<Enclosure> enclosures) {
        this.uiController = uiController;
        this.missedMessages = missedMessages;
        this.enclosures = enclosures;
    }

    public void randomlyTriggerAnimalBehaviors() {
        Random rand = new Random();

        for (Enclosure enclosure : enclosures) {
            for (Creature creature : enclosure.getAnimals()) {
                int behaviorChoice = rand.nextInt(3); // 0 = run, 1 = fly, 2 = swim

                switch (behaviorChoice) {
                    case 0: // Courir
                        if (creature instanceof Running) {
                            if(!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.RUNNING))
                                missedMessages.add(((Running) creature).run());
                        }
                        break;
                    case 1: // Voler
                        if (creature instanceof Flying) {
                            if(!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.FLYING))
                                missedMessages.add(((Flying) creature).fly());
                        }
                        break;
                    case 2: // Nager
                        if (creature instanceof Swimming) {
                            if(!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.SWIMMING))
                                missedMessages.add(((Swimming) creature).swim());
                        }
                        break;
                }
            }
        }
    }

    public void decreaseHungerForAllAnimals() {
        Random rand = new Random();
        List<Creature> deadAnimals = new ArrayList<>();

        for (Enclosure enclosure : enclosures) {
            for (Creature creature : enclosure.getAnimals()) {
                int hungerLoss = rand.nextInt(3) + 1;
                creature.setHunger(creature.getHunger() - hungerLoss);
                // Hunger levels
                if (creature.getHunger() <= 0 && creature.getHealth() > 0) {
                    creature.die("starvation");
                    deadAnimals.add(creature);
                } else if (creature.getHunger() < 30 && creature.getHunger() > 25) {
                    missedMessages.add("Warning: " + creature.getName() + " is very hungry!");
                } else if (creature.getHunger() < 60 && creature.getHunger() > 55) {
                    missedMessages.add("Notice: " + creature.getName() + " is starting to get hungry.");
                }
            }

            enclosure.getAnimals().removeAll(deadAnimals);
            deadAnimals.clear();
        }
    }

    public Creature chooseAnimal(int enclosureIndex, ArrayList<Enclosure> enclosures) {
        List<Creature> animals = enclosures.get(enclosureIndex).getAnimals();
        return animals.get(uiController.selectFromList(animals, Creature::getName, "Choose a creature :") - 1);
    }



}
