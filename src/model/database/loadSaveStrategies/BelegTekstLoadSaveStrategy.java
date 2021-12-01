package model.database.loadSaveStrategies;

import model.Beleg;
import utilities.TekstLoadSaveTemplate;

public class BelegTekstLoadSaveStrategy extends TekstLoadSaveTemplate {
    @Override
    public Object getKey(String[] s) {
        return s[0];
    }

    @Override
    public Object makeObject(String[] s) {
        return new Beleg(s[0], Double.parseDouble(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
    }
}
