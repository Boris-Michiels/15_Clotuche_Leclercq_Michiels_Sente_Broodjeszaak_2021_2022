package model;

import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class BestellingState {
    private Bestelling bestelling;
    public void voegBestelLijnToe(String broodjenaam) {
        bestelling.voegBestelLijnToe(broodjenaam);

    }

}
