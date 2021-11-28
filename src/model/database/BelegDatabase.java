package model.database;

import model.Beleg;

import java.util.Map;

public class BelegDatabase {
    private static Map<String, Beleg> beleg;

    public BelegDatabase() {
        beleg = new BelegTekstLoadSave().ReadFile("src/bestanden/beleg.txt");
    }

    public static Map<String, Beleg> getBeleg() {
        return beleg;
    }

    public void setBeleg(Map<String, Beleg> beleg) {
        this.beleg = beleg;
    }
}
