package fr.fantasticzoo.model.animals.characteristics;

import fr.fantasticzoo.model.animals.types.Werewolf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Pack extends Werewolf{

    private final String name;
    private final int min;
    private final int max;
    private final List<Werewolf> wolves;

    public Pack(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.wolves = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public List<Werewolf> getWolves() {
        return wolves;
    }

    public void addWolf(Werewolf wolf) {
        if (wolves.size() < max) {
            wolves.add(wolf);
        } else {
            System.out.println("Pack is already at maximum capacity.");
        }
    }

    public void removeWolf(Werewolf wolf) {
        if (wolves.size() > min) {
            wolves.remove(wolf);
        } else {
            System.out.println("Pack is already at minimum capacity.");
        }
    }

    public void whatRank(){
        wolves.sort(Comparator.comparing(Werewolf::getStrength).reversed());
        IntStream.range(0, wolves.size()).forEach(i -> wolves.get(i).setRank(i));
    }

    @Override
    public String toString() {
        return name;
    }
}