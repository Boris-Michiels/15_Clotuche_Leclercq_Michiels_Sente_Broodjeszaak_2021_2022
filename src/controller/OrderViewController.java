package controller;

import model.*;
import model.database.DataBaseService;
import view.OrderView;

import java.util.ArrayList;
import java.util.List;

public class OrderViewController implements Observer {
    private OrderView orderView;
    private BestelFacade bestelFacade;
    private DataBaseService dataBaseService;

    public OrderViewController(OrderView orderView) {
        dataBaseService = DataBaseService.getInstance();
        this.orderView = orderView;
        this.orderView.setOrderViewController(this);
        this.orderView.populateMenu();
        bestelFacade = new BestelFacade();
        bestelFacade.addObserver(BestellingEvents.TOEVOEGEN_BROODJE, this);
        //update();
    }

    public void nieuweBestelling() {
        bestelFacade.nieuweBestelling();
    }

    public void addBroodje(String broodje) {
        try {
            bestelFacade.addBroodje(dataBaseService.getBroodje(broodje));
            dataBaseService.useBroodje(broodje);
            bestelFacade.notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
        } catch (IllegalArgumentException e) {
            orderView.displayMessage(e.getMessage());
        }
    }

    public void addBeleg(String beleg) {
        try {
            bestelFacade.addBeleg(dataBaseService.getBeleg(beleg));
            dataBaseService.useBeleg(beleg);
            bestelFacade.notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
        } catch (IllegalArgumentException e) {
            orderView.displayMessage(e.getMessage());
        }
    }

    public ArrayList<BestelLijn> getBestelLijnen() {
        return bestelFacade.getBestelling().getLijstBestellijnen();
    }

    public List<Broodje> getAvailableBrood() {
        return dataBaseService.getAvailableBrood();
    }

    public List<Beleg> getAvailableBeleg() {
        return dataBaseService.getAvailableBeleg();
    }

    @Override
    public void update() {
        orderView.updateDisplay();
    }

    public void test() {
        System.out.println(bestelFacade.getBestelling());
    }
}
