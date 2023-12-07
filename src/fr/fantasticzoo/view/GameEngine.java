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
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class GameEngine {

    private final Scanner scanner;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private final ArrayList<String> defaultChoice = new ArrayList<>();
    private final List<String> missedMessages = new ArrayList<>();
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
                    "Surveiller le parc"));

            ZooMaster player = new ZooMaster();

            Enclosure enclosure = new Enclosure("Default enclosure", 100, new ArrayList<>());

            Dragons dragons = new Dragons(100,100, SexType.MALE, "Boris");
            enclosure.addCreature(dragons);
            enclosures.add(enclosure);

            this.zoo = new FantasticZoo("Zootopie", player, 10, enclosures);

            this.uiController = new UIController(scanner);
            this.enclosureController = new EnclosureController(uiController);
            this.animalController = new AnimalController(uiController, missedMessages, zoo.getEnclosures());

    }

    public void startGame() {
        executorService.scheduleAtFixedRate(animalController::decreaseHungerForAllAnimals, 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(animalController::randomlyTriggerAnimalBehaviors, 0, 5, TimeUnit.SECONDS);
        monitorPark();

        while (true) {
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
                monitorPark();
                break;
            default:
                System.out.println("Invalid option");
        }
        uiController.clearConsole();

    }

    private void monitorPark() {
        System.out.println("Monitoring the park. Press 'Enter' to go to the main menu for 50 seconds...");
        uiController.setInMenu(false);

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
        executorService.schedule(this::monitorPark, 50, TimeUnit.SECONDS);

    }

}