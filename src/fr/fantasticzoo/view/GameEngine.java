package fr.fantasticzoo.view;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.behaviors.Flying;
import fr.fantasticzoo.model.animals.behaviors.Running;
import fr.fantasticzoo.model.animals.behaviors.Swimming;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Phenix;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class GameEngine {

    private Creature currentAnimal;
    private final AsciiArtView asciiArtView;
    private final ZooMaster player;
    private final Scanner scanner;
    private ArrayList<Enclosure> enclosures;
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private List<String> missedMessages = new ArrayList<>();

    public GameEngine() {
        currentAnimal = new Werewolf();
        asciiArtView = new AsciiArtView();
        scanner = new Scanner(System.in);
        player = new ZooMaster();
        enclosures = new ArrayList<>();
        Enclosure enclosure = new Enclosure("Enclos 1");
        Dragons dragons = new Dragons(100,100, SexType.MALE, "Boris");
        Phenix phenix = new Phenix(100,100, SexType.MALE, "Mark");

        ArrayList<Creature> creatures = new ArrayList<>();
        creatures.add(dragons);
        creatures.add(phenix);
        enclosure.setAnimals(creatures);

        enclosures.add(enclosure);


    }

    public void startGame() {

        executorService.scheduleAtFixedRate(this::decreaseHungerForAllAnimals, 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(this::randomlyTriggerAnimalBehaviors, 0, 5, TimeUnit.SECONDS);


        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            processUserInput(choice);

        }
    }

    public void stopGame() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    private void displayMenu() {
        System.out.println("1. Examiner un enclos");
        System.out.println("2. Nettoyer un enclos");
        System.out.println("3. Nourrir les créatures");
        System.out.println("4. Transférer une créature");
        System.out.println("5. Construire un enclos");
        System.out.println("6. Surveiller le parc");
        System.out.println("Choisissez une option : ");
    }
    private <T> int selectFromList(List<T> items, Function<T, String> displayFunction, String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + displayFunction.apply(items.get(i)));
        }
        return readInt(1, items.size());
    }

    private Enclosure chooseEnclosure() {
        return enclosures.get(selectFromList(enclosures, Enclosure::getDescription, "Choose an enclosure:") - 1);
    }

    private Enclosure chooseEnclosure(int firstEnclosureIndex) {
        List<Enclosure> otherEnclosures = new ArrayList<>(enclosures);
        otherEnclosures.remove(firstEnclosureIndex);
        return otherEnclosures.get(selectFromList(otherEnclosures, Enclosure::getDescription, "Choose a second enclosure:") - 1);
    }

    private int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private int readInt(int min, int max, int exclude) {
        int choice;
        while (true) {
            choice = readInt(min, max);
            if (choice != exclude) {
                return choice;
            }
            System.out.println("You cannot select enclosure " + (exclude + 1) + ". Please choose a different enclosure.");
        }
    }


    private Creature chooseAnimal(int enclosureIndex) {
        List<Creature> animals = enclosures.get(enclosureIndex).getAnimals();
        return animals.get(selectFromList(animals, Creature::getName, "Choisissez une créature :") - 1);
    }

    private void processUserInput(int choice) {
        Enclosure selectedEnclosure;

        switch(choice) {
            case 1:
                selectedEnclosure = chooseEnclosure();
                player.examinateEnclosure(selectedEnclosure);

                break;
            case 2:
                selectedEnclosure = chooseEnclosure();
                player.cleanEnclosure(selectedEnclosure);

                break;
            case 3:
                selectedEnclosure = chooseEnclosure();
                player.feedCreaturesInEnclosure(selectedEnclosure);

                break;
            case 4:

                selectedEnclosure = chooseEnclosure();

                currentAnimal = chooseAnimal(enclosures.indexOf(selectedEnclosure));

                Enclosure secondEnclosure;
                secondEnclosure = chooseEnclosure(enclosures.indexOf(selectedEnclosure));

                player.moveAnimalFromEnclosure(currentAnimal, selectedEnclosure, secondEnclosure);
                break;
            case 5:

                scanner.nextLine();
                System.out.println("Enter the name of the enclosure : ");
                String name = scanner.nextLine();
                System.out.println("Enter the area of the enclosure : ");
                int area = scanner.nextInt();
                System.out.println("Enter the cleanness of the enclosure : ");
                int cleanness = scanner.nextInt();

                enclosures.add(new Enclosure(name, area, cleanness, new ArrayList<>()));
                scanner.nextLine();
                break;
            case 6:
                monitorPark();

                break;

            default:
                System.out.println("Invalid option");
        }
        waitForEnter();
        clearConsole();

    }

    private void monitorPark() {
        System.out.println("Monitoring the park. Press 'Enter' to return to the main menu...");

        AtomicBoolean exitMonitoring = new AtomicBoolean(false);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        Thread monitoringThread = new Thread(() -> {
            while (!exitMonitoring.get()) {
                showMissedMessages();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        monitoringThread.start();

        scanner.nextLine();
        exitMonitoring.set(true);

        try {
            monitoringThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

        private void waitForEnter() {
            System.out.println("OK ?");
            scanner.nextLine();
            scanner.nextLine();
        }


    private void clearConsole() {
        for(int i = 0 ; i < 50 ; i++) System.out.println(" ");
    }


    private void decreaseHungerForAllAnimals() {
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

    private void showMissedMessages() {
        if (!missedMessages.isEmpty()) {
            for (String message : missedMessages) {
                System.out.println(message);
            }
            missedMessages.clear();
        }
    }

    private void randomlyTriggerAnimalBehaviors() {
        Random rand = new Random();

        for (Enclosure enclosure : enclosures) {
            for (Creature creature : enclosure.getAnimals()) {
                int behaviorChoice = rand.nextInt(3); // 0 = run, 1 = fly, 2 = swim

                switch (behaviorChoice) {
                    case 0: // Courir
                        if (creature instanceof Running) {
                            missedMessages.add(((Running) creature).run());
                        }
                        break;
                    case 1: // Voler
                        if (creature instanceof Flying) {
                            missedMessages.add(((Flying) creature).fly());
                        }
                        break;
                    case 2: // Nager
                        if (creature instanceof Swimming) {
                            missedMessages.add(((Swimming) creature).swim());
                        }
                        break;
                }
            }
        }
    }


}

