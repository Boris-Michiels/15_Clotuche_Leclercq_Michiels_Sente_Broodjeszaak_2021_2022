package model.bestelStates;

import model.Beleg;
import model.BestelLijn;
import model.Bestelling;
import model.Broodje;

import java.util.List;

public class InWacht implements BestellingState {
    private final Bestelling bestelling;

    public InWacht(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void startBestelling() {
        bestelling.setBestellingState(bestelling.getInBestelling());
    }

    @Override
    public void voegBestelLijnToe(Broodje broodje) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }

    @Override
    public void addBeleg(Beleg beleg, BestelLijn selectedItem) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }

    @Override
    public void removeBestelLijn(BestelLijn b) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }

    @Override
    public void addIdemBestellijn(Broodje broodje, List<Beleg> beleg) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }

    @Override
    public void afsluiten() {
        throw new IllegalArgumentException("Bestelling in wacht");
    }

    @Override
    public void annuleren() {
        throw new IllegalArgumentException("Bestelling in wacht");
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
