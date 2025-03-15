package itis.grp403.TimurSibgatullin.IntegerList;

public class List implements ListInterface {
    private Integer[] vals;
    private int size;

    public List() {
        this.vals = new Integer[10];
        this.size = 0;
    }

    public void add(Integer element) {
        if (size >= vals.length) {
            grow();
        }
        vals[size++] = element;
    }

    public void add(Integer element, int position) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == vals.length) {
            grow();
        }
        for (int i = size; i != position; i--) {
            vals[i] = vals[i-1];
        }
        vals[position] = element;
        size++;

    }

    private void grow() {
        Integer[] temp = new Integer[(int) (size * 1.5)];
        for (int i = 0; i < size; i++) {
            temp[i] = vals[i];
        }
        vals = temp;
    }

    public int size() {
        return size;
    }

    public Integer get(int position) throws IndexOutOfBoundsException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        return vals[position];
    }

    public void sort(boolean asc) {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size - 1); j++) {
                    if (((vals[j] > vals[j+1]) && asc) || ((vals[j] < vals[j+1]) && !asc)) {
                        Integer temp = vals[j+1];
                        vals[j+1] = vals[j];
                        vals[j] = temp;
                }
            }
        }
    }

    public Integer remove(int position) throws IndexOutOfBoundsException {
        if (position > size-1 || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        Integer temp = vals[position];
        for (int i = position; i < size; i++) {
            vals[i] = vals[i + 1];
        }
        size--;
        return temp;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += vals[i] + " ";
        }
        return res;
    }
}
