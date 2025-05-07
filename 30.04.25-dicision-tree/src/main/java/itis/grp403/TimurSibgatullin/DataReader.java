package itis.grp403.TimurSibgatullin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static void main(String args[]) {
        DataReader reader = new DataReader();
        List<RawRow> rawRows = reader.readFile("Копия med.csv");
        reader.clearData(rawRows);
//        reader.convertor(rawRows);


    }

    public List<RawRow> readFile(String fileName) {
        List<RawRow> result = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) return result;
        try (
//            InputStream is = new FileInputStream(file);
//            Reader reader = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(reader);
            BufferedReader br = new BufferedReader(new FileReader(file))
        ) {
            while (br.ready()) {
                String[] data = br.readLine().split(";");
                RawRow rawRow = new RawRow();
                if (data.length < 24) continue;
                rawRow.setRiskScoreCVRM(data[6]);
                rawRow.setMdrd(data[7]);
                rawRow.setGlucoseFasting(data[9]);
                rawRow.setTotalCholesterol(data[11]);
                rawRow.setSystolicBloodPressure(data[13]);
                rawRow.setDiastolicBloodPressure(data[14]);
                rawRow.setBmi(data[16]);
                rawRow.setPsCVRM(data[18]);
                rawRow.setSmokingStatus(data[19]);
                rawRow.setAge(data[22]);
                rawRow.setHypertension(data[23]);
                result.add(rawRow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Row> clearData(List<RawRow> raw) {
    raw.stream()
            .filter(r -> !r.badRecord())
            .map(r -> new Row()).toList();
    return null;
    }

    public Row convertor(RawRow raw) {
        Row r = new Row();
        r.setRiskScoreCVRM(Integer.parseInt(raw.getRiskScoreCVRM()));
        r.setMdrd(Integer.parseInt(raw.getMdrd()));
        r.setRiskScoreCVRM(Integer.parseInt(raw.getRiskScoreCVRM()));       // Integer
        r.setMdrd(Integer.parseInt(raw.getMdrd()));                         // Integer
        r.setGlucoseFasting(Float.parseFloat(raw.getGlucoseFasting()));    // Float
        r.setTotalCholesterol(Float.parseFloat(raw.getTotalCholesterol())); // Float
        r.setSystolicBloodPressure(Integer.parseInt(raw.getSystolicBloodPressure()));   // Integer
        r.setDiastolicBloodPressure(Integer.parseInt(raw.getDiastolicBloodPressure())); // Integer
        r.setBmi(Integer.parseInt(raw.getBmi()));                           // Integer
        r.setPsCVRM(raw.getPsCVRM());                                       // String
        r.setSmokingStatus(raw.getSmokingStatus());                         // String
        r.setAge(Integer.parseInt(raw.getAge()));                           // Integer
        r.setHypertension(raw.getHypertension());
        return null;
    }

//    public void tree() {
//        Node root = new Node();
//        Node[] tree = new Node[63];
//
//        for (int i = 0; i < tree.length; ++i) {
//            tree[i].setFunction(
//                    r -> tree.
//            )
//        }
//    }
}
