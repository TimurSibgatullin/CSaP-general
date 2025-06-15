package itis.grp403.TimurSibgatullin.testFiles;
import java.io.*;

public class Main2 {
    public static int[] countByteFrequencies(String filePath) throws IOException {
    int[] frequencies = new int[256]; // Массив для хранения частот байтов от 0 до 255

    try (FileInputStream fis = new FileInputStream(filePath)) {
        int byteRead;
        while ((byteRead = fis.read()) != -1) {
            frequencies[byteRead]++;
        }
    }

    return frequencies;
}

    public static void printFrequencyDiagram(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            System.out.printf("Byte %03d: %d\n", i, frequencies[i]);
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file"; // Укажите путь к вашему файлу
        try {
            int[] frequencies = countByteFrequencies(filePath);
            printFrequencyDiagram(frequencies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
