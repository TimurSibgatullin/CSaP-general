import itis.grp403.TimurSibgatullin.FileMerge;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileMerge {
    static FileMerge fileMerge = new FileMerge();
    @Test
    public void testFirstPartOfMergedMatchesOriginal() throws IOException {
        fileMerge.mergeFiles();
        String originalFile1 = "pushkin.txt";
        String originalFile2 = "Вопросы-по-геометрии-2025.docx";
        String mergedFile = "merged.bin";

        //считываем объединённый целиком
        byte[] allMergedBytes = readBytes(mergedFile);

        //считываем пушкина
        byte[] originalBytes1 = readBytes(originalFile1);

        //считываем пушкина из объединённого
        byte[] mergedBytes1 = readBytes(mergedFile, 0, originalBytes1.length);

        //считываем бинарник
        byte[] originalBytes2 = readBytes(originalFile2);

        //считываем бинарник из объединённого
        byte[] mergedBytes2 = readBytes(mergedFile, originalBytes1.length, originalBytes2.length);

        assertEquals(allMergedBytes.length, (originalBytes1.length + originalBytes2.length), "Итоговый размер не равен сумме двух исходных");
        assertArrayEquals(originalBytes1, mergedBytes1, "Начало merged.bin не совпадает с pushkin.txt");
        assertArrayEquals(originalBytes2, mergedBytes2, "Конец merged.bin не совпадает с Вопросы-по-геометрии-2025.docx");
    }

    private byte[] readBytes(String path) throws IOException {
        try (InputStream is = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toByteArray();
        }
    }

    private byte[] readBytes(String path, int start, int lengthToRead) throws IOException {
        try (InputStream is = new FileInputStream(path)) {
            is.skip(start);
            byte[] buffer = new byte[lengthToRead];
            int totalRead = 0;
            while (totalRead < lengthToRead) {
                int read = is.read(buffer, totalRead, lengthToRead - totalRead);
                if (read == -1) break; // файл меньше, чем ожидалось
                totalRead += read;
            }
            return buffer;
        }
    }
}
