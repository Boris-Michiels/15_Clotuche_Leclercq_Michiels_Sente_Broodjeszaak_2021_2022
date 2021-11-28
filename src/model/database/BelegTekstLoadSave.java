package model.database;

import model.Beleg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BelegTekstLoadSave extends TekstLoadSave {
    @Override
    public Map<String, Beleg> ReadFile(String path) {
        HashMap<String, Beleg> map = new HashMap<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dataSet = line.split(",");
                map.put(dataSet[0], new Beleg(dataSet[0], Double.parseDouble(dataSet[1]), Integer.parseInt(dataSet[2]), Integer.parseInt(dataSet[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return map;
    }

    @Override
    public void WriteFile(String path, Map map) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            List<Beleg> beleg = (ArrayList<Beleg>) map.values();
            for (Beleg b: beleg) {
                fileWriter.write(b.toTxtLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
