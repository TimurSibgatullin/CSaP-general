package itis.grp403.TimurSibgatullin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        readCSV("Копия med.csv");

    }

    public static HashMap<Integer, ArrayList<String>> readCSV(String filename) {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] headers = br.readLine().split(",");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // -1 сохраняет пустые значения
                Map<String, String> row = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i].trim(), i < values.length ? values[i].trim() : "");
                }

                data.add(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}