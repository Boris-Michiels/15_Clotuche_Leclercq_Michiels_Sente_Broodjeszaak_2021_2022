package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {
    public static LoadSaveStrategy createLoadSaveStrategy(String loadSaveStrategyString) {
        LoadSaveStrategyEnum loadsavestrategyenum = LoadSaveStrategyEnum.valueOf(loadSaveStrategyString);
        String klassenaam = loadsavestrategyenum.getKlasseNaam();
        LoadSaveStrategy loadSaveStrategy = null;
        try {
            Class loadSaveStrategyClass = Class.forName(klassenaam);
            Object loadSaveStrategyObject = loadSaveStrategyClass.newInstance();
            loadSaveStrategy = (LoadSaveStrategy) loadSaveStrategyObject;
        } catch (Exception e) {
            System.out.println(e);
        }
        return loadSaveStrategy ;
    }
}
