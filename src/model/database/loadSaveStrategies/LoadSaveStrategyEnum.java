package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    BROODJESEXCEL("src/bestanden/broodjes.xls", "model.database.loadSaveStrategies.BroodjesExcelLoadSaveStrategy"),
    BROODJESTEKST("src/bestanden/broodjes.txt", "model.database.loadSaveStrategies.BroodjesTekstLoadSaveStrategy"),
    BELEGEXCEL("src/bestanden/beleg.xls", "model.database.loadSaveStrategies.BelegExcelLoadSaveStrategy"),
    BELEGTEKST("src/bestanden/beleg.txt", "model.database.loadSaveStrategies.BelegTekstLoadSaveStrategy");

    private final String filePath, klasseNaam;

    LoadSaveStrategyEnum(String filePath, String klasseNaam) {
        this.filePath = filePath;
        this.klasseNaam = klasseNaam;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }
}
