package model;


import java.util.ArrayList;

public class BestelLijn {
    private String naambroodje;
    private ArrayList<String> namenbeleg = new ArrayList<>();

    public BestelLijn(String naambroodje) {
        this.naambroodje = naambroodje;
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
