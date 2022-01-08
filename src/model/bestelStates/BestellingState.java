package model.bestelStates;

import model.Beleg;
import model.BestelLijn;
import model.Bestelling;
import model.Broodje;

import java.util.List;

public interface BestellingState {
    void startBestelling();
    void voegBestelLijnToe(Broodje broodje);
    void addBeleg(Beleg beleg, BestelLijn selectedItem);
    void removeBestelLijn(BestelLijn b);
    void addIdemBestellijn(Broodje broodje, List<Beleg> beleg);
    void afsluiten();
    void annuleren();
    void betalen();
    void zendNaarKeuken();
    void startBereiding();
    void afgewerkt();
}
