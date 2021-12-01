package utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ExcelLoadSaveTemplate <K,V>  {
    private ExcelPlugin excelPlugin = new ExcelPlugin();

    public final Map<K,V> load(String path) {
        Map<K,V> objects = new HashMap<>();

        try
        {
            File file = new File(path);
            ArrayList<ArrayList<String>> result = excelPlugin.read(file);

        }
        catch (BiffException | IOException i) {
            System.out.println(i);
        }
        return
    }

    public abstract K getKey(String[] s);

    public abstract V makeObject(String[] s);
}
