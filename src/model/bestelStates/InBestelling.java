package model.bestelStates;

import model.Bestelling;

public class InBestelling extends BestellingState {
    public InBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void voegBestelLijnToe() {
    }
}

