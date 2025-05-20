package itis.grp403.TimurSibgatullin;

public class InsertionSort {
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            sb.append(arr[i] + " ");
        return sb.toString();
    }

}
