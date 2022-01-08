package model.bestelStates;

import model.Beleg;
import model.BestelLijn;
import model.Bestelling;
import model.Broodje;

import java.util.List;

public class InBestelling implements BestellingState {
    private final Bestelling bestelling;

    public InBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void startBestelling() {
        throw new IllegalArgumentException("Bestelling is al gestart");
    }

    @Override
    public void voegBestelLijnToe(Broodje broodje) {
        bestelling.getLijstBestellijnen().add(new BestelLijn(broodje));
    }

    @Override
    public void addBeleg(Beleg beleg, BestelLijn selectedItem) {
        selectedItem.addBeleg(beleg);
    }

    @Override
    public void removeBestelLijn(BestelLijn b) {
        bestelling.getLijstBestellijnen().remove(b);
    }

    @Override
    public void addIdemBestellijn(Broodje broodje, List<Beleg> beleg) {
        bestelling.voegBestelLijnToe(broodje);
        BestelLijn bestelLijn = bestelling.getLijstBestellijnen().get(bestelling.getLijstBestellijnen().size() - 1);
        for (Beleg b : beleg) bestelling.addBeleg(b, bestelLijn);
    }

    @Override
    public void afsluiten() {

    }

    @Override
    public void annuleren() {

    }

    @Override
    public void betalen() {

    }

    @Override
    public void zendNaarKeuken() {

    }

    @Override
    public void startBereiding() {

    }

    @Override
    public void afgewerkt() {

    }
}

