import itis.grp403.TimurSibgatullin.testFiles.Main3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestMain3 {
    @Test
    void testCopy() {
        byte src[] = {-34, 83, -56, 90, 3, -4};
        ByteArrayInputStream bais = new ByteArrayInputStream(src);
        ByteArrayOutputStream baos = Main3.copy(bais);
        byte dst[] = baos.toByteArray();
        Assertions.assertArrayEquals(src, dst);
    }
}
