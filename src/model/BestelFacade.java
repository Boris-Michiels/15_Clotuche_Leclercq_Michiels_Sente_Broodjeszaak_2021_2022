package model;

import model.database.BroodjesDatabase;
import model.database.DataBaseService;

import java.util.ArrayList;
import java.util.List;

public class BestelFacade implements Subject
{
    private Bestelling bestelling;
    private BroodjesDatabase broodjesdatabase;
    private DataBaseService dataBaseService;
    private ArrayList<BestelLijn>bestellijnen = new ArrayList<>();


    public void voegBestelLijnToe(String broodjenaam,ArrayList<String>belegnamen) {
        bestelling.voegBestelLijnToe(broodjenaam,belegnamen);

    }

    public ArrayList<BestelLijn> getBestellijnen() {
        return bestellijnen;
    }

    public void setBestellijnen(ArrayList<BestelLijn> bestellijnen) {
        this.bestellijnen = bestellijnen;
    }
    public List<Broodje> getVooraadLijstBroodjes(){
        return dataBaseService.getAvailableBrood();
    }

    @Override
    public void addObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers(BestellingEvents e , Observer o ) {

    }
}
