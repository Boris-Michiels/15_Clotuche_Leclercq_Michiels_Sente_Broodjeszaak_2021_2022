package model.database;

import model.Broodje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BroodjesTekstLoadSave extends TekstLoadSave {
    @Override
    public Map<String, Broodje> ReadFile(String path) {
        HashMap<String, Broodje> map = new HashMap<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dataSet = line.split(",");
                map.put(dataSet[0], new Broodje(dataSet[0], Double.parseDouble(dataSet[1]), Integer.parseInt(dataSet[2]), Integer.parseInt(dataSet[3])));
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
            List<Broodje> broodjes = (ArrayList<Broodje>) map.values();
            for (Broodje b: broodjes) {
                fileWriter.write(b.toTxtLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
