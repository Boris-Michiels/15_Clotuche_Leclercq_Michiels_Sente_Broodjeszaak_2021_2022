package controller;

import model.*;
import view.OrderView;

import java.util.List;
import java.util.Map;

public class OrderViewController implements Observer {
    private OrderView orderView;
    private BestelFacade bestelFacade;

    public OrderViewController(OrderView orderView) {
        bestelFacade = new BestelFacade();
        bestelFacade.addObserver(BestellingEvents.TOEVOEGEN_BROODJE, this);
        this.orderView = orderView;
        this.orderView.setOrderViewController(this);
        this.orderView.populateMenu();
        //update();
    }

    public void nieuweBestelling() {
        bestelFacade.nieuweBestelling();
    }

    public void addBroodje(String broodje) {
        try {
            bestelFacade.addBroodje(broodje);
        } catch (IllegalArgumentException e) {
            orderView.displayMessage(e.getMessage());
        }
    }

    public void addBeleg(String beleg) {
        try {
            bestelFacade.addBeleg(beleg);
        } catch (IllegalArgumentException e) {
            orderView.displayMessage(e.getMessage());
        }
    }

    public List<BestelLijn> getBestelLijnen() {
        return bestelFacade.getLijstBestellijnen();
    }

    public List<Broodje> getAllBrood() {
        return bestelFacade.getAllBrood();
    }

    public List<Beleg> getAllBeleg() {
        return bestelFacade.getAllBeleg();
    }

    public List<Broodje> getAvailableBrood() {
        return bestelFacade.getAvailableBrood();
    }

    public List<Beleg> getAvailableBeleg() {
        return bestelFacade.getAvailableBeleg();
    }

    @Override
    public void update() {
        orderView.updateDisplay();
        orderView.updateStatusMenuKnoppen();
    }

    public Map<String, Integer> getVoorraadlijstBroodjes() {
        return bestelFacade.getVoorraadlijstBroodjes();
    }

    public Map<String, Integer> getVoorraadlijstBeleg() {
        return bestelFacade.getVoorraadlijstBeleg();
    }

    public void test() {
        System.out.println(bestelFacade.getBestelling());
    }

    public int checkAvailability(String naam, String type) {
        return bestelFacade.checkAvailability(naam, type);
    }

    public void removeBestellijn(BestelLijn b) {
        bestelFacade.removeBestellijn(b);
    }
}
