package model.database;

import model.Broodje;

import java.util.Map;

public class BroodjesDatabase {
    private static Map<String, Broodje> broodjes;

    public BroodjesDatabase() {
        broodjes = new BroodjesTekstLoadSave().ReadFile("src/bestanden/broodjes.txt");
    }

    public static Map<String, Broodje> getBroodjes() {
        return broodjes;
    }

    public void setBroodjes(Map<String, Broodje> broodjes) {
        this.broodjes = broodjes;
    }


}
