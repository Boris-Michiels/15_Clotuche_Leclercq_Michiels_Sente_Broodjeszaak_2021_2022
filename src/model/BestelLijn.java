package model;


import java.util.ArrayList;

public class BestelLijn {
    private String naambroodje;
    private ArrayList<String> namenbeleg = new ArrayList<>();
    private double prijs;

    public BestelLijn(Broodje broodje) {
        this.naambroodje = broodje.getNaam();
        broodje.setVoorraad(broodje.getVoorraad() - 1);
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

    public String getBelegString() {
        StringBuilder out = new StringBuilder();
        for (String s : namenbeleg) {
            out.append(s).append(", ");
        }
        return out.toString().length() > 0 ? out.substring(0, out.toString().length() - 2) : null;
    }

    public void setNaambroodje(String naambroodje) {
        this.naambroodje = naambroodje;
    }

    public void setNamenbeleg(ArrayList<String> namenbeleg) {
        this.namenbeleg = namenbeleg;
    }

    public void addBeleg(Beleg beleg) {
        namenbeleg.add(beleg.getNaam());
        beleg.setVoorraad(beleg.getVoorraad() - 1);
        setPrijs(prijs + beleg.getVerkoopprijs());
    }

    @Override
    public String toString() {
        return naambroodje + " - " + namenbeleg;
    }
}
