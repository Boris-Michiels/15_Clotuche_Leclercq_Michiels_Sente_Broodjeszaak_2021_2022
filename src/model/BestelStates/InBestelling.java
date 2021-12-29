package model.BestelStates;

import model.Bestelling;
import model.Broodje;

public class InBestelling extends BestellingState {
    private Bestelling bestelling;
    @Override
    public void voegBestelLijnToe(Broodje broodje) {
        bestelling.voegBestelLijnToe(broodje);

    }
}

