package fr.fantasticzoo.view;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.animals.Werewolf;

public class AsciiArtView {

    public void renderAnimal(Creature creature) {
        String asciiArt = getAsciiArtForAnimal(creature);
        System.out.println(asciiArt);
    }

    private String getAsciiArtForAnimal(Creature creature) {
        if (creature instanceof Werewolf) {
            return getAsciiWerewolf();
        }
        return "null";
    }

    private String getAsciiWerewolf() {
        return "⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢾⠱⢕⠠⢀⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠈⢆⢸⢣⠁⠛⡄⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢠⢏⠨⢪⢫⣷⡻⢆⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣰⣯⢖⠆⠁⠀⣸⡈⠉⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⡾⣇⡔⡳⠀⢠⢻⢳⣄⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣿⡇⣯⣶⢄⠀⢢⡻⣦⡀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠘⢿⠼⢸⣋⠀⠀⡍⠻⣿⣦⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠆⡇⢸⡠⣐⠥⡝⠶⠛⢿⠧\n" +
                "⠀⠀⠀⠀⢀⣠⣼⣧⣼⣷⣁⣒⣡⡴⠀⢸⡆\n" +
                "⠀⠀⠀⣪⠿⠗⠂⠀⠔⠊⠉⠉⠉⠉⢉⢢⠇\n" +
                "⠀⣠⠮⡷⠶⠿⠿⠭⠤⠤⣕⣲⣶⣶⠾⠋⠀\n" +
                "⠊⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    }

    private String getAsciiDog() {
        return " /\\_/\\\n" +
                "( ^.^ )\n" +
                " > ^ <";
    }


}
