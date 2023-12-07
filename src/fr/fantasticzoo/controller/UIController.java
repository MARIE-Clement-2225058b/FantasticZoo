package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.view.AsciiArtView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class UIController {

    private final Scanner scanner;
    private boolean isInMenu = false;
    private final AsciiArtView asciiArtView;

    public boolean isInMenu() {
        return isInMenu;
    }

    public void setInMenu(boolean inMenu) {
        isInMenu = inMenu;
    }

    public UIController(Scanner scanner) {
        this.scanner = scanner;
        this.asciiArtView = new AsciiArtView();
    }

    public void renderAnimal(Creature creature) {
        asciiArtView.renderAnimal(creature);
    }

    public <T> int selectFromList(List<T> items, Function<T, String> displayFunction, String prompt) {
        try{
            if (!isInMenu) {
                throw new InterruptedException("Not in choice menu.");
            }
            System.out.println(prompt);
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + displayFunction.apply(items.get(i)));
            }

            return readInt(items.size());
        } catch (InterruptedException e) {
            return 0;
        }

    }

    public String readString() {
        try {
            if (!isInMenu) {
                throw new InterruptedException("Not in choice menu.");
            }
            return scanner.nextLine();
        } catch (InterruptedException e) {
            return "";
        }
    }

    public int readInt(int max) {
        int choice;
        while (true) {
            try {
                System.out.println("Is in menu " + isInMenu);

                if (!isInMenu) {
                    throw new InterruptedException("Not in choice menu.");
                }
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    throw new InterruptedException("Trigger stopped by user.");
                }
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + 1 + " and " + max + ".");
            } catch (NumberFormatException e) {
                if(!isInMenu) return 0;
                System.out.println("Please enter a valid number.");
            } catch (InterruptedException e) {
                return 0;
            }

        }
    }


    public void waitForEnter() {
        System.out.println("OK ?");
        scanner.nextLine();
    }

    public void clearConsole() {
        for(int i = 0 ; i < 50 ; i++) System.out.println(" ");
    }

    public void showMissedMessages(ArrayList<String> missedMessages) {
        if (!missedMessages.isEmpty()) {
            for (String message : missedMessages) {
                System.out.println(message);
            }
            missedMessages.clear();
        }
    }


}
