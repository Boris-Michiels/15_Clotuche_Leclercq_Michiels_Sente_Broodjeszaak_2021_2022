package model;

public abstract class Product {
    private String naam;
    private double verkoopprijs;
    private int voorraad, verkocht;

    public Product(String naam, double verkoopprijs, int voorraad, int verkocht) {
        this.naam = naam;
        this.verkoopprijs = verkoopprijs;
        this.voorraad = voorraad;
        this.verkocht = verkocht;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getVerkoopprijs() {
        return verkoopprijs;
    }

    public void setVerkoopprijs(double verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public int getVerkocht() {
        return verkocht;
    }

    public void setVerkocht(int verkocht) {
        this.verkocht = verkocht;
    }



    public String toTxtLine()
    {
        return naam + "," + verkoopprijs + "," + voorraad + "," + verkocht;
    }

    @Override
    public String toString() {
        return naam;
    }
}
