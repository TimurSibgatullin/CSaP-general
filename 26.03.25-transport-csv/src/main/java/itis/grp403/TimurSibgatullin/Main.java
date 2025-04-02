package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        1. Описать базовый класс Transport
//        2. Описать потомков Bus, Tram, Trolleybus
//        3. Реализовать методы
//                + Чтение из файла в список Transport
//                + Чтение из файла в списки по типам
        //        + По списку вывести в упорядоченном виде парковые номера и время начала движения
//                + По списку вывести в упорядоченном виде номера маршрутов, время начала и окончания движения маршрута
//                + По списку вывести кол-во разных маршрутов
        //        + По списку вывести кол-во разных транспортных средств
//                + По списку вывести номер маршрута и кол-во транспортных средств на нем

        TransportService transportService = new TransportService("C:\\Users\\timur\\IdeaProjects\\CSaP-general\\26.03.25-transport-csv\\transport.csv");
        //                + Чтение из файла в список Transport
        List<Transport> transports = transportService.readAll();
        System.out.println(transports);
//                + Чтение из файла в списки по типам
        List<Bus> buses = transportService.readAllBuses();
        System.out.println(buses);
//                + Чтение из файла в списки по типам
        List<Tram> trams = transportService.readAllTrams();
        System.out.println(trams);
//                + Чтение из файла в списки по типам
        List<Trolleybus> trolleybuses = transportService.readAllTrolleys();
        System.out.println(trolleybuses);
        //        + По списку вывести в упорядоченном виде парковые номера и время начала движения
        TransportPrintService transportPrintService2 = new TransportPrintService();
        transportPrintService2.printSortedParkNumber(transports);
//                + По списку вывести в упорядоченном виде номера маршрутов, время начала и окончания движения маршрута
        transportPrintService2.printSortedRouteNumber(transports);
//                + По списку вывести кол-во разных маршрутов
        transportPrintService2.RoutesCounter(transports);
        //        + По списку вывести кол-во разных транспортных средств
        transportPrintService2.TypesCounter(transports);
//                + По списку вывести номер маршрута и кол-во транспортных средств на нем
        transportPrintService2.DifferentTransport(transports);
    }
}
