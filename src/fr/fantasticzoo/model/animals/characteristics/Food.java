package fr.fantasticzoo.model.animals.characteristics;

public enum Food {

    APPLE("Apple", 10),
    BANANA("Banana", 5),
    HUMAN("Human",30),
    SHEEP("Sheep",25),
    MEAT("Piece of meat", 20),
    MYSTERIOUS("Mysterious food", 50000),
    WATERMELON("Watermelon", 15);


    private final String foodName;
    private final int foodStats;

    Food(String foodName, int foodStats) {
        this.foodName = foodName;
        this.foodStats = foodStats;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodStats() {
        return this.foodStats;
    }
}
