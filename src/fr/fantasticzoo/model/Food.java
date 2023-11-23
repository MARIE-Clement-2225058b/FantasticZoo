package fr.fantasticzoo.model;

public enum Food {

    APPLE("Apple", 10, "herbivorous"),
    BANANA("Banana", 5, "herbivorous"),
    HUMAN("Human",30, "carnivorous"),
    SHEEP("Sheep",25, "carnivorous");


    private final String foodName;
    private final int foodStats;
    private final String typeFood ;

    Food(String foodName, int foodStats, String typeFood) {
        this.foodName = foodName;
        this.foodStats = foodStats;
        this.typeFood = typeFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodStats() {
        return this.foodStats;
    }

    public String getTypeFood() {
        return this.typeFood;
    }
}
