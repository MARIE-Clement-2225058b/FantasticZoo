package fr.fantasticzoo.model;

public class Egg {
    public int gestationPeriod;
    public int hatchDate;
    public String name;

    public int getHatchDate() {
        return hatchDate;
    }

    public void setHatchDate(int hatchDate) {
        this.hatchDate = hatchDate;
    }

    public void setGestationPeriod(int gestationPeriod) {
        this.gestationPeriod = gestationPeriod;
        if (this.gestationPeriod == this.hatchDate){
            hatch();
        }
    }

    public int getGestationPeriod() {
        return gestationPeriod;
    }

    public Egg(int daysRemaining) {
        this.gestationPeriod = 0;
        this.hatchDate = hatchDate;
    }

    public void hatch(){
        System.out.println(this.name + " is hatching!!!");

        try {
            Class<?> clazz = super.getClass();
            Object NewEgg = clazz.getDeclaredConstructor().newInstance();
            System.out.println(this.name + "has hatched!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
