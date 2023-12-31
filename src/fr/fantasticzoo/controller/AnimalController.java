package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.Oviparous;
import fr.fantasticzoo.model.animals.Viviparous;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.*;
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

    /**
     * This method is used to randomly trigger animal behaviors.
     * It is called every 10 seconds.
     */
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
                                werewolf.setTransformed(werewolf.getTransformed());
                                if (werewolf.getTransformed()){
                                    missedMessages.add(werewolf.getName() + " is transformed and fight the ZOO Master");
                                    if (yesOrNo == 1){
                                        werewolf.die(" Kill by the ZOO master");
                                    }
                                    else {
                                        missedMessages.add("The ZOO master is dead, " + werewolf.getName() + " is the new ZOO master");
                                        missedMessages.add("GAME OVER");
                                        System.exit(0);
                                    }
                                }
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
                                missedMessages.add(creature.getName() + " is sick of " + creature.getSicknessType().getSicknessName());
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

    /**
     * It's used to make animals sick if their enclosure is dirty.
     */
    public void becomeSick() {
        for (Enclosure enclosure : zoo.getEnclosures()) {
            if(enclosure.getCleanness() < 30 ) {
                for (Creature creature : enclosure.getAnimals()) {
                    if(creature.getSicknessType() == null) {
                        creature.setSicknessType(SicknessType.getRandomSickness());
                        missedMessages.add("The enclosure " + enclosure.getName() + " is dirty, " + creature.getName() + " is sick of " + creature.getSicknessType().getSicknessName() + ".");

                    } else{
                        creature.setSick(creature.getSick() + creature.getSicknessType().getGravity());
                        creature.setHealth(creature.getHealth() - creature.getSicknessType().getGravity());
                        if(creature.getSick() >50) {
                            missedMessages.add(creature.getName() + " is dangerously sick of " + creature.getSicknessType().getSicknessName());
                        }
                        else if (creature.getSick() > 70) {
                            missedMessages.add(creature.getName() + " is very dangerously sick of " + creature.getSicknessType().getSicknessName());
                        }
                        else if(creature.getSick() > 90) {
                            missedMessages.add(creature.getName() + " is extremely dangerously sick of " + creature.getSicknessType().getSicknessName());
                        }
                        else if(creature.getSick() > 100) {
                            creature.die("sickness");
                            missedMessages.add(creature.getName() + " has died of " + creature.getSicknessType().getSicknessName());
                        }
                    }
                }
            }

        }
    }

    /**
     * It's where the eggs are hatched.
     */
    public void hatchHandler(){
        for (Egg egg : zoo.getIncubator().getEggs()) {
            egg.setTimeRemainingBeforeHatch(egg.getTimeRemainingBeforeHatch() - 10);
            if (egg.getTimeRemainingBeforeHatch() <= 0) {
                Creature creature = egg.hatch();
                creature.setName(Names.getRandomName());

                Enclosure suitableEnclosure = null;
                for (Enclosure enclosure : zoo.getEnclosures()) {
                    if (enclosure.addCreature(creature)) {
                        missedMessages.add(creature.getName() + " the " + creature.getClass().getSimpleName() + "has hatched and has been added to " + enclosure.getName());
                        suitableEnclosure = enclosure;
                        break;
                    }
                }
                if (suitableEnclosure == null) {
                    missedMessages.add(creature.getName() + " the " + creature.getClass().getSimpleName() +
                            "has hatched but there was no suitable enclosure for it. It has been released into the wild.");
                }
            }
        }
    }

    /**
     * It's animals pregnancy handler.
     */
    public void pregnancyHandler() {
        try {
            for (Enclosure enclosure : zoo.getEnclosures()) {
                for (Creature creature : enclosure.getAnimals()) {

                    if (creature.getPregnancyState() > 0) {

                        creature.setPregnancyState(creature.getPregnancyState() + 1);
                        if (creature.getPregnancyState() == 9) {
                            creature.setPregnancyState(0);

                            if(creature instanceof Oviparous) {
                                missedMessages.add(creature.getName() + " has laid an egg.");

                                Egg egg = ((Oviparous) creature).layEgg();
                                zoo.getIncubator().addEgg(egg);

                            } else if(creature instanceof Viviparous) {
                                Creature baby = ((Viviparous) creature).giveBirth();
                                baby.setName(Names.getRandomName());
                                Enclosure suitableEnclosure = null;
                                for (Enclosure enclosure1 : zoo.getEnclosures()) {
                                    if (enclosure1.addCreature(baby)) {
                                        missedMessages.add(creature.getName() + " has given birth a little baby " + baby.getClass().getSimpleName() + ".");
                                        missedMessages.add(baby.getName() + " has been added to " + enclosure1.getName());
                                        suitableEnclosure = enclosure1;
                                        break;
                                    }
                                }

                                if (suitableEnclosure == null) {
                                    missedMessages.add(baby.getName() + " has been released into the wild.");
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * It's for find a partner for animals.
     */
    public void findPartner() {
        for (Enclosure enclosure : zoo.getEnclosures()) {
            List<Creature> animals = enclosure.getAnimals();
            for (Creature creature : animals) {
                if (shouldFindPartner(creature)) {
                    findMateForCreature(creature, animals);
                }
            }
        }
    }

    /**
     *
     * @param creature
     * @return
     */
    private boolean shouldFindPartner(Creature creature) {
        return !creature.isAsleep() && creature.getAgeType().equals("Adult");
    }

    /**
     *
     * @param creature
     * @param animals
     */
    private void findMateForCreature(Creature creature, List<Creature> animals) {
        animals.stream()
                .filter(potentialPartner -> isSuitableMate(creature, potentialPartner))
                .findFirst()
                .ifPresent(creature::mate);
    }

    /**
     *
     * @param creature
     * @param potentialPartner
     * @return
     */
    private boolean isSuitableMate(Creature creature, Creature potentialPartner) {
        return !potentialPartner.isAsleep() &&
                potentialPartner.getPregnancyState() == 0 &&
                potentialPartner.getAgeType().equals("Adult") &&
                creature.getSex() != potentialPartner.getSex();
    }

    /**
     * It's for increase hunger for all animals.
     */
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

    /**
     *
     * @param enclosureIndex
     * @param enclosures
     * @return
     */
    public Creature chooseAnimal(int enclosureIndex, ArrayList<Enclosure> enclosures) {
        List<Creature> animals = enclosures.get(enclosureIndex).getAnimals();
        return animals.get(uiController.selectFromList(animals, Creature::getName, "Choose a creature :") - 1);
    }



}
