package controller;

import model.*;
import model.database.DataBaseService;
import view.OrderView;

import java.util.List;

public class OrderViewController implements Observer {
    private OrderView orderView;
    private DataBaseService dataBaseService;

    public OrderViewController(OrderView orderView) {
        dataBaseService = DataBaseService.getInstance();
        this.orderView = orderView;
        this.orderView.setOrderViewController(this);
        this.orderView.populateMenu();
        update();
    }

    public void update() {
        orderView.updateDisplay();
    }

    public List<Broodje> getAvailableBrood() {
        return dataBaseService.getAvailableBrood();
    }

    public List<Beleg> getAvailableBeleg() {
        return dataBaseService.getAvailableBeleg();
    }

    @Override
    public void update(BestellingEvents e) {
        orderView.updateDisplay();


    }
}
