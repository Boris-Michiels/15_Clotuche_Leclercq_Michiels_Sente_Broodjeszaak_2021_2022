package model.database.loadSaveStrategies;

import model.Broodje;
import utilities.ExcelLoadSaveTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class BroodjesExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy {
    @Override
    public Object getKey(String[] s) {
        return s[0];
    }

    @Override
    public Object makeObject(String[] s) {
        return new Broodje(s[0], Double.parseDouble(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
    }

    @Override
    public ArrayList<String> makeStringArray(Object o) {
        return new ArrayList<>(Arrays.asList(((Broodje) o).toTxtLine().split(",")));
    }
}
