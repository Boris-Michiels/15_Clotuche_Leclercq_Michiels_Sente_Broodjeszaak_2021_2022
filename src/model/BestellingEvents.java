package model;

public enum BestellingEvents {
    TOEVOEGEN_BROODJE ("Broodje toegevoegd");

    private String eventName;
    BestellingEvents(String eventName){
        this.eventName=eventName;
    }

    public String getEventName() {
        return this.eventName;
    }


}

