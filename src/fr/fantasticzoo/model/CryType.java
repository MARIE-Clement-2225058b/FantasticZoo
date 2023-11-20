package fr.fantasticzoo.model;

public enum CryType {
    APPARTENANCE("APPARTENANCE"),
    DOMINATION("DOMINATION"),
    SOUMISSION("SOUMISSION"),
    AGGRESSIVITE("AGGRESSIVITE"),
    GENERICCRY("GENERICCRY");

    private final String cryname;

    CryType(String cryname) {
        this.cryname = cryname;
    }

    public String getCryname() {
        return cryname;
    }
}
