package fr.fantasticzoo;

import fr.fantasticzoo.view.GameEngine;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Zootopie ! \n");

        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
    }
}
