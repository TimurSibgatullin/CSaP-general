package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

import java.io.FileNotFoundException;

//1. Описать базовый класс Transport
//2. Описать потомков Bus, Tram, Trolleybus
//3. Реализовать методы
//    - Чтение из файла в список Transport
//    - Чтение из файла в списки по типам
//    - По списку вывести в упорядоченном виде парковые номера и время начала движения
//    - По списку вывести в упорядоченном виде номера маршрутов, время начала и окончнания движения маршрута
//    - По списку вывести кол-во разных маршрутов
//    - По списку вывести кол-во разных транспортных средств
//    - По списку вывести номер маршрута и кол-во транспортных средств на нем

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TransportService transportService = new TransportService("C:\\Users\\timur\\IdeaProjects\\CSaP-general\\26.03.25-transport-csv\\transport.csv");
        List<Transport> transports = transportService.readAll();
        System.out.println(transports.toString());
        TransportPrintService transportPrintService = new TransportPrintService();
        transportPrintService.printParkNumber(transports);
    }
}
