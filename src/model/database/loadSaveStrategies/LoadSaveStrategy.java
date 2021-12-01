package model.database.loadSaveStrategies;

import java.util.Map;

public interface LoadSaveStrategy <K,V> {
    Map<K,V> load(String path);
    void save(String path, Map<K,V> objects);
}
