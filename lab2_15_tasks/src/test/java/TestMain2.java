import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain2 {
    @Test
    public void testCopyBytes() throws IOException {
        // Тестовые данные
        String inputText = "Пример текста для копирования.";
        byte[] expectedBytes = inputText.getBytes();

        // Создаем ByteArrayInputStream и ByteArrayOutputStream
        ByteArrayInputStream bais = new ByteArrayInputStream(inputText.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Выполняем копирование
        int byteRead;
        while ((byteRead = bais.read()) != -1) {
            baos.write(byteRead);
        }

        // Получаем фактические байты из ByteArrayOutputStream
        byte[] actualBytes = baos.toByteArray();

        // Проверяем, что фактические байты совпадают с ожидаемыми
        assertArrayEquals(expectedBytes, actualBytes);
    }
}
