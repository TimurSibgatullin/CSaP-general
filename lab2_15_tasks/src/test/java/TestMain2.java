import itis.grp403.TimurSibgatullin.testFiles.Main2;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain2 {
    @Test
    public void testCountByteFrequencies() throws IOException {
        File tempFile = File.createTempFile("test", ".tmp");
        tempFile.deleteOnExit();

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(new byte[]{0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5});
        }

        int[] expectedFrequencies = new int[256];
        expectedFrequencies[0] = 3;
        expectedFrequencies[1] = 3;
        expectedFrequencies[2] = 3;
        expectedFrequencies[3] = 3;
        expectedFrequencies[4] = 3;
        expectedFrequencies[5] = 3;

        int[] actualFrequencies = Main2.countByteFrequencies(tempFile.getAbsolutePath());

        assertArrayEquals(expectedFrequencies, actualFrequencies);
    }
}
