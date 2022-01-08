package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {
    public static LoadSaveStrategy createLoadSaveStrategy(String loadSaveStrategyString) {
        LoadSaveStrategyEnum loadSaveStrategyEnum = LoadSaveStrategyEnum.valueOf(loadSaveStrategyString);
        String klassenaam = loadSaveStrategyEnum.getKlasseNaam();
        LoadSaveStrategy loadSaveStrategy = null;
        try {
            Class loadSaveStrategyClass = Class.forName(klassenaam);
            Object loadSaveStrategyObject = loadSaveStrategyClass.newInstance();
            loadSaveStrategy = (LoadSaveStrategy) loadSaveStrategyObject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return loadSaveStrategy;
    }
}
