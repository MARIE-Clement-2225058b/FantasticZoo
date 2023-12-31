package fr.fantasticzoo.view;

import fr.fantasticzoo.controller.AnimalController;
import fr.fantasticzoo.controller.EnclosureController;
import fr.fantasticzoo.controller.UIController;
import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.Egg;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/**
 * This class is the main class of the game.
 * It contains the main method and the game loop.
 * It also contains the main menu and the monitoring of the park.
 */
public class GameEngine {

    private final Scanner scanner;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
    private final ArrayList<String> defaultChoice = new ArrayList<>();
    public static final CopyOnWriteArrayList<String> missedMessages = new CopyOnWriteArrayList<>();
    private final FantasticZoo zoo;
    private final UIController uiController;
    private final EnclosureController enclosureController;
    private final AnimalController animalController;

    /**
     * This is the main method of the game.
     * It creates a new instance of GameEngine and calls the startGame method.
     * It initializes the zoo and the player, creates a default enclosure and adds two dragons to it.
     */
    public GameEngine() {

            ArrayList<Enclosure> enclosures = new ArrayList<>();

            scanner = new Scanner(System.in);

            defaultChoice.addAll(
                    List.of("Examine an enclosure",
                            "Clean an enclosure",
                            "Feed the creatures",
                            "Transfer a creature",
                            "Build an enclosure",
                            "Buy a creature",
                            "Monitor the park",
                            "Watch the incubator"));


            ZooMaster player = new ZooMaster();

            Enclosure enclosure = new Enclosure("Default enclosure", 100, new CopyOnWriteArrayList<>());

            Dragons dragons = new Dragons(100,100, SexType.MALE, "Dragon");
            dragons.setAge(50);
            enclosure.addCreature(dragons);
            enclosures.add(enclosure);

            Dragons dragonette = new Dragons(100,100, SexType.FEMALE, "Dragonette");
            dragonette.setAge(50);
            enclosure.addCreature(dragonette);

            this.zoo = new FantasticZoo("Zootopie", player, 10, enclosures);

            this.uiController = new UIController(scanner);
            this.enclosureController = new EnclosureController(uiController);
            this.animalController = new AnimalController(uiController, zoo);

    }

    /**
     * This method starts the game loop.
     * It schedules the different tasks of the game (thread pool).
     * It also calls the main menu.
     */
    public void startGame() {
        executorService.scheduleAtFixedRate(animalController::decreaseHungerForAllAnimals, 0, 15, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::randomlyTriggerAnimalBehaviors, 0, 25, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::pregnancyHandler, 0, 30, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::hatchHandler, 0, 10, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::findPartner, 0, 1, TimeUnit.MINUTES);
        executorService.scheduleAtFixedRate(animalController::becomeSick, 0, 30, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> enclosureController.dirtyEnclosure(zoo.getEnclosures()), 0, 30, TimeUnit.SECONDS);


        while (true) {
            if(!uiController.isInMenu()) monitorPark();
            uiController.setInMenu(true);
            int choice = uiController.selectFromList(defaultChoice, Function.identity(), "Select an option : \n");
            processUserInput(choice);
        }
    }

    /**
     * This method displays the main menu and calls the corresponding method according to the user's choice.
     * @param choice is the user's choice.
     */
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
                        enclosures.add(new Aquarium(name, area, new CopyOnWriteArrayList<>()));
                        break;
                    case 3 :
                        enclosures.add(new Aviary(name, area, new CopyOnWriteArrayList<>()));
                        break;
                    default:
                        enclosures.add(new Enclosure(name, area, new CopyOnWriteArrayList<>()));

                }
                break;
            case 6:
                System.out.println("Select the type of the creature : ");
                int creatureType = uiController.selectFromList(
                        List.of("Dragon", "Kraken", "Megalodons", "Mermaids", "Nymphs", "Phoenix", "Unicorn", "Werewolf"),
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

                Enclosure suitableEnclosure = null;
                for(Enclosure enclosure : enclosures) {
                    if(enclosure.addCreature(creature)) {
                        suitableEnclosure = enclosure;
                        break;
                    }
                }
                if(suitableEnclosure == null) {
                    System.out.println("No suitable enclosure found for this creature.");
                    return;
                }

                System.out.println("Enter the name of the creature : ");
                String creatureName = uiController.readString();
                creature.setName(creatureName);

                int sexType = uiController.selectFromList(List.of(SexType.MALE.name(), SexType.FEMALE.name()), Function.identity(), "Select the sex of the creature");
                creature.setSex(sexType == 1 ? SexType.MALE : SexType.FEMALE) ;

                Random random = new Random();
                int weight = random.nextInt(1000)+50;
                creature.setWeight(weight);

                System.out.println("Enter the age of the creature : ");
                int age = uiController.readInt(99);
                creature.setAge(age);

                break;
            case 7 :
                monitorPark();
                break;
            case 8 :
                for(Egg egg : zoo.getIncubator().getEggs()) {
                    uiController.renderEgg();
                    System.out.println(egg.getDescription());
                    uiController.waitForEnter();
                }
                break;
            default:
                System.out.println("Invalid option");
        }
        uiController.clearConsole();

    }

    /**
     * This method monitors the park.
     * It displays the missed messages every 2 seconds.
     * It also displays the main menu for 50 seconds.
     */
    private void monitorPark() {
        uiController.setInMenu(false);
        AtomicBoolean exitMonitoring = new AtomicBoolean(false);

        System.out.println("Monitoring the park. Press 'Enter' to go to the main menu for 50 seconds...");

        Thread inputThread = new Thread(() -> {
            synchronized(scanner) {
                if(scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
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

    /**
     * This method creates a thread that displays the missed messages every 2 seconds.
     * @param exitMonitoring is an AtomicBoolean that is set to true when the user presses 'Enter'.
     * @return the thread that displays the missed messages.
     */
    private Thread getThread(AtomicBoolean exitMonitoring) {
        Thread monitoringThread = new Thread(() -> {
            while (!exitMonitoring.get()) {

                uiController.showMissedMessages(missedMessages);
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