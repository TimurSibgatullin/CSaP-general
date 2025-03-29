package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

import java.util.Comparator;

public class TransportPrintService {
    public void printParkNumber(List<? extends Transport> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + list.get(i).getWorkTimeBegin());
        }
    }

    public <T extends Transport> void printParkNumber2(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getNumber().compareTo(o2.getNumber());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + " " + list.get(i).getWorkTimeBegin());
        }
    }
}
