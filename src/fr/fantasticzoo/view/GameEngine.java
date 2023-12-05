package fr.fantasticzoo.view;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Phenix;
import fr.fantasticzoo.model.animals.types.Werewolf;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class GameEngine {

    private Creature currentAnimal;
    private final AsciiArtView asciiArtView;
    private final ZooMaster player;
    private final Scanner scanner;
    private ArrayList<Enclosure> enclosures;

    public GameEngine() {
        currentAnimal = new Werewolf();
        asciiArtView = new AsciiArtView();
        scanner = new Scanner(System.in);
        player = new ZooMaster();
        enclosures = new ArrayList<>();
        Enclosure enclosure = new Enclosure("Enclos 1");
        Dragons dragons = new Dragons(100,100, SexType.MALE, "Boris");
        Phenix phenix = new Phenix(100,100, SexType.MALE, "Mark");

        ArrayList<Creature> creatures = new ArrayList<Creature>();
        creatures.add(dragons);
        creatures.add(phenix);
        enclosure.setAnimals(creatures);

        enclosures.add(enclosure);


    }

    public void startGame() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            processUserInput(choice);

        }
    }

    private void displayMenu() {
        System.out.println("1. Examiner un enclos");
        System.out.println("2. Nettoyer un enclos");
        System.out.println("3. Nourrir les créatures");
        System.out.println("4. Transférer une créature");
        System.out.println("5. Construire un enclos");
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
                System.out.println("Enter the maximum number of animals in the enclosure : ");
                int maxAnimal = scanner.nextInt();
                System.out.println("Enter the cleanness of the enclosure : ");
                int cleanness = scanner.nextInt();

                enclosures.add(new Enclosure(name, area, maxAnimal, cleanness, new ArrayList<>()));
                scanner.nextLine();
                break;

            default:
                System.out.println("Invalid option");
        }
        waitForEnter();
        clearConsole();

    }

    private void waitForEnter() {
        System.out.println("OK ?");
        scanner.nextLine();
        scanner.nextLine();
    }


    private void clearConsole() {
        for(int i = 0 ; i < 50 ; i++) System.out.println(" ");
    }

}