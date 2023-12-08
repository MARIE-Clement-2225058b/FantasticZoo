package fr.fantasticzoo.model.zoo;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Enclosure;
import fr.fantasticzoo.model.enclosure.Incubator;

import java.util.ArrayList;
import java.util.Collection;

public class FantasticZoo {
    public static ArrayList<Enclosure> enclosures;
    private Incubator incubator;
    private String name;
    private ZooMaster zooMaster;
    private int MaxEnclosure;

    // Il doit permettre :
    //− d’afficher le nombre de créatures présentes dans le zoo fantastique ;
    //− d’afficher les créatures de tous les enclos.

    //Il doit en plus avoir la méthode principale de l’application (point d’entrée de la simulation) qui est
    //chargée de modéliser l’aspect temporel de la gestion du zoo fantastique. À intervalle régulier, cette
    //méthode doit :
    //− modifier aléatoirement l’état de certaines créatures (les rendre malades, les endormir, etc.) ;
    //− modifier aléatoirement l’état de certains enclos (leur propreté, leur salinité, etc.) ;
    //− passer la main au maître de zoo fantastique (et donc à l’utilisateur) pour qu'il s'occupe du
    //zoo fantastique (son nombre d’action par intervalle de temps devant être limité).

    public FantasticZoo(String name, ZooMaster zooMaster, int MaxEnclosure, ArrayList<Enclosure> enclosures) {
        this.enclosures = enclosures;
        this.zooMaster = zooMaster;
        this.MaxEnclosure = MaxEnclosure;
        this.name = name;
    }

    public void addEnclosure(Enclosure enclosure) {
        if (enclosures.size() < MaxEnclosure) {
            enclosures.add(enclosure);
        } else {
            System.out.println("MAX ENCLOSURE NUMBER REACHED: You can't add any more enclosures. Remove one before adding a new one.");
        }
    }

    public void removeEnclosure(Enclosure enclosure) {
        enclosures.remove(enclosure);
    }

    public int getMaxEnclosure() {
        return MaxEnclosure;
    }

    public int getCreatedEnclosuresNumber() {
        return enclosures.size();
    }

    public int getCreatedAnimalsNumber() {
        int animalsNumber = 0;
        for (Enclosure enclosure : enclosures) {
            animalsNumber += enclosure.getAnimalCount();
        }
        return animalsNumber;
    }

    public void displayAnimals() {
        for (Enclosure enclosure : enclosures) {
            System.out.println(enclosure.getName() + " :");
            for (int i = 0; i < enclosure.getAnimalCount(); i++) {
                System.out.println(enclosure.getAnimals().get(i).getName()
                        + " the " + enclosure.getAnimals().get(i).getClass().getSimpleName());
            }
        }
    }

    public static Enclosure getCreaturesEnclosure(Creature creature) {
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getAnimals().contains(creature)) {
                return enclosure;
            }
        }
        return null;
    }

    public ArrayList<Enclosure> getEnclosures() {
        return enclosures;
    }

    public ZooMaster getZooMaster() {
        return zooMaster;
    }

    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }

    public Incubator getIncubator() {
        return incubator;
    }

    public void setIncubator(Incubator incubator) {
        this.incubator = incubator;
    }
}
