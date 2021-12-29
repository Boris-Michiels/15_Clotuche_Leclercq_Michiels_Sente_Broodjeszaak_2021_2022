package model;

import model.database.BroodjesDatabase;
import model.database.DataBaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestelFacade implements Subject
{
    private Bestelling bestelling;
    private BroodjesDatabase broodjesdatabase;
    private DataBaseService dataBaseService;
    private ArrayList<BestelLijn>bestellijnen = new ArrayList<>();
    private HashMap<BestellingEvents, List<Observer>> observers;


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
    public void addObserver(BestellingEvents e,Observer o) {
        observers.get(e).add(o);


    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers(BestellingEvents e) {
        for(Observer o: observers.get(e)){
            o.update(e);
        }

    }
}
