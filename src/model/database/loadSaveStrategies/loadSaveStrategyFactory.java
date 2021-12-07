package model.database.loadSaveStrategies;

import model.Product;

public class loadSaveStrategyFactory {
    public static LoadSaveStrategy createLoadSaveStrategy(String loadsavestrategy){
        LoadSaveStrategyEnum loadsavestrategyenum = LoadSaveStrategyEnum.valueOf(loadsavestrategy);
        String klassenaam = loadsavestrategyenum.getKlasseNaam();
        LoadSaveStrategy loadSaveStrategy = null;
        try{
            Class dbClass = Class.forName(klassenaam);
            Object dbObject = dbClass.newInstance();
            loadSaveStrategy = (LoadSaveStrategy) dbObject;

        }
        catch (Exception e){}
        return loadSaveStrategy ;


    }

}
