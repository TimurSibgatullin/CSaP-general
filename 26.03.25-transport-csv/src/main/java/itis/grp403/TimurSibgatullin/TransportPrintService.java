package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

import java.util.Comparator;

public class TransportPrintService {
    public void printParkNumber(List<? extends Transport> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + list.get(i).getWorkTimeBegin());
        }
    }

    public <T extends Transport> void printSortedParkNumber(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getNumber().compareTo(o2.getNumber());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getNumber() + " " + list.get(i).getWorkTimeBegin() + "\t");
        }
        System.out.println();
    }

    public <T extends Transport> void printSortedRouteNumber(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getRouteNumber().compareTo(o2.getRouteNumber());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getRouteNumber() + " " + list.get(i).getWorkTimeBegin() + " " + list.get(i).getWorkTimeEnd() + "\t");
        }
        System.out.println();
    }

    public void RoutesCounter(List<Transport> transport) {
        Set<String> routes = new Set<>();
        for (int i = 0; i < transport.size(); i++) {
            routes.add(transport.get(i).getRouteNumber());
        }
        System.out.println(routes.size());
    }

    public void TypesCounter(List<Transport> transport) {
        Set<Object> routes = new Set<>();
        for (int i = 0; i < transport.size(); i++) {
            List<String> temp = new List<>();
            temp.add(transport.get(i).getClass().getName());
            temp.add(transport.get(i).getNumber());
            routes.add(temp);
        }
        System.out.println(routes.size());
    }

    public void DifferentTransport(List<Transport> transport) {
        Set<Object> routes = new Set<>();
        for (int i = 0; i < transport.size(); i++) {
            List<String> temp = new List<>();
            temp.add(transport.get(i).getClass().getName());
            temp.add(transport.get(i).getNumber());
            routes.add(temp);
        }
        System.out.println(routes.size());
    }
}
