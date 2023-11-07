package fr.fantasticzoo.model;

public enum Enclos {
    ;
    private final String name;
    private final float area;
    private final int maxAnim;
    private final int numberAnim;
    private final float sanitaryLevel;
    Enclos(String name, float area, int maxAnim, int numberAnim, float sanitaryLevel) {
        this.name = name;
        this.area = area;
        this.maxAnim = maxAnim;
        this.numberAnim = numberAnim;
        this.sanitaryLevel = sanitaryLevel;
    }

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }

    public int getMaxAnim() {
        return maxAnim;
    }

    public int getNumberAnim() {
        return numberAnim;
    }

    public float getSanitaryLevel() {
        return sanitaryLevel;
    }
}
