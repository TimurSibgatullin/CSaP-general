package itis.grp403.TimurSibgatullin.testFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//1. Считать файл в масcив (использовать FileInputStream ), отсортировать массив байт подсчетом,
//записать в новый файл. Для сортировки написать тест.

public class Main1 {
    public static byte[] readFileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            return buffer;
        }
    }

    public static byte[] countingSort(byte[] array) {
        int[] count = new int[256];
        for (byte b : array) {
            count[b & 0xFF]++;
        }

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
        String inputFilePath = "input.txt";
        String outputFilePath = "sorted_output.txt";

        try {
            byte[] fileBytes = readFileToByteArray(inputFilePath);
            byte[] sortedBytes = countingSort(fileBytes);
            writeByteArrayToFile(sortedBytes, outputFilePath);
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
