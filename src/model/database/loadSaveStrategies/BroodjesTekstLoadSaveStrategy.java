package model.database.loadSaveStrategies;

import model.Broodje;
import utilities.TekstLoadSaveTemplate;

public class BroodjesTekstLoadSaveStrategy extends TekstLoadSaveTemplate {
    @Override
    public Object getKey(String[] s) {
        return s[0];
    }

    @Override
    public Object makeObject(String[] s) {
        return new Broodje(s[0], Double.parseDouble(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
    }
}
