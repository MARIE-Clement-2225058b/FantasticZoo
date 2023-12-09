package fr.fantasticzoo.model.enclosure;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Mermaids;
import fr.fantasticzoo.model.animals.types.Nymphs;
import fr.fantasticzoo.model.animals.types.Werewolf;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnclosureTest {
    static Mermaids ariel = new Mermaids();
    static Werewolf werewolf = new Werewolf();
    @BeforeAll
    static void setUp() {
        System.out.println("Test de la classe Enclosure:");
        ariel.setName("Ariel");
        werewolf.setName("Jeff");
        Enclosure enclosure = new Enclosure("Enclos 1");
        assertEquals(0, enclosure.getAnimalCount());
    }

    @Test
    void clean() {
        Enclosure enclosure = new Enclosure("Enclos 1");
        enclosure.setCleanness(0);
        enclosure.clean();
        assertEquals(100, enclosure.getCleanness());
    }

    @Test
    void feedAllCreatures() {
        ariel.setHunger(0);

        Aquarium aquarium = new Aquarium("Aquarium 1");

        Mermaids ariel2 = new Mermaids();
        ariel2.setHunger(0);

        aquarium.addCreature(ariel);
        aquarium.addCreature(ariel2);

        aquarium.feedAllCreatures();

        assertEquals(2, aquarium.getAnimalCount());
        for (Creature animal : aquarium.getAnimals()) {
            assertEquals(100, animal.getHunger());
        }
    }

    @Test
    void transfertCreature() {
        Enclosure enclosure = new Enclosure("Enclos 1");

        // On ajoute dans le premier enclos
        enclosure.addCreature(werewolf);

        // On crée un deuxième enclos
        Enclosure enclosure2 = new Enclosure("Enclos 2");

        // On transfère le loup-garou dans le deuxième enclos
        enclosure.transfertCreature(enclosure2, werewolf);

        // Vérifier que le premier enclos a été vidé
        assertEquals(0, enclosure.getAnimalCount());

        // Vérifier que le deuxième enclos a été rempli
        assertEquals(1, enclosure2.getAnimalCount());
    }

    @Test
    void addMermaidToNon_AquariumEnclosure() {
        Enclosure enclosure = new Enclosure("Enclos 1");

        enclosure.addCreature(ariel);
        assertEquals(0, enclosure.getAnimalCount());
    }

    @Test
    void addMermaidToAquariumEnclosure() {
        Aquarium aquarium = new Aquarium("Aquarium 1");
        aquarium.addCreature(ariel);
        assertEquals(1, aquarium.getAnimalCount());
}

    @Test
    void addAnimalToWrongEnclosure(){
        Aquarium aquarium = new Aquarium("Aquarium 1");
        Aviary aviary = new Aviary("Aviary 1");

        aquarium.addCreature(werewolf);
        assertEquals(0, aquarium.getAnimalCount());

        aviary.addCreature(werewolf);
        assertEquals(0, aviary.getAnimalCount());
    }

    @Test
    void addWrongCreatureToEnclosure() {
        Enclosure enclosure = new Enclosure("Enclos 1");

        // on met un loup-garou dans un enclos qui ne peut désormais qu'accueillir QUE des loup-garous
        enclosure.addCreature(werewolf);
        assertEquals(Werewolf.class, enclosure.getCreatureType().getClass());

        // on crée une nymphe qu'on va essayer d'ajouter à l'enclos des loup-garous
        Nymphs navi = new Nymphs(100, 100, SexType.MALE, "Navi");

        // Allez c'est parti on l'ajoute hop hop hop
        enclosure.addCreature(navi);

        // Normalement ça marche pas
        assertEquals(1, enclosure.getAnimalCount());

        // On crée un deuxième enclos
        Enclosure enclosure2 = new Enclosure("Enclos 2");

        // On transfère le loup-garou dans le deuxième enclos et on vérifie que le premier est vide
        enclosure.transfertCreature(enclosure2, werewolf);
        assertEquals(0, enclosure.getAnimalCount());
        //assertTrue(enclosure.getAnimals().isEmpty());

        // Maintenant que le premier enclos est vide on peut normalement ajouter la nymphe
        enclosure.addCreature(navi);

        // Et elle est toute seule dans un enclos qui ne peut accueillir QUE des nymphes
        assertEquals(Nymphs.class, enclosure.getCreatureType().getClass());
        assertEquals(1, enclosure.getAnimalCount());
    }

    @Test
    void animalsGetSickIfEnclosureIsDirty() {
        Enclosure enclosure = new Enclosure("Enclos 1");
        assertEquals(100, enclosure.getCleanness());
        enclosure.addCreature(werewolf);
        enclosure.setCleanness(0);
        assertEquals(1, werewolf.getSick());
    }


}