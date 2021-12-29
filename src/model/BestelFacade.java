package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestelFacade implements Subject {
    private Bestelling bestelling;
    private HashMap<BestellingEvents, List<Observer>> observers;

    public BestelFacade() {
        this.observers = new HashMap<>();
        for (BestellingEvents event : BestellingEvents.values()) {
            observers.put(event, new ArrayList<>());
        }
    }

    public void nieuweBestelling() {
        this.bestelling = new Bestelling();
    }

    public void addBroodje(Broodje broodje) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        bestelling.voegBestelLijnToe(broodje);
    }

    public void addBeleg(String beleg) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        if (bestelling.getBestelLijn() == null) throw new IllegalArgumentException("Voeg eerst een broodje toe");
        bestelling.addBeleg(beleg);
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
            o.update(e);
        }
    }
}
