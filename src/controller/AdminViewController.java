package controller;

import model.Beleg;
import model.BestellingEvents;
import model.Broodje;
import model.Observer;
import model.database.DataBaseService;
import view.AdminView;

import java.util.List;
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
    public void update() {
        adminView.updateDisplay();
    }
}
