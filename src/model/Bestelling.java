package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Bestelling {


    private ArrayList<BestelLijn>bestellijnen = new ArrayList<>();

    public void voegBestelLijnToe(String broodjenaam,ArrayList<String>belegnamen) {
        BestelLijn bestelLijn = new BestelLijn(broodjenaam,belegnamen);
        bestellijnen.add(bestelLijn);



    }

    public ArrayList<BestelLijn> getLijstBestellijnen() {
        return bestellijnen;
    }
}
