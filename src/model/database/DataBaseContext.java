package model.database;

import model.Beleg;
import model.Broodje;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.Map;

public class DataBaseContext {
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private LoadSaveStrategy broodjesLoadSaveStrategy, belegLoadSaveStrategy;

    public DataBaseContext() {
        this.broodjesDatabase = BroodjesDatabase.getInstance();
        this.belegDatabase = BelegDatabase.getInstance();
    }

    public Map<String, Broodje> getBroodjes() {
        loadBroodjes("src/bestanden/broodjes.txt");
        return broodjesDatabase.getBroodjes();
    }

    public Map<String, Beleg> getBeleg() {
        loadBeleg("src/bestanden/beleg.txt");
        return belegDatabase.getBeleg();
    }

    public void setBroodjes(Map<String, Broodje> broodjes) {
        broodjesDatabase.setBroodjes(broodjes);
    }

    public void setBeleg(Map<String, Beleg> beleg) {
        belegDatabase.setBeleg(beleg);
    }

    public void loadBroodjes(String path) {
        setBroodjes(broodjesLoadSaveStrategy.load(path));
    }

    public void loadBeleg(String path) {
        setBeleg(belegLoadSaveStrategy.load(path));
    }

    public void setBroodjesLoadSaveStrategy(String broodjesLoadSaveStrategyString) {
        this.broodjesLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy(broodjesLoadSaveStrategyString);
    }

    public void setBelegLoadSaveStrategy(String belegLoadSaveStrategyString) {
        this.belegLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy(belegLoadSaveStrategyString);
    }
}
