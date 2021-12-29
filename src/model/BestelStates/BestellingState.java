package model.BestelStates;

import model.Bestelling;
import model.Broodje;

import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class BestellingState {
    private Bestelling bestelling;
    public abstract void voegBestelLijnToe(Broodje broodje);

}
