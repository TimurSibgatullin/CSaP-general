package itis.grp403.TimurSibgatullin;


import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.GenericList.ListInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransportService {
    private File file;

    public TransportService(String fileName) {
        this.file = new File(fileName);
    }

    public List<Transport> readAll() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<Transport> res = new List<>();
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            res.add(
                switch (str[0]) {
                    case "bus" -> new Bus(str[1], str[2], str[3], str[4]);
                    case "tram" -> new Tram(str[1], str[2], str[3], str[4]);
                    case "trolleybus" -> new Trolleybus(str[1], str[2], str[3], str[4]);
                    default -> throw new IllegalStateException("Unexpected value: " + str[0]);
                }
            );
        }
        sc.close();
        return res;
    }

    public List<Bus> readAllBuses() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<Bus> res = new List<>();
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("bus")) {
                res.add(new Bus(str[1], str[2], str[3], str[4]));
            }
        }
        sc.close();
        return res;
    }

    public List<Tram> readAllTrams() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<Tram> res = new List<>();
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("tram")) {
                res.add(new Tram(str[1], str[2], str[3], str[4]));
            }
        }
        sc.close();
        return res;
    }

    public List<Trolleybus> readAllTrolleys() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<Trolleybus> res = new List<>();
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("trolleybus")) {
                res.add(new Trolleybus(str[1], str[2], str[3], str[4]));
            }
        }
        sc.close();
        return res;
    }
}
