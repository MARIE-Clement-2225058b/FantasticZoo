package fr.fantasticzoo.model.animals.characteristics;

public enum Names {
    John,
    Mary,
    Michael,
    Linda,
    William,
    Elizabeth,
    David,
    Susan,
    Richard,
    Jennifer,
    Patricia,
    Joseph,
    Barbara,
    Thomas,
    Jessica,
    Daniel,
    Sarah,
    Christopher,
    Karen,
    Matthew,
    Nancy,
    Anthony,
    Lisa,
    Mark,
    Betty,
    Paul,
    Helen,
    Steven,
    Sandra,
    Julien,
    Clément,
    Charles;

    private String name;

    Names() {
        this.name = this.name();
    }

    public static String getRandomName() {
        return values()[(int) (Math.random() * values().length)].name;
    }
}