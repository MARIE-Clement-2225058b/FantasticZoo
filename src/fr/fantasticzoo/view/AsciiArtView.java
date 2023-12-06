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

    public String getAsciiUnicorn(){
        return "              ,,))))))));,\n" +
                "           __)))))))))))))),\n" +
                "\\|/       -\\(((((''''((((((((.\n" +
                "-*-==//////((''  .     `)))))),\n" +
                "/|\\      ))| o    ;-.    '(((((                                  ,(,\n" +
                "         ( `|    /  )    ;))))'                               ,_))^;(~\n" +
                "            |   |   |   ,))((((_     _____------~~~-.        %,;(;(>';'~\n" +
                "            o_);   ;    )))(((` ~---~  `::           \\      %%~~)(v;(`('~\n" +
                "                  ;    ''''````         `:       `:::|\\,__,%%    );`'; ~\n" +
                "                 |   _                )     /      `:|`----'     `-'\n" +
                "           ______/\\/~    |                 /        /\n" +
                "         /~;;.____/;;'  /          ___--,-(   `;;;/\n" +
                "        / //  _;______;'------~~~~~    /;;/\\    /\n" +
                "       //  | |                        / ;   \\;;,\\\n" +
                "      (<_  | ;                      /',/-----'  _>\n" +
                "       \\_| ||_                     //~;~~~~~~~~~\n" +
                "           `\\_|                   (,~~  -Tua Xiong\n" +
                "                                   \\~\\\n" +
                "                                    ~~";
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

    private String getAsciiZooMaster() {
        return "    .------\\ /------.\n" +
                "   |       -       |\n" +
                "   |               |\n" +
                "   |               |\n" +
                "   |               |\n" +
                "_______________________\n" +
                "===========.===========\n" +
                "  / ~~~~~     ~~~~~ \\\n" +
                " /|     |     |\\\n" +
                " W   ---  / \\  ---   W\n" +
                " \\.      |o o|      ./\n" +
                "  |                 |\n" +
                "  \\    #########    /\n" +
                "   \\  ## ----- ##  /\n" +
                "    \\##         ##/\n" +
                "     \\_____v_____/";

    }

    private String getPhoenixAscii(){
        return "                (                           )\n" +
                "          ) )( (                           ( ) )( (\n" +
                "       ( ( ( )  ) )                     ( (   (  ) )(\n" +
                "      ) )     ,,\\\\\\                     ///,,       ) (\n" +
                "   (  ((    (\\\\\\\\//                     \\\\////)      )\n" +
                "    ) )    (-(__//                       \\\\__)-)     (\n" +
                "   (((   ((-(__||                         ||__)-))    ) )\n" +
                "  ) )   ((-(-(_||           ```\\__        ||_)-)-))   ((\n" +
                "  ((   ((-(-(/(/\\\\        ''; 9.- `      //\\)\\)-)-))    )\n" +
                "   )   (-(-(/(/(/\\\\      '';;;;-\\~      //\\)\\)\\)-)-)   (   )\n" +
                "(  (   ((-(-(/(/(/\\======,:;:;:;:,======/\\)\\)\\)-)-))   )\n" +
                "    )  '(((-(/(/(/(//////:%%%%%%%:\\\\\\\\\\\\)\\)\\)\\)-)))`  ( (\n" +
                "   ((   '((-(/(/(/('uuuu:WWWWWWWWW:uuuu`)\\)\\)\\)-))`    )\n" +
                "     ))  '((-(/(/(/('|||:wwwwwwwww:|||')\\)\\)\\)-))`    ((\n" +
                "  (   ((   '((((/(/('uuu:WWWWWWWWW:uuu`)\\)\\))))`     ))\n" +
                "        ))   '':::UUUUUU:wwwwwwwww:UUUUUU:::``     ((   )\n" +
                "          ((      '''''''\\uuuuuuuu/``````         ))\n" +
                "           ))            `JJJJJJJJJ`           ((\n" +
                "             ((            LLLLLLLLLLL         ))\n" +
                "               ))         ///|||||||\\\\\\       ((\n" +
                "                 ))      (/(/(/(^)\\)\\)\\)       ((\n" +
                "                  ((                           ))\n" +
                "                    ((                       ((\n" +
                "                      ( )( ))( ( ( ) )( ) (()";
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
