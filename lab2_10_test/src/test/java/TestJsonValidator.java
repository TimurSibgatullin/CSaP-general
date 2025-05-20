import itis.grp403.TimurSibgatullin.JsonValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestJsonValidator {
    @Test
    void testJsonValidator() throws IOException {
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            JsonValidator.validateJson(null);});

        Assertions.assertThrowsExactly(FileNotFoundException.class, () -> {
            JsonValidator.validateJson("ghjkhyg.json");});

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            JsonValidator.validateJson("illegal.json");});

        Assertions.assertEquals(0, JsonValidator.validateJson("bookings.json"));
    }
}
