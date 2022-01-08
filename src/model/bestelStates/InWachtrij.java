package model.bestelStates;

import model.Beleg;
import model.BestelLijn;
import model.Bestelling;
import model.Broodje;

import java.util.List;

public class InWachtrij implements BestellingState {
    private final Bestelling bestelling;

    public InWachtrij(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void startBestelling() {

    }

    @Override
    public void voegBestelLijnToe(Broodje broodje) {

    }

    @Override
    public void addBeleg(Beleg beleg, BestelLijn selectedItem) {

    }

    @Override
    public void removeBestelLijn(BestelLijn b) {

    }

    @Override
    public void addIdemBestellijn(Broodje broodje, List<Beleg> beleg) {

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
