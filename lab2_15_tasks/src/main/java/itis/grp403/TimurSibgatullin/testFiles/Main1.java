package itis.grp403.TimurSibgatullin.testFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main1 {

    public static byte[] readFileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            return buffer;
        }
    }

    public static byte[] countingSort(byte[] array) {
        int[] count = new int[256]; // Массив для хранения частот байтов от 0 до 255

        // Подсчитываем частоту каждого байта
        for (byte b : array) {
            count[b & 0xFF]++;
        }

        // Создаем отсортированный массив
        byte[] sortedArray = new byte[array.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sortedArray[index++] = (byte) i;
                count[i]--;
            }
        }

        return sortedArray;
    }

    public static void writeByteArrayToFile(byte[] array, String outputPath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(array);
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input.txt"; // Путь к входному файлу
        String outputFilePath = "sorted_output.txt"; // Путь к выходному файлу

        try {
            byte[] fileBytes = readFileToByteArray(inputFilePath);
            byte[] sortedBytes = countingSort(fileBytes);
            writeByteArrayToFile(sortedBytes, outputFilePath);
            System.out.println("Файл успешно отсортирован и сохранен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
