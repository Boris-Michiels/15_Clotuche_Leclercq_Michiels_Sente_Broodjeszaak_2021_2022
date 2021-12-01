package utilities;

import model.Broodje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class TekstLoadSaveTemplate <K,V> {
    public final Map<K,V> load(String path) {
        Map<K,V> objects = new HashMap<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dataSet = line.split(",");
                K key = getKey(dataSet);
                V object = makeObject(dataSet);
                objects.put(key, object);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return objects;
    }

    public final void save(String path, List<String[]> objectStrings) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            List<Broodje> broodjes = (ArrayList<Broodje>) map.values();
            for (Broodje b: broodjes) {
                fileWriter.write(b.toTxtLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public abstract K getKey(String[] s);

    public abstract V makeObject(String[] s);
}
