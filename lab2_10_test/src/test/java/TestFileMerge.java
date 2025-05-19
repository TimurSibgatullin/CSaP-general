import itis.grp403.TimurSibgatullin.FileMerge;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class TestFileMerge {
    static FileMerge fileMerge = new FileMerge();
    @Test
    public void testMerged() throws IOException {
        fileMerge.mergeFiles();
        File merged = new File("merged.bin");
        File expected = new File("expected.bin");

        try (
                FileInputStream fisMerged = new FileInputStream(merged);
                FileInputStream fisExpected = new FileInputStream(expected)
        ) {
            int byteMerged, byteExpected;
            int position = 0;

            while (true) {
                byteMerged = fisMerged.read();
                byteExpected = fisExpected.read();

                // Проверяем конец файла
                if (byteMerged == -1 && byteExpected == -1) {
                    break; // оба файла закончились одновременно — успех
                }

                // Один файл закончился раньше другого
                if (byteMerged != byteExpected) {
                    fail("Файлы отличаются на позиции " + position +
                            ": merged=" + byteMerged + ", expected=" + byteExpected);
                }

                position++;
            }
        }
    }
}
