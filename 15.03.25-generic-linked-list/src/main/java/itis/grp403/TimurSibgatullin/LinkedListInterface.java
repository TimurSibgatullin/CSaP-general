package itis.grp403.TimurSibgatullin;

public interface LinkedListInterface<T> {
    /**
     * добавляет в конец списка
     * @param value
     */
    void add(T value);

    /**
     * метод добавляет элемент в указаннную позицию
     * @param position
     * @param value
     */
    void add(int position, T value);

    /**
     * возвращает размер списка
     * @return
     */
    int size();

    /**
     * возвращает элемент по индексу
     * @param position
     * @return
     */
    T get(int position) throws IndexOutOfBoundsException;

    //    /**
//     * Удаляет элемент по индексу
//     * @param position
//     * @throws IndexOutOfBoundsException
//     */
    T remove(int position) throws IndexOutOfBoundsException;
}
