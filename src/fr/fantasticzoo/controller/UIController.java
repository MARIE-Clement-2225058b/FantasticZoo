package fr.fantasticzoo.controller;

import fr.fantasticzoo.view.AsciiArtView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class UIController {

    private final Scanner scanner;

    public UIController(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> int selectFromList(List<T> items, Function<T, String> displayFunction, String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + displayFunction.apply(items.get(i)));
        }
        return readInt(items.size());
    }

    public int readInt(int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + 1 + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
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
