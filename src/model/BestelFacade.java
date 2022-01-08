package model;

import model.database.DataBaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
        notifyObservers(BestellingEvents.NIEUWE_BESTELLING);
    }

    public void addBroodje(String broodje) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        bestelling.voegBestelLijnToe(dataBaseService.getBroodje(broodje));
        notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }

    public void addBeleg(String beleg, BestelLijn selectedItem) {
        if (bestelling == null) throw new IllegalArgumentException("Maak eerst een nieuwe bestelling aan");
        if (selectedItem == null) throw new IllegalArgumentException("Selecteer eerst een broodje om het beleg aan toe te voegen");
        bestelling.addBeleg(dataBaseService.getBeleg(beleg), selectedItem);
        notifyObservers(BestellingEvents.TOEVOEGEN_BELEG);
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    @Override
    public void addObserver(BestellingEvents e, Observer o) {
        observers.get(e).add(o);
    }

    public void addObservers(List<BestellingEvents> es, Observer o) {
        for (BestellingEvents e : es) addObserver(e, o);
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
        notifyObservers(BestellingEvents.VERWIJDEREN_BESTELLIJN);
    }

    public void addBestellijn(BestelLijn selectedItem) {
        if (getVoorraadlijstBroodjes().get(selectedItem.getNaambroodje()) < 1) throw new IllegalArgumentException("Dit broodje is niet meer in voorraad.");
        Map<String, Long> beleg = selectedItem.getNamenbeleg().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> voorraadlijstBeleg = getVoorraadlijstBeleg();
        for (String b : beleg.keySet()) {
            if (voorraadlijstBeleg.get(b) < beleg.get(b)) throw new IllegalArgumentException("Beleg " + b + " is niet meer genoeg in voorraad");
        }
        bestelling.voegBestelLijnToe(dataBaseService.getBroodje(selectedItem.getNaambroodje()));
        BestelLijn bestelLijn = getLijstBestellijnen().get(getLijstBestellijnen().size() - 1);
        for (String b : selectedItem.getNamenbeleg()) addBeleg(b, bestelLijn);
        notifyObservers(BestellingEvents.TOEVOEGEN_BROODJE);
    }
}
