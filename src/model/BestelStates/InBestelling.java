package model.BestelStates;

import model.Bestelling;

public class InBestelling extends BestellingState {
    private Bestelling bestelling;
    @Override
    public void voegBestelLijnToe(String broodjenaam) {
        bestelling.voegBestelLijnToe(broodjenaam);

    }
}

