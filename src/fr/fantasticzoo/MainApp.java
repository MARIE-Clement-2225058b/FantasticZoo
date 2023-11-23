package fr.fantasticzoo;

import fr.fantasticzoo.model.animals.Werewolf;
import fr.fantasticzoo.view.GameEngine;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Binvenue au Zootopie ! \n");

        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
        Werewolf jeff = new Werewolf(100,100);
        jeff.cry();
        jeff.setPregnancyState(1);
        jeff.setPregnancyState(9);
        jeff.deliver();
    }
}
