package itis.grp403.TimurSibgatullin.testFiles;
import java.io.*;

public class Main2 {
    public static int[] countByteFrequencies(String filePath) throws IOException {
    int[] frequencies = new int[256];

    try (FileInputStream fis = new FileInputStream(filePath)) {
        int byteRead;
        while ((byteRead = fis.read()) != -1) {
            frequencies[byteRead]++;
        }
    }

    return frequencies;
}

    public static void printFrequencyDiagram(int[] frequencies) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > 0) {
                    System.out.print("+");
                    frequencies[i]--;
                    flag = true;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String filePath = "input.txt";
        try {
            int[] frequencies = countByteFrequencies(filePath);
            printFrequencyDiagram(frequencies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
