package model;


import java.util.ArrayList;

public class BestelLijn {
    private String naambroodje;
    private ArrayList<String> namenbeleg = new ArrayList<>();
    private double prijs;

    public BestelLijn(Broodje broodje) {
        this.naambroodje = broodje.getNaam();
        setPrijs(broodje.getVerkoopprijs());
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getNaambroodje() {
        return naambroodje;
    }

    public ArrayList<String> getNamenbeleg() {
        return namenbeleg;
    }

    public void setNaambroodje(String naambroodje) {
        this.naambroodje = naambroodje;
    }

    public void setNamenbeleg(ArrayList<String> namenbeleg) {
        this.namenbeleg = namenbeleg;
    }

    public void addBeleg(String beleg) {
        namenbeleg.add(beleg);
    }

    @Override
    public String toString() {
        return naambroodje + " - " + namenbeleg;
    }
}
