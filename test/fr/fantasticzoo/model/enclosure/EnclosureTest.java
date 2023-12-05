package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.types.Mermaids;
import fr.fantasticzoo.model.animals.types.Werewolf;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnclosureTest {
    Enclosure enclosure = new Enclosure("Enclos 1");

    @Test
    void clean() {
        enclosure.setCleanness(0);
        enclosure.clean();
        assertEquals(100, enclosure.getCleanness());
    }

    @Test
    void feedAllCreatures() {
        Mermaids mermaids = new Mermaids();
        mermaids.setHunger(0);

        Werewolf werewolf = new Werewolf();
        werewolf.setHunger(0);

        ArrayList<Creature> animals = new ArrayList<>();

        enclosure.setAnimals(animals);

        enclosure.feedAllCreatures();

        for (Creature animal : enclosure.getAnimals()) {
            assertEquals(100, animal.getHunger());
        }
    }

    @Test
    void transfertCreature() {
        Mermaids ariel = new Mermaids();

        // On ajoute Ariel dans le premier enclos
        ArrayList<Creature> animals = new ArrayList<>();
        animals.add(ariel);
        enclosure.setAnimals(animals);

        // On crée un deuxième enclos
        // Il faut fix ça : on devrait pas avoir à créer une liste vide pour instancier un enclos
        Enclosure enclosure2 = new Enclosure("Enclos 2");
        ArrayList<Creature> animals2 = new ArrayList<>();
        enclosure2.setAnimals(animals2);

        // On transfère Ariel dans le deuxième enclos
        enclosure.transfertCreature(enclosure2, ariel);

        // Vérifier que le premier enclos a été vidé
        assertEquals(0, enclosure.getAnimalCount());

        // Vérifier que le deuxième enclos a été rempli
        assertEquals(1, enclosure2.getAnimalCount());
    }
}