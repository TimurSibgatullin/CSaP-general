package itis.grp403.TimurSibgatullin.GenericList;

public class List<T> implements ListInterface<T> {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(vals[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}
