package model.database;

import java.util.Map;

public abstract class TekstLoadSave {
    public abstract Map ReadFile(String path);

    public abstract void WriteFile(String path, Map products);
}
