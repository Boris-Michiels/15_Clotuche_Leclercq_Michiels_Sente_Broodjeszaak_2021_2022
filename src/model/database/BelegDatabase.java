package model.database;

import model.Beleg;
import model.database.loadSaveStrategies.BelegTekstLoadSaveStrategy;

import java.util.Map;
import java.util.TreeMap;

public class BelegDatabase {
    private static BelegDatabase instance;
    private static Map<String, Beleg> beleg;

    public static BelegDatabase getInstance() {
        if (instance == null) instance = new BelegDatabase();
        setBeleg(new BelegTekstLoadSaveStrategy().load("src/bestanden/beleg.txt"));
        return instance;
    }

    private BelegDatabase() {
        beleg = new TreeMap<>();
    }

    public static Map<String, Beleg> getBeleg() {
        return beleg;
    }

    public static void setBeleg(Map<String, Beleg> beleg) {
        BelegDatabase.beleg = new TreeMap<>(beleg);
    }
}
