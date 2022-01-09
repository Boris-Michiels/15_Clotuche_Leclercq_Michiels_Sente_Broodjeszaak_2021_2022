package controller;

import model.*;
import model.database.DataBaseService;
import view.AdminView;

import java.util.List;
import java.util.Map;

public class AdminViewController implements Observer {
    private AdminView adminView;
    private DataBaseService dataBaseService;
    private BestelFacade bestelFacade;

    public AdminViewController(AdminView adminView, BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
        bestelFacade.addObserver(BestellingEvents.NAAR_KEUKEN, this);
        dataBaseService = DataBaseService.getInstance();
        this.adminView = adminView;
        this.adminView.setAdminViewController(this);
        setLoadSaveStrategy("Tekst");
        loadProducts();
        adminView.updateDisplay();
    }

    public void setLoadSaveStrategy(String loadSaveStrategy) {
        dataBaseService.setLoadSaveStrategy(loadSaveStrategy);
    }

    public void setBroodjesLoadSaveStrategy(String broodjesLoadSaveStrategyString) {
        dataBaseService.setBroodjesLoadSaveStrategy(broodjesLoadSaveStrategyString);
    }

    public void setBelegLoadSaveStrategy(String belegLoadSaveStrategyString) {
        dataBaseService.setBelegLoadSaveStrategy(belegLoadSaveStrategyString);
    }
    public void loadProducts() {
        dataBaseService.loadProducts();
    }

    public List<Broodje> getBroodjes() {
        return dataBaseService.getBroodjes();
    }

    public List<Beleg> getBeleg() {
        return dataBaseService.getBeleg();
    }

    public Map<String, Broodje> getBroodjesMap() {
        return dataBaseService.getBroodjesMap();
    }

    public Map<String, Beleg> getBelegMap() {
        return dataBaseService.getBelegMap();
    }

    @Override
    public void update(BestellingEvents e) {
        adminView.updateDisplay();
    }
}
