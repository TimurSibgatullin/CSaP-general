import itis.grp403.TimurSibgatullin.testFiles.Main1;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain1 {

    @Test
    public void testCountingSort() {
        // Тестовые данные
        byte[] inputArray = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        byte[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Выполняем сортировку
        byte[] actualSortedArray = Main1.countingSort(inputArray);

        // Проверяем, что фактический отсортированный массив совпадает с ожидаемым
        assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    @Test
    public void testCountingSortWithDuplicates() {
        // Тестовые данные с дубликатами
        byte[] inputArray = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9, 3, 5, 1};
        byte[] expectedSortedArray = {1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 10};

        // Выполняем сортировку
        byte[] actualSortedArray = Main1.countingSort(inputArray);

        // Проверяем, что фактический отсортированный массив совпадает с ожидаемым
        assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    @Test
    public void testCountingSortWithNegativeBytes() {
        // Тестовые данные с отрицательными байтами
        byte[] inputArray = {-1, -5, 3, 0, 127, -128, 10};
        byte[] expectedSortedArray = {-128, -5, -1, 0, 3, 10, 127};

        // Выполняем сортировку
        byte[] actualSortedArray = Main1.countingSort(inputArray);

        // Проверяем, что фактический отсортированный массив совпадает с ожидаемым
        assertArrayEquals(expectedSortedArray, actualSortedArray);
    }
}
