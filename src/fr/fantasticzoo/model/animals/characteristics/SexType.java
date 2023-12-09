package fr.fantasticzoo.model.animals.characteristics;

public enum SexType {
    MALE,
    FEMALE;


    public static SexType getRandomSex() {
        return values()[(int) (Math.random() * values().length)];
    }

}
