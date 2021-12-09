package model.database;

import model.Beleg;
import model.Broodje;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.Map;

public class DataBaseContext {
    private static DataBaseContext instance;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private LoadSaveStrategy broodjesLoadSaveStrategy, belegLoadSaveStrategy;
    private String broodjesFilePath, belegFilePath;

    private DataBaseContext() {
        this.broodjesDatabase = BroodjesDatabase.getInstance();
        this.belegDatabase = BelegDatabase.getInstance();
    }

    public static DataBaseContext getInstance() {
        if (instance == null) instance = new DataBaseContext();
        return instance;
    }

    public void setLoadSaveStrategy(String strategy) {
        if (strategy.equals("Excel")) {
            setBroodjesLoadSaveStrategy("EXCEL");
            setBelegLoadSaveStrategy("EXCEL");
        } else if (strategy.equals("Tekst")) {
            setBroodjesLoadSaveStrategy("TEKST");
            setBelegLoadSaveStrategy("TEKST");
        }
    }

    public Map<String, Broodje> getBroodjes() {
        return broodjesDatabase.getBroodjes();
    }

    public Map<String, Beleg> getBeleg() {
        return belegDatabase.getBeleg();
    }

    public void setBroodjes(Map<String, Broodje> broodjes) {
        broodjesDatabase.setBroodjes(broodjes);
    }

    public void setBeleg(Map<String, Beleg> beleg) {
        belegDatabase.setBeleg(beleg);
    }

    public void loadProducts() {
        loadBroodjes();
        loadBeleg();
    }

    public void loadBroodjes() {
        setBroodjes(broodjesLoadSaveStrategy.load(broodjesFilePath));
    }

    public void loadBeleg() {
        setBeleg(belegLoadSaveStrategy.load(belegFilePath));
    }

    public void setBroodjesLoadSaveStrategy(String broodjesLoadSaveStrategyString) {
        this.broodjesLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("BROODJES" + broodjesLoadSaveStrategyString);
        this.broodjesFilePath = LoadSaveStrategyEnum.valueOf("BROODJES" + broodjesLoadSaveStrategyString).getFilePath();
    }

    public void setBelegLoadSaveStrategy(String belegLoadSaveStrategyString) {
        this.belegLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("BELEG" + belegLoadSaveStrategyString);
        this.belegFilePath = LoadSaveStrategyEnum.valueOf("BELEG" + belegLoadSaveStrategyString).getFilePath();
    }
}
