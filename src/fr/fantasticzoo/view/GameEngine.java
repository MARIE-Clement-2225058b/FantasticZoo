package fr.fantasticzoo.view;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.SexType;
import fr.fantasticzoo.model.animals.Werewolf;

import java.io.IOException;

public class GameEngine {

    private Creature currentAnimal;
    private AsciiArtView asciiArtView;

    public GameEngine() {
        currentAnimal = new Werewolf(100,100, "ted", SexType.MALE);
        asciiArtView = new AsciiArtView();
    }

    public void startGame() {
        while (true) {
            clearConsole(); // Efface la console
            asciiArtView.renderAnimal(currentAnimal);

            try {
                Thread.sleep(1000); // Pause de 1 seconde
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Game interrupted");
                break;
            }
        }
    }

    private void clearConsole() {
        for(int i = 0 ; i < 50 ; i++) System.out.println(" ");
    }

}
