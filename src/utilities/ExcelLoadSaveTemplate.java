package utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class ExcelLoadSaveTemplate <K,V> {
    private ExcelPlugin excelPlugin = new ExcelPlugin();

    public final Map<K,V> load(String path) {
        Map<K,V> objects = new HashMap<>();
        try {
            File file = new File(path);
            ArrayList<ArrayList<String>> result = excelPlugin.read(file);
            for(ArrayList<String> a : result) {
                String[] dataSet = a.toArray(new String[0]);
                K key = getKey(dataSet);
                V object = makeObject(dataSet);
                objects.put(key, object);
            }
        } catch (BiffException | IOException e) {
            System.out.println(e);
        }
        return objects;
    }

    public final void save(String path, Map<K,V> objects) {
        ArrayList<ArrayList<String>> products = new ArrayList<>();
        try {
            File file = new File(path);
            for (V v : objects.values()) {
                products.add(new ArrayList<>(Arrays.asList(makeString(v).split(","))));
            }
            excelPlugin.write(file, products);
        } catch (IOException | BiffException | WriteException e) {
            System.out.println(e);
        }
    }

    public abstract K getKey(String[] s);

    public abstract V makeObject(String[] s);

    public abstract String makeString(V v);
}
