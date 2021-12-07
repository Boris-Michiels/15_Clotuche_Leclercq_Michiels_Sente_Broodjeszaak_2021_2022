package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    BROODJESEXCEL("Broodjes Excel Load Save", "model.database.BroodjesExcelLoadSaveStrategy"),
    BROODJESTEKST("Broodjes Tekst Load Save", "model.database.BroodjesTekstLoadSaveStrategy"),
    BELEGEXCEL("Beleg Excel Load Save", "model.database.BelegExcelLoadSaveStrategy"),
    BELEGTEKST("Beleg Tekst Load Save", "model.database.BelegTekstLoadSaveStrategy");

    private final String omschrijving, klasseNaam;

    LoadSaveStrategyEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }
}
