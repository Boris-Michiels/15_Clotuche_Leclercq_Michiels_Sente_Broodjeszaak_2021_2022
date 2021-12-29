package controller;

import model.Beleg;
import model.Broodje;
import model.database.DataBaseService;
import view.OrderView;

import java.util.List;

public class OrderViewController {
    private OrderView orderView;
    private DataBaseService dataBaseService;

    public OrderViewController(OrderView orderView) {
        this.orderView = orderView;
        this.orderView.setOrderViewController(this);
        dataBaseService = DataBaseService.getInstance();
        setLoadSaveStrategy("Tekst");
        loadProducts();
        update();
    }

    public void setLoadSaveStrategy(String loadSaveStrategy) {
        dataBaseService.setLoadSaveStrategy(loadSaveStrategy);
    }

    public void update() {
        orderView.updateDisplay();
    }

    public void loadProducts() {
        dataBaseService.loadProducts();
    }

    public List<Broodje> getAvailableBrood() {
        return dataBaseService.getAvailableBrood();
    }

    public List<Beleg> getAvailableBeleg() {
        return dataBaseService.getAvailableBeleg();
    }
}
