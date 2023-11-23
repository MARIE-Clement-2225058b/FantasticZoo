package fr.fantasticzoo.model;

public class Egg {
    public int gestationPeriod;
    public int hatchDate;
    public String name;
    private Oviparous mother;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHatchDate() {
        return hatchDate;
    }

    public void setHatchDate(int hatchDate) {

        this.hatchDate = hatchDate;
    }

    public Oviparous getMother() {
        return mother;
    }

    public Egg(int daysRemaining, Oviparous mother) {
        this.gestationPeriod = 0;
        this.name = "Egg";
        this.hatchDate = daysRemaining;
        this.mother = mother;
    }

    public Creature hatch(){
        System.out.println(this.name + " is hatching!!!");

        try {
            Creature newChild = (Creature) this.mother.getType().getDeclaredConstructor().newInstance();
            System.out.println(this.name + " has hatched!");
            return newChild;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
