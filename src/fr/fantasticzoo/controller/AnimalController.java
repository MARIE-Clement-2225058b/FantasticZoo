package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.ActionType;
import fr.fantasticzoo.model.animals.characteristics.CryType;
import fr.fantasticzoo.model.animals.characteristics.Egg;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fr.fantasticzoo.view.GameEngine.missedMessages;

public class AnimalController {
    private final UIController uiController;
    private final FantasticZoo zoo;

    public AnimalController(UIController uiController, FantasticZoo zoo) {
        this.uiController = uiController;
        this.zoo = zoo;
    }

    public void randomlyTriggerAnimalBehaviors() {
        Random rand = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();


        try {
            for (Enclosure enclosure : zoo.getEnclosures()) {
                for (Creature creature : enclosure.getAnimals()) {
                    int behaviorChoice = rand.nextInt(5); // 0 = Courir, 1 = Voler, 2 = Nager, 3 = Crier
                    int yesOrNo = rand2.nextInt(2); // 0 = Non, 1 = Oui
                    int cryTypeChoice = rand3.nextInt(5); // 0 = Appartenance, 1 = Domination, 2 = Soumission, 3 = Aggressivité, 4 = Générique

                    switch (behaviorChoice) {
                        case 0: // Courir
                            if (creature instanceof Running) {
                                if (!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.RUNNING))
                                    missedMessages.add(((Running) creature).run());
                            }
                            break;
                        case 1: // Voler
                            if (creature instanceof Flying) {
                                if (!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.FLYING))
                                    missedMessages.add(((Flying) creature).fly());
                            }
                            break;
                        case 2: // Nager
                            if (creature instanceof Swimming) {
                                if (!creature.isAsleep() && creature.getHunger() > 20 && !creature.getCurrentAction().equals(ActionType.SWIMMING))
                                    missedMessages.add(((Swimming) creature).swim());
                            }
                            break;
                        case 3: // Crier
                                if (creature instanceof Werewolf werewolf) {
                                    if (yesOrNo == 0) {
                                        if (cryTypeChoice == 0){
                                            missedMessages.add(werewolf.cry(CryType.APPARTENANCE));
                                        } else if (cryTypeChoice == 1) {
                                            missedMessages.add(werewolf.cry(CryType.DOMINATION));
                                        } else if (cryTypeChoice == 2) {
                                            missedMessages.add(werewolf.cry(CryType.SOUMISSION));
                                        } else if (cryTypeChoice == 3) {
                                            missedMessages.add(werewolf.cry(CryType.AGGRESSIVITE));
                                        } else {
                                            missedMessages.add(werewolf.cry(CryType.GENERICCRY));
                                        }
                                    }
                                }
                                break;
                        case 4: //Malade
                            if (creature.getHealth() > 0 && creature.getSick() !=0) {
                                missedMessages.add(creature.getName() + " is sick");
                                creature.setSick(creature.getSick());
                            }
                            break;
                    }

                    if (yesOrNo == 1){
                        if (creature.getSick() > 1){
                            missedMessages.add(creature.getName() + " is losing health by sickness");
                            creature.setSick(creature.getSick());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void layingHandler(){
        for (Egg egg : zoo.getIncubator().getEggs()) {
            egg.setTimeRemainingBeforeHatch(egg.getTimeRemainingBeforeHatch() - 1);
            if (egg.getTimeRemainingBeforeHatch() <= 0) {
                Creature creature = egg.hatch();
                Enclosure suitableEnclosure = null;
                for (Enclosure enclosure : zoo.getEnclosures()) {
                    if (enclosure.addCreature(creature)) {
                        missedMessages.add(creature.getName() + " has hatched and has been added to " + enclosure.getName());
                        suitableEnclosure = enclosure;
                        break;
                    }
                }
                if (suitableEnclosure == null) {
                    missedMessages.add(creature.getName() + " has hatched but there is no suitable enclosure for it. It has been released into the wild.");;
                }
            }
        }

    }



    public void decreaseHungerForAllAnimals() {
        Random rand = new Random();
        List<Creature> deadAnimals = new ArrayList<>();

        for (Enclosure enclosure : zoo.getEnclosures()) {
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
