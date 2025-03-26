package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;

public class TransportPrintService {
    public void printParkNumber(List<Transport> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + list.get(i).getWorkTimeBegin());
        }
    }
}
