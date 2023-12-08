package fr.fantasticzoo.model.animals.characteristics;

public enum SicknessType {
    // Sickness enumeration for the animals
    // Each sickness has a name and a gravity that decreases the health faster or slower depending on the gravity
    // Display will be "AnimalName is sick of SicknessName"
    COLD("a cold", 1),
    FEVER("a fever", 2),
    PLAGUE("the plague", 5),
    HICCUP("hiccups", 1),
    FARTING("uncontrollable farts", 1);

    public final String sicknessName;
    public final int gravity;

    SicknessType(String sicknessName, int gravity) {
        this.sicknessName = sicknessName;
        this.gravity = gravity;
    }

    /**
     * @return a random sickness
     */
    public static SicknessType getRandomSickness() {
        return values()[(int) (Math.random() * values().length)];
    }

    /**
     * @return the sickness name
     */
    public String getSicknessName() {
        return sicknessName;
    }

    public int getGravity() {
        return gravity;
    }
}
