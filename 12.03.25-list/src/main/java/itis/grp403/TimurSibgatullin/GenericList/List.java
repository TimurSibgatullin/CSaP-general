package itis.grp403.TimurSibgatullin.GenericList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class List<T> implements ListInterface<T>, Iterable<T> {
    private Object[] vals;
    private int size;

    public List() {
        this.vals = new Object[10];
        this.size = 0;
    }

    public void add(T element) {
        if (size >= vals.length) {
            grow();
        }
        vals[size++] = element;
    }

    public void add(T element, int position) {
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
        Object[] temp = new Object[(int) (size * 1.5)];
        if (size >= 0) System.arraycopy(vals, 0, temp, 0, size);
        vals = temp;
    }

    public int size() {
        return size;
    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) vals[position];
    }


    public T remove(int position) throws IndexOutOfBoundsException {
        if (position > size-1 || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        T temp = (T) vals[position];
        for (int i = position; i < size; i++) {
            vals[i] = vals[i + 1];
        }
        size--;
        return temp;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1; j++){
                if ((comparator.compare((T) vals[j], (T) vals[j+1])) > 0) {
                    T temp = (T) vals[j];
                    vals[j] = vals[j+1];
                    vals[j+1] = temp;
                };
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(vals[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        int current = 0;
        @Override
        public boolean hasNext() {
            return (current<size);
        }

        @Override
        public T next() {
            if (current<size) {
                return (T) vals[current++];
            } else {
                return null;
            }
        }
    };
}
