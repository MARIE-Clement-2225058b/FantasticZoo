package fr.fantasticzoo.view;

import fr.fantasticzoo.controller.AnimalController;
import fr.fantasticzoo.controller.EnclosureController;
import fr.fantasticzoo.controller.UIController;
import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.*;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Aquarium;
import fr.fantasticzoo.model.enclosure.Aviary;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.zoo.FantasticZoo;

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

    private final Scanner scanner;
    private final Object scannerLock = new Object();

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
    private final ArrayList<String> defaultChoice = new ArrayList<>();
    public static final List<String> missedMessages = new ArrayList<>();
    private final FantasticZoo zoo;
    private final UIController uiController;
    private final EnclosureController enclosureController;
    private final AnimalController animalController;

    public GameEngine() {

            ArrayList<Enclosure> enclosures = new ArrayList<>();

            scanner = new Scanner(System.in);

            defaultChoice.addAll(
                    List.of("Examiner un enclos",
                            "Nettoyer un enclos",
                            "Nourrir les créatures",
                            "Transférer une créature",
                            "Construire un enclos",
                            "Acheter une créature",
                            "Surveiller le parc"));

            ZooMaster player = new ZooMaster();

            Enclosure enclosure = new Enclosure("Default enclosure", 100, new ArrayList<>());

            Dragons dragons = new Dragons(100,100, SexType.MALE, "Boris Execution");
            enclosure.addCreature(dragons);
            enclosures.add(enclosure);

            this.zoo = new FantasticZoo("Zootopie", player, 10, enclosures);

            this.uiController = new UIController(scanner);
            this.enclosureController = new EnclosureController(uiController);
            this.animalController = new AnimalController(uiController, zoo);

    }

    public void startGame() {
        executorService.scheduleAtFixedRate(animalController::decreaseHungerForAllAnimals, 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::randomlyTriggerAnimalBehaviors, 0, 5, TimeUnit.SECONDS);

        while (true) {
            if(!uiController.isInMenu()) monitorPark();
            System.out.println("while");
            uiController.setInMenu(true);
            int choice = uiController.selectFromList(defaultChoice, Function.identity(), "Choisissez une option : \n");
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

    private void processUserInput(int choice) {
        Enclosure selectedEnclosure;
        ArrayList<Enclosure> enclosures = zoo.getEnclosures();
        ZooMaster player = zoo.getZooMaster();

        switch(choice) {
            case 0:
                return;
            case 1:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                if(selectedEnclosure == null) return;
                player.examinateEnclosure(selectedEnclosure);
                for(Creature creature : selectedEnclosure.getAnimals()) {
                    uiController.renderAnimal(creature);
                    System.out.println(creature.getDescription());
                    uiController.waitForEnter();
                }
                break;
            case 2:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                if(selectedEnclosure == null) return;

                player.cleanEnclosure(selectedEnclosure);

                break;
            case 3:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                if(selectedEnclosure == null) return;

                player.feedCreaturesInEnclosure(selectedEnclosure);

                break;
            case 4:

                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                if(selectedEnclosure == null) return;

                Creature currentAnimal = animalController.chooseAnimal(enclosures.indexOf(selectedEnclosure), enclosures);

                Enclosure secondEnclosure;
                secondEnclosure = enclosureController.chooseEnclosure(enclosures.indexOf(selectedEnclosure), enclosures);

                player.moveAnimalFromEnclosure(currentAnimal, selectedEnclosure, secondEnclosure);
                break;
            case 5:
                System.out.println("Enter the name of the enclosure : ");
                String name = uiController.readString();

                int enclosureType = uiController.selectFromList(
                        List.of("Basic Enclosure", "Aquatic Enclosure", "Aviary Enclosure"),
                        Function.identity(),
                        "Choose an enclosure type : \n");

                System.out.println("Enter the area of the enclosure : ");
                int area = uiController.readInt(10000);

                switch (enclosureType) {
                    case 2 :
                        enclosures.add(new Aquarium(name, area, new ArrayList<>()));
                        break;
                    case 3 :
                        enclosures.add(new Aviary(name, area, new ArrayList<>()));
                        break;
                    default:
                        enclosures.add(new Enclosure(name, area, new ArrayList<>()));

                }
                break;
            case 6:
                System.out.println("Select the type of the creature : ");
                int creatureType = uiController.selectFromList(
                        List.of("Dragon", "Kraken", "Megalodons", "Mermaids", "Nymphs", "Phoenix", "Unicorn", "Werewolf \uFE0F"),
                        Function.identity(),
                        "Choose a creature type : \n");
                if(creatureType == 0) return;

                Creature creature;
                switch (creatureType) {
                    case 1 :
                        creature = new Dragons();
                        break;
                    case 2 :
                        creature = new Kraken();
                        break;
                    case 3 :
                        creature = new Megalodons();
                        break;
                    case 4 :
                        creature = new Mermaids();
                        break;
                    case 5 :
                        creature = new Nymphs();
                        break;
                    case 6 :
                        creature = new Phoenix();
                        break;
                    case 7 :
                        creature = new Unicorn();
                        break;
                    case 8 :
                        creature = new Werewolf();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + creatureType);
                }


                for(Enclosure enclosure : enclosures) {
                    if(enclosure.addCreature(creature)) {
                        break;
                    }

                }

                System.out.println("Enter the name of the creature : ");
                String creatureName = uiController.readString();
                creature.setName(creatureName);

                int sexType = uiController.selectFromList(List.of(SexType.MALE.name(), SexType.FEMALE.name()), Function.identity(), "Select the sex of the creature");
                creature.setSex(sexType == 0 ? SexType.MALE : SexType.FEMALE) ;

                System.out.println("Enter the weight of the creature : ");
                Random random = new Random();
                int weight = random.nextInt(1000)+50;
                creature.setWeight(weight);

                break;
            case 7 :
                monitorPark();
                break;
            default:
                System.out.println("Invalid option");
        }
        uiController.clearConsole();

    }

    private void monitorPark() {
        uiController.setInMenu(false);
        AtomicBoolean exitMonitoring = new AtomicBoolean(false);

        System.out.println("Monitoring the park. Press 'Enter' to go to the main menu for 50 seconds...");
        if(scanner.hasNextLine())  scanner.nextLine();

        Thread inputThread = new Thread(() -> {
            exitMonitoring.set(true);
        });

        inputThread.start();

        Thread monitoringThread = getThread(exitMonitoring);

        try {
            monitoringThread.join();
            inputThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executorService.schedule(this::monitorPark, 50, TimeUnit.SECONDS);
    }
    private Thread getThread(AtomicBoolean exitMonitoring) {
        Thread monitoringThread = new Thread(() -> {
            while (!exitMonitoring.get()) {

                uiController.showMissedMessages((ArrayList<String>) missedMessages);
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        monitoringThread.start();
        return monitoringThread;
    }

}