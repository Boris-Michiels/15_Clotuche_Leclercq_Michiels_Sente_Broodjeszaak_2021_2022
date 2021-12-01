package model.database;

import model.Broodje;
import model.database.loadSaveStrategies.BroodjesTekstLoadSaveStrategy;

import java.util.Map;
import java.util.TreeMap;

public class BroodjesDatabase {
    private static BroodjesDatabase instance;
    private static Map<String, Broodje> broodjes;

    public static BroodjesDatabase getInstance() {
        if (instance == null) instance = new BroodjesDatabase();
        setBroodjes(new BroodjesTekstLoadSaveStrategy().load("src/bestanden/broodjes.txt"));
        return instance;
    }

    private BroodjesDatabase() {
        broodjes = new TreeMap<>();
    }

    public static Map<String, Broodje> getBroodjes() {
        return broodjes;
    }

    public static void setBroodjes(Map<String, Broodje> broodjes) {
        BroodjesDatabase.broodjes = new TreeMap<>(broodjes);
    }
}
