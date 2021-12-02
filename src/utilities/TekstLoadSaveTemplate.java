package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class TekstLoadSaveTemplate <K,V> {
    public final Map<K,V> load(String path) {
        Map<K,V> products = new HashMap<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dataSet = line.split(",");
                K key = getKey(dataSet);
                V object = makeObject(dataSet);
                products.put(key, object);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return products;
    }

    public final void save(String path, Map<K,V> objects) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            for (V v : objects.values()) {
                fileWriter.write(makeString(v));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public abstract K getKey(String[] s);

    public abstract V makeObject(String[] s);

    public abstract String makeString(V v);
}
