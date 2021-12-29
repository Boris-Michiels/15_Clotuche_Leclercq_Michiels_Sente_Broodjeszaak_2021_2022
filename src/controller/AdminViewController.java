package controller;

import model.Beleg;
import model.Broodje;
import model.database.DataBaseService;
import view.AdminView;

import java.util.Map;

public class AdminViewController {
    private AdminView adminView;
    private DataBaseService dataBaseService;

    public AdminViewController(AdminView adminView) {
        this.adminView = adminView;
        this.adminView.setAdminViewController(this);
        dataBaseService = DataBaseService.getInstance();
        setLoadSaveStrategy("Tekst");
        loadProducts();
        update();
    }

    public void setLoadSaveStrategy(String loadSaveStrategy) {
        dataBaseService.setLoadSaveStrategy(loadSaveStrategy);
    }

    public void update() {
        adminView.updateDisplay();
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
}
