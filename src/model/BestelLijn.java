package model;


import java.util.ArrayList;

public class BestelLijn {
    private String naambroodje;
    private ArrayList<String>namenbeleg = new ArrayList<>();


    public BestelLijn(String naambroodje,ArrayList<String>namenbeleg){
        this.naambroodje=naambroodje;
        this.namenbeleg=namenbeleg;

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
}
