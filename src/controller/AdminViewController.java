package controller;

import model.Beleg;
import model.BestellingEvents;
import model.Broodje;
import model.Observer;
import model.database.DataBaseService;
import view.AdminView;

import java.util.Map;

public class AdminViewController implements Observer {
    private AdminView adminView;
    private DataBaseService dataBaseService;

    public AdminViewController(AdminView adminView) {
        dataBaseService = DataBaseService.getInstance();
        this.adminView = adminView;
        this.adminView.setAdminViewController(this);
        setLoadSaveStrategy("Tekst");
        loadProducts();
        update();
    }

    public void setLoadSaveStrategy(String loadSaveStrategy) {
        dataBaseService.setLoadSaveStrategy(loadSaveStrategy);
    }

    public void loadProducts() {
        dataBaseService.loadProducts();
    }

    public Map<String, Broodje> getBroodjes() {
        return dataBaseService.getBroodjes();
    }

    public Map<String, Beleg> getBeleg() {
        return dataBaseService.getBeleg();
    }

    @Override
    public void update() {
        adminView.updateDisplay();
    }
}
