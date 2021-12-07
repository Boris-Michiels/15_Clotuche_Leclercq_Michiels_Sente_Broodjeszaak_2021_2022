package model.database;

import model.database.loadSaveStrategies.LoadSaveStrategy;

public class DataBaseContext {
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private LoadSaveStrategy broodjesLoadSaveStrategy, belegLoadSaveStrategy;

    public DataBaseContext() {
        this.broodjesDatabase = BroodjesDatabase.getInstance();
        this.belegDatabase = BelegDatabase.getInstance();
    }

    public void setBroodjesLoadSaveStrategy(LoadSaveStrategy broodjesLoadSaveStrategy) {
        this.broodjesLoadSaveStrategy = broodjesLoadSaveStrategy;
    }

    public void setBelegLoadSaveStrategy(LoadSaveStrategy belegLoadSaveStrategy) {
        this.belegLoadSaveStrategy = belegLoadSaveStrategy;
    }
}
