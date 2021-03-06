package model.database;

import model.Broodje;

import java.util.Map;
import java.util.TreeMap;

public class BroodjesDatabase {
    private static BroodjesDatabase instance;
    private static Map<String, Broodje> broodjes;

    public static BroodjesDatabase getInstance() {
        if (instance == null) instance = new BroodjesDatabase();
        return instance;
    }

    private BroodjesDatabase() {
        broodjes = new TreeMap<>();
    }

    public Map<String, Broodje> getBroodjes() {
        return broodjes;
    }

    public void setBroodjes(Map<String, Broodje> broodjes) {
        BroodjesDatabase.broodjes = new TreeMap<>(broodjes);
    }
}
