package controller;

import model.database.DataBaseContext;
import view.AdminView;

public class AdminViewController {
    private AdminView adminView;
    private DataBaseContext dataBaseContext;

    public AdminViewController() {
        dataBaseContext = DataBaseContext.getInstance();
        setLoadSaveStrategy("Tekst");
        loadProducts();
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public void setLoadSaveStrategy(String loadSaveStrategy) {
        dataBaseContext.setLoadSaveStrategy(loadSaveStrategy);
    }

    public void update() {
        adminView.updateDisplay(dataBaseContext);
    }

    public void loadProducts() {
        dataBaseContext.loadProducts();
    }
}
