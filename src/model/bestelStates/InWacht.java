package model.bestelStates;

import model.Bestelling;

public class InWacht extends BestellingState {
    public InWacht(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void voegBestelLijnToe() {
        throw new IllegalArgumentException("Bestelling in wacht");
    }
}
