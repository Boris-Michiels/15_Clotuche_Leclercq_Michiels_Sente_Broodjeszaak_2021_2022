package utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.Product;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ExcelLoadSaveTemplate <K,V>  {
    private ExcelPlugin excelPlugin = new ExcelPlugin();

    public final Map<K,V> load(String path) {
        Map<K,V> objects = new HashMap<>();
        try
        {
            File file = new File(path);
            ArrayList<ArrayList<String>> result = excelPlugin.read(file);
            for(ArrayList<String> a : result)
            {
                String[] dataSet = a.toArray(new String[0]);
                K key = getKey(dataSet);
                V object = makeObject(dataSet);
                objects.put(key,object);
            }
        }
        catch (BiffException | IOException i) {
            System.out.println(i);
        }
        return objects;
    }

    public final void save(String path, Map<K,V> objects)
    { try
        {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            List<V> products = (ArrayList<V>) objects.values();
            for (V v : products)
            {
                fileWriter.write(((Product) v).toTxtLine());
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public abstract K getKey(String[] s);

    public abstract V makeObject(String[] s);
}
