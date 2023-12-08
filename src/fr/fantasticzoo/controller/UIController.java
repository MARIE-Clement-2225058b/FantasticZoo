package fr.fantasticzoo.controller;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.view.AsciiArtView;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class UIController {

    private final Scanner scanner;
    private boolean isInMenu = false;
    private final AsciiArtView asciiArtView;

    /**
     *
     * @return
     */
    public boolean isInMenu() {
        return isInMenu;
    }

    /**
     *
     * @param inMenu
     */
    public void setInMenu(boolean inMenu) {
        isInMenu = inMenu;
    }

    /**
     *
     * @param scanner
     */
    public UIController(Scanner scanner) {
        this.scanner = scanner;
        this.asciiArtView = new AsciiArtView();
    }

    /**
     *
     * @param creature
     */
    public void renderAnimal(Creature creature) {
        asciiArtView.renderAnimal(creature);
    }

    /**
     *
     * call the function for render the egg
     */
    public void renderEgg() {
        asciiArtView.renderEgg();
    }

    /**
     *
     * @param items, displayFunction, prompt
     */
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

    /**
     *
     * @return string read
     */
    public String readString() {
        try {
            if (!isInMenu) {
                throw new InterruptedException("Not in choice menu.");
            }
            synchronized(scanner) {
                return scanner.nextLine();
            }
        } catch (InterruptedException e) {
            return "";
        }
    }

    /**
     *
     * @param max
     * @return int read
     */
    public int readInt(int max) {
        int choice;
        while (true) {
            try {
                synchronized(scanner) {
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
                }
            } catch (NumberFormatException e) {
                if(!isInMenu) return 0;
                System.out.println("Please enter a valid number.");
            } catch (InterruptedException e) {
                return 0;
            }

        }
    }

    /**
     * scan the next line
     */
    public void waitForEnter() {
        System.out.println("OK ?");
        synchronized (scanner) {
            scanner.nextLine();
        }
    }

    /**
     * clear the console
     */
    public void clearConsole() {
        for(int i = 0 ; i < 50 ; i++) System.out.println(" ");
    }

    /**
     *
     * @param missedMessages
     */
    public void showMissedMessages(CopyOnWriteArrayList<String> missedMessages) {
        if (!missedMessages.isEmpty()) {
            for (String message : missedMessages) {
                System.out.println(message);
            }
            missedMessages.clear();
        }
    }


}
