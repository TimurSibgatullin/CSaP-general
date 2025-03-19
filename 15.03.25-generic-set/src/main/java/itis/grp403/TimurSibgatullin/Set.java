package itis.grp403.TimurSibgatullin;

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
        vals[size] = elem;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(T elem) {
        int position = 0;
        boolean fl = false;
        for (int i = 0; i < size; i++) {
            if (elem.equals(vals[i])) {
                fl = true;
                break;
            }
            position++;
        }
        if (fl) {
            T temp = (T) vals[position];
            for (int i = position; i < size; i++) {
                vals[i] = vals[i + 1];
            }
            size--;
            return temp;
        }
        return null;
    }

    @Override
    public T[] getAll() {
        return (T[]) vals;
    }

    @Override
    public boolean contains(T elem) {
        for (int i = 0; i < size; i++) {
            if (elem.equals(vals[i])) {
                return true;
            }
        }
        return false;
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
