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

import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<String> defaultChoice = new ArrayList<>();
    private final List<String> missedMessages = new ArrayList<>();

    private final UIController uiController;
    private final EnclosureController enclosureController;
    private final AnimalController animalController;

    public GameEngine() {
        scanner = new Scanner(System.in);

        this.uiController = new UIController(scanner);
        this.enclosureController = new EnclosureController(uiController);
        this.animalController = new AnimalController(uiController, missedMessages, enclosures);


        defaultChoice.addAll(
                List.of("Examiner un enclos",
                "Nettoyer un enclos",
                "Nourrir les créatures",
                "Transférer une créature",
                "Construire un enclos",
                "Surveiller le parc"));

        currentAnimal = new Werewolf();
        asciiArtView = new AsciiArtView();
        player = new ZooMaster();
        enclosures = new ArrayList<>();
        Enclosure enclosure = new Enclosure("Enclos 1");
        Dragons dragons = new Dragons(100,100, SexType.MALE, "Boris");
        Phoenix phoenix = new Phoenix(100,100, SexType.MALE, "Mark");
        Megalodons megalodons = new Megalodons(100,100, SexType.MALE, "Zig et Sharko");

        Mermaids mermaids = new Mermaids(100,100, SexType.FEMALE, "Ariel la petite sirène");
        enclosure.addCreature(dragons);

        enclosures.add(enclosure);


    }

    public void startGame() {
        executorService.scheduleAtFixedRate(animalController::decreaseHungerForAllAnimals, 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::randomlyTriggerAnimalBehaviors, 0, 5, TimeUnit.SECONDS);

        while (true) {
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

        switch(choice) {
            case 1:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                player.examinateEnclosure(selectedEnclosure);
                for(Creature creature : selectedEnclosure.getAnimals()) {
                    asciiArtView.renderAnimal(creature);
                    System.out.println(creature.getDescription());
                    uiController.waitForEnter();
                }
                break;
            case 2:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                player.cleanEnclosure(selectedEnclosure);

                break;
            case 3:
                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);
                player.feedCreaturesInEnclosure(selectedEnclosure);

                break;
            case 4:

                selectedEnclosure = enclosureController.chooseEnclosure(enclosures);

                currentAnimal = animalController.chooseAnimal(enclosures.indexOf(selectedEnclosure), enclosures);

                Enclosure secondEnclosure;
                secondEnclosure = enclosureController.chooseEnclosure(enclosures.indexOf(selectedEnclosure), enclosures);

                player.moveAnimalFromEnclosure(currentAnimal, selectedEnclosure, secondEnclosure);
                break;
            case 5:
                System.out.println("Enter the name of the enclosure : ");
                String name = scanner.nextLine();

                int enclosureType = uiController.selectFromList(
                        List.of("Basic Enclosure", "Aquatic Enclosure", "Aviary Enclosure"),
                        Function.identity(),
                        "Choose an enclosure type : \n");
                System.out.println("Enter the area of the enclosure : ");
                int area = Integer.parseInt(scanner.nextLine());

                switch (enclosureType) {
                    case 2 :
                        enclosures.add(new Aquarium(name, area, 100, new ArrayList<>()));
                        break;
                    case 3 :
                        enclosures.add(new Aviary(name, area, 100, new ArrayList<>()));
                        break;
                    default:
                        enclosures.add(new Enclosure(name, area, 100, new ArrayList<>()));

                }
                break;
            case 6:
                monitorPark();
                break;
            default:
                System.out.println("Invalid option");
        }
        uiController.clearConsole();

    }







    private void monitorPark() {
        System.out.println("Monitoring the park. Press 'Enter' to return to the main menu...");

        AtomicBoolean exitMonitoring = new AtomicBoolean(false);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
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
        exitMonitoring.set(true);

        try {
            monitoringThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}

