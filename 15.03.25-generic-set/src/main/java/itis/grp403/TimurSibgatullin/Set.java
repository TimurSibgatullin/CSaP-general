package itis.grp403.TimurSibgatullin;

import java.util.concurrent.TransferQueue;

public class Set<T> implements SetInterface<T> {
    private Object[] vals;
    private int size;
    public Set() {
        this.vals = new Object[10];
        this.size = 0;
    }
    @Override
    public boolean add(T elem) {
        if (size == vals.length) {
            grow();
        }
        for (Object i : vals) {
            if (elem.equals(i)) {
                return false;
            }
        }
        vals[size] = (T) elem;
        size++;
        return true;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T remove(T elem) {
        int position = 0;
        for (int i = 0; i < size; position++) {
            if (elem.equals(i)) {
                break;
            }
        }
        T temp = (T) vals[position];
        for (int i = position; i < size; i++) {
            vals[i] = vals[i + 1];
        }
        size--;
        return temp;
    }

    private void grow() {
        Object[] temp = new Object[(int) (size * 1.5)];
        if (size >= 0) System.arraycopy(vals, 0, temp, 0, size);
        vals = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(vals[i]).append(" ");
        }
        return sb.toString();
    }
}
