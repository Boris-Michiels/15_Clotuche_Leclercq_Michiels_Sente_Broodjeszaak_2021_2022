package model;

import java.util.ArrayList;

public class Bestelling {
    private ArrayList<BestelLijn> bestellijnen = new ArrayList<>();
    private BestelLijn bestelLijn;

    public void voegBestelLijnToe(Broodje broodje) {
        bestelLijn = new BestelLijn(broodje);
        bestellijnen.add(bestelLijn);
    }

    public void addBeleg(Beleg beleg) {
        bestelLijn.addBeleg(beleg);
    }

    public BestelLijn getBestelLijn() {
        return bestelLijn;
    }

    public void setBestelLijn(BestelLijn bestelLijn) {
        this.bestelLijn = bestelLijn;
    }

    public ArrayList<BestelLijn> getLijstBestellijnen() {
        return bestellijnen;
    }

    @Override
    public String toString() {
        return bestellijnen.toString();
    }
}
