package fr.fantasticzoo.model;

public abstract class Creature {
    public String name;
    public String
            sex;
    public int weight;
    public int height;
    public int age;
    public int hunger;
    public boolean isAsleep;
    public int health;

    public void eat(Food food) {
        hunger = hunger + food.getFoodStats();
        System.out.println(this.name +" ate a " + food.getFoodName());
        System.out.println("Hunger level: " + hunger);
    }

    public void cry() {

    }


    public void heal() {
    }


    public void fallAsleep() {
    }


    public void aging() {
    }

}

