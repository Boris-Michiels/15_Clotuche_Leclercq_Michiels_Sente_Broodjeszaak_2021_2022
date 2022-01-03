package model.database;

import model.Beleg;
import model.Broodje;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataBaseService {
    private static DataBaseService instance;
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private LoadSaveStrategy broodjesLoadSaveStrategy, belegLoadSaveStrategy;
    private String broodjesFilePath, belegFilePath;

    private DataBaseService() {
        this.broodjesDatabase = BroodjesDatabase.getInstance();
        this.belegDatabase = BelegDatabase.getInstance();
    }

    public static DataBaseService getInstance() {
        if (instance == null) instance = new DataBaseService();
        return instance;
    }

    public Map<String, Broodje> getBroodjesMap() {
        return broodjesDatabase.getBroodjes();
    }

    public Map<String, Beleg> getBelegMap() {
        return belegDatabase.getBeleg();
    }

    public List<Broodje> getBroodjes() {
        return new ArrayList<>(getBroodjesMap().values());
    }

    public List<Beleg> getBeleg() {
        return new ArrayList<>(getBelegMap().values());
    }

    public Broodje getBroodje(String broodje) {
        return broodjesDatabase.getBroodjes().get(broodje);
    }

    public Beleg getBeleg(String beleg) {
        return belegDatabase.getBeleg().get(beleg);
    }

    public Map<String, Integer> getVoorraadlijstBroodjes() {
        return getBroodjes().stream().collect(Collectors.toMap(Broodje::getNaam, Broodje::getVoorraad));
    }

    public Map<String, Integer> getVoorraadlijstBeleg() {
        return getBeleg().stream().collect(Collectors.toMap(Beleg::getNaam, Beleg::getVoorraad));
    }

    public List<Broodje> getAvailableBrood() {
        return broodjesDatabase.getBroodjes().values().stream().filter(b -> b.getVoorraad() > 0).collect(Collectors.toList());
    }

    public List<Beleg> getAvailableBeleg() {
        return belegDatabase.getBeleg().values().stream().filter(b -> b.getVoorraad() > 0).collect(Collectors.toList());
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

    public void setBroodjes(Map<String, Broodje> broodjes) {
        broodjesDatabase.setBroodjes(broodjes);
    }

    public void setBeleg(Map<String, Beleg> beleg) {
        belegDatabase.setBeleg(beleg);
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

    public void setBroodjesLoadSaveStrategy(String broodjesLoadSaveStrategyString) {
        this.broodjesLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("BROODJES" + broodjesLoadSaveStrategyString);
        this.broodjesFilePath = LoadSaveStrategyEnum.valueOf("BROODJES" + broodjesLoadSaveStrategyString).getFilePath();
    }

    public void setBelegLoadSaveStrategy(String belegLoadSaveStrategyString) {
        this.belegLoadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("BELEG" + belegLoadSaveStrategyString);
        this.belegFilePath = LoadSaveStrategyEnum.valueOf("BELEG" + belegLoadSaveStrategyString).getFilePath();
    }

    public void adjustVoorraadBroodje(String broodje, int c) {
        Broodje b = getBroodje(broodje);
        b.setVoorraad(b.getVoorraad() + c);
    }

    public void adjustVoorraadBeleg(String beleg, int c) {
        Beleg b = getBeleg(beleg);
        b.setVoorraad(b.getVoorraad() + c);
    }

    public int getAvailabilityBroodje(String broodje) {
        return getBroodje(broodje).getVoorraad();
    }

    public int getAvailabilityBeleg(String beleg) {
        return getBeleg(beleg).getVoorraad();
    }
}
