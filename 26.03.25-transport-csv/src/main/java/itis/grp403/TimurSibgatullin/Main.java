package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TransportService transportService = new TransportService("C:\\Users\\timur\\IdeaProjects\\CSaP-general\\26.03.25-transport-csv\\transport.csv");
        List<Transport> transports = transportService.readAll();
        System.out.println(transports.toString());
        TransportPrintService transportPrintService = new TransportPrintService();
        transportPrintService.printParkNumber(transports);
    }
}
