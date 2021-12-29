package model.BestelStates;

import model.Broodje;

public class InWacht extends BestellingState {
    @Override
    public void voegBestelLijnToe(Broodje broodje) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }
}
