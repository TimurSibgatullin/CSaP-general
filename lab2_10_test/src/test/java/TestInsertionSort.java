import itis.grp403.TimurSibgatullin.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInsertionSort {
    @Test
    public void testInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        int[] expected = {5, 6, 11, 12, 13};
        int[] source = {12, 11, 13, 5, 6};
        int[] res = insertionSort.sort(source);
        Assertions.assertArrayEquals(expected, res, "пупупу");
    }
}
