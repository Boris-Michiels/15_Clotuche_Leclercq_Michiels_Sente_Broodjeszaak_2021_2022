package model;

import model.database.DataBaseService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestelFacade implements Subject {
    private DataBaseService dataBaseService;
    private Bestelling bestelling;
    private HashMap<BestellingEvents, List<Observer>> observers;

    public BestelFacade() {
        dataBaseService = DataBaseService.getInstance();
        this.observers = new HashMap<>();
        for (BestellingEvents event : BestellingEvents.values()) {
            observers.put(event, new ArrayList<>());
        }
    }

    public void nieuweBestelling() {
        this.bestelling = new Bestelling();
        //notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }

    public void addBroodje(String broodje) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        bestelling.voegBestelLijnToe(dataBaseService.getBroodje(broodje));
        notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }

    public void addBeleg(String beleg) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        if (bestelling.getBestelLijn() == null) throw new IllegalArgumentException("Voeg eerst een broodje toe");
        bestelling.addBeleg(dataBaseService.getBeleg(beleg));
        notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    /*public List<Broodje> getVooraadLijstBroodjes() {
        return dataBaseService.getAvailableBrood();
    }*/

    @Override
    public void addObserver(BestellingEvents e, Observer o) {
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(BestellingEvents e) {
        for (Observer o : observers.get(e)) {
            o.update();
        }
    }

    public Map<String, Integer> getVoorraadlijstBroodjes() {
        return dataBaseService.getVoorraadlijstBroodjes();
    }

    public Map<String, Integer> getVoorraadlijstBeleg() {
        return dataBaseService.getVoorraadlijstBeleg();
    }

    public List<Broodje> getAllBrood() {
        return dataBaseService.getBroodjes();
    }

    public List<Beleg> getAllBeleg() {
        return dataBaseService.getBeleg();
    }

    public List<Broodje> getAvailableBrood() {
        return dataBaseService.getAvailableBrood();
    }

    public List<Beleg> getAvailableBeleg() {
        return dataBaseService.getAvailableBeleg();
    }

    public List<BestelLijn> getLijstBestellijnen() {
        return bestelling.getLijstBestellijnen();
    }

    public int checkAvailability(String naam, String type) {
        if (type.equals("Broodje")) return dataBaseService.getAvailabilityBroodje(naam);
        if (type.equals("Beleg")) return dataBaseService.getAvailabilityBeleg(naam);
        return -1;
    }

    public void removeBestellijn(BestelLijn b) {
        dataBaseService.adjustVoorraadBroodje(b.getNaambroodje(), +1);
        for (String bl : b.getNamenbeleg()) {
            dataBaseService.adjustVoorraadBeleg(bl, +1);
        }
        this.bestelling.removeBestelLijn(b);
        notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }
}
