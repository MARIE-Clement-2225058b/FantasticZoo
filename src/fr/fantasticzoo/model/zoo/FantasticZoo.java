package fr.fantasticzoo.model.zoo;

import fr.fantasticzoo.model.employee.ZooMaster;
import fr.fantasticzoo.model.enclosure.Enclosure;

import java.util.ArrayList;
import java.util.Collection;

public class FantasticZoo {
    private ArrayList<Enclosure> enclosures;

    private String name;
    private ZooMaster zooMaster;
    private int MaxEnclosure;

    public FantasticZoo(String name, ZooMaster zooMaster, int MaxEnclosure) {
        this.enclosures = new ArrayList<>();
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

    public ArrayList<Enclosure> getEnclosures() {
        return enclosures;
    }

    public ZooMaster getZooMaster() {
        return zooMaster;
    }

    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }
}
