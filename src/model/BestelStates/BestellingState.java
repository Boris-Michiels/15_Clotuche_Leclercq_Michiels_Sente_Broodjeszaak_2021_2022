package model.BestelStates;

import model.Bestelling;

import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class BestellingState {
    private Bestelling bestelling;
    public abstract void voegBestelLijnToe(String broodjenaam);

}
