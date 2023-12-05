package fr.fantasticzoo.view;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.types.Dragons;
import fr.fantasticzoo.model.animals.types.Mermaids;
import fr.fantasticzoo.model.animals.types.Werewolf;

public class AsciiArtView {

    public void renderAnimal(Creature creature) {
        String asciiArt = getAsciiArtForAnimal(creature);
        System.out.println(asciiArt);
    }

    private String getAsciiArtForAnimal(Creature creature) {
        if (creature instanceof Werewolf) {
            return getAsciiWerewolf();
        }
        if (creature instanceof Mermaids) {
            return getAsciiMermaid();
        }
        if (creature instanceof Dragons) {
            return getAsciiDragon();
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

    public String getAsciiDragon() {
        return "        \\****__              ____                                              \n" +
                "         |    *****\\_      --/ *\\-__                                          \n" +
                "         /_          (_    ./ ,/----'                                         \n" +
                "               \\__         (_./  /                                             \n" +
                "                  \\__           \\___----^__                                    \n" +
                "               _/   _                  \\                                       \n" +
                "        |    _/  __/ )\"\\ _____         *\\                                     \n" +
                "        |\\__/   /    ^ ^       \\____      )                                    \n" +
                "         \\___--\"                    \\_____ )                                   ";
    }

    public String getAsciiMermaid(){
        return "      .---.\n" +
                "     / /\"\\ \\\n" +
                "     )/a a\\(\n" +
                "    ( ( - ) )\n" +
                "     ) ) (  (\n" +
                "    (__)  \\  )\n" +
                "   /,(@)~(@\\__)\n" +
                "   \\\\ \\   / //\n" +
                "    \\\\/\\'/\\//\n" +
                "    (/^.^.^\\)\n" +
                "     |^.^.^|\n" +
                "     |^.^.^|\n" +
                "     \\\\.^.^./\n" +
                "      \\\\.^./\n" +
                "       )^(\n" +
                "      /^.^\\\n" +
                "     /.^,^.\\\n" +
                "   ,/-,-|-,-\\,\n" +
                "   ^~^~^`^~^~^";
    }


    private String getAsciiDog() {
        return " /\\_/\\\n" +
                "( ^.^ )\n" +
                " > ^ <";
    }


}
