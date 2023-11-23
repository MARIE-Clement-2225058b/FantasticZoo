package fr.fantasticzoo;

import fr.fantasticzoo.model.animals.Werewolf;
import fr.fantasticzoo.view.GameEngine;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Binvenue au Zootopie ! \n");

        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
    }
}
