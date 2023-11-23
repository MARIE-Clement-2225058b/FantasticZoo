package fr.fantasticzoo;

import fr.fantasticzoo.model.animals.Unicorn;
import fr.fantasticzoo.model.animals.Werewolf;
import fr.fantasticzoo.view.GameEngine;

import static fr.fantasticzoo.model.SexType.MALE;
import static fr.fantasticzoo.model.SexType.FEMALE;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Zootopie ! \n");

        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
        Werewolf jeff = new Werewolf(100,100, "ted", MALE);
        jeff.cry();
        jeff.setPregnancyState(1);
        jeff.setPregnancyState(9);
        jeff.deliver();

    }
}
