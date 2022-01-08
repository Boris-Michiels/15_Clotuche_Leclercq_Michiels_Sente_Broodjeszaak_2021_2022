package model.bestelStates;

import model.Bestelling;

public abstract class BestellingState {
    protected Bestelling bestelling;
    public abstract void voegBestelLijnToe();
}
