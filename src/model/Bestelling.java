package model;

import model.bestelStates.*;

import java.util.ArrayList;
import java.util.List;

public class Bestelling {
    private ArrayList<BestelLijn> bestellijnen;
    private BestellingState bestellingState, inWacht, inBestelling, afgesloten, inWachtrij, inBereiding, betaald;

    public Bestelling() {
        this.bestellijnen = new ArrayList<>();
        inWacht = new InWacht(this);
        inBestelling = new InBestelling(this);
        afgesloten = new Afgesloten(this);
        inWachtrij = new InWachtrij(this);
        inBereiding = new InBereiding(this);
        betaald = new Betaald(this);
        bestellingState = inWacht;
    }

    public void startBestelling() {
        bestellingState.startBestelling();
    }

    public void voegBestelLijnToe(Broodje broodje) {
        bestellingState.voegBestelLijnToe(broodje);
    }

    public void addBeleg(Beleg beleg, BestelLijn selectedItem) {
        bestellingState.addBeleg(beleg, selectedItem);
    }

    public ArrayList<BestelLijn> getLijstBestellijnen() {
        return bestellijnen;
    }

    @Override
    public String toString() {
        return bestellijnen.toString();
    }

    public void removeBestelLijn(BestelLijn b) {
        bestellingState.removeBestelLijn(b);
    }

    public BestellingState getBestellingState() {
        return bestellingState;
    }

    public void setBestellingState(BestellingState bestellingState) {
        this.bestellingState = bestellingState;
    }

    public BestellingState getInWacht() {
        return inWacht;
    }

    public BestellingState getInBestelling() {
        return inBestelling;
    }

    public BestellingState getAfgesloten() {
        return afgesloten;
    }

    public BestellingState getInWachtrij() {
        return inWachtrij;
    }

    public BestellingState getInBereiding() {
        return inBereiding;
    }

    public BestellingState getBetaald() {
        return betaald;
    }

    public void addIdemBestellijn(Broodje broodje, List<Beleg> beleg) {
        bestellingState.addIdemBestellijn(broodje, beleg);
    }
}
