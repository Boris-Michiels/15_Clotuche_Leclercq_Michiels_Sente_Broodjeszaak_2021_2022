package model;

public enum BestellingEvents {
    NIEUWE_BESTELLING ("Nieuwe bestelling"),
    TOEVOEGEN_BROODJE ("Broodje toegevoegd"),
    TOEVOEGEN_BELEG ("Beleg toegevoegd"),
    VERWIJDEREN_BESTELLIJN ("Bestellijn verwijderd");

    private String eventDescription;
    BestellingEvents(String eventDescription){
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() {
        return this.eventDescription;
    }


}

