import itis.grp403.TimurSibgatullin.testFiles.Main1;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain1 {
    @Test
    public void testCountingSort() {
        byte[] inputArray = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        byte[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        byte[] actualSortedArray = Main1.countingSort(inputArray);
        assertArrayEquals(expectedSortedArray, actualSortedArray);
    }
}
