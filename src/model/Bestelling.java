package model;

import model.bestelStates.BestellingState;
import model.bestelStates.InWacht;

import java.util.ArrayList;

public class Bestelling {
    private ArrayList<BestelLijn> bestellijnen;
    private BestellingState bestellingState;

    public Bestelling() {
        this.bestellijnen = new ArrayList<>();
        this.bestellingState = new InWacht(this);
    }

    public void voegBestelLijnToe(Broodje broodje) {
        //bestellingState.voegBestelLijnToe();
        bestellijnen.add(new BestelLijn(broodje));
    }

    public void addBeleg(Beleg beleg, BestelLijn selectedItem) {
        selectedItem.addBeleg(beleg);
    }

    public ArrayList<BestelLijn> getLijstBestellijnen() {
        return bestellijnen;
    }

    @Override
    public String toString() {
        return bestellijnen.toString();
    }

    public void removeBestelLijn(BestelLijn b) {
        bestellijnen.remove(b);
    }

    public BestellingState getBestellingState() {
        return bestellingState;
    }

    public void setBestellingState(BestellingState bestellingState) {
        this.bestellingState = bestellingState;
    }
}
