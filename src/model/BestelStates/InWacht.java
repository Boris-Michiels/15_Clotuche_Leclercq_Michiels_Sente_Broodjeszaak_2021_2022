package model.BestelStates;

public class InWacht extends BestellingState {

    @Override
    public void voegBestelLijnToe(String broodjenaam) {
        throw new IllegalArgumentException("Bestelling in wacht");
    }
}
