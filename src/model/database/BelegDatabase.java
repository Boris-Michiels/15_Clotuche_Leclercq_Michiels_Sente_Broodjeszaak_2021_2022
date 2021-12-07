package model.database;

import model.Beleg;

import java.util.Map;
import java.util.TreeMap;

public class BelegDatabase {
    private static BelegDatabase instance;
    private static Map<String, Beleg> beleg;

    public static BelegDatabase getInstance() {
        if (instance == null) instance = new BelegDatabase();
        return instance;
    }

    private BelegDatabase() {
        beleg = new TreeMap<>();
    }

    public Map<String, Beleg> getBeleg() {
        return beleg;
    }

    public void setBeleg(Map<String, Beleg> beleg) {
        BelegDatabase.beleg = new TreeMap<>(beleg);
    }
}
