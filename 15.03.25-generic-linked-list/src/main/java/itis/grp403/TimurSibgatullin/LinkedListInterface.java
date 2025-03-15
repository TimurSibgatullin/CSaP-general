package itis.grp403.TimurSibgatullin;

public class LinkedListInterface<T> {
    /**
     * добавляет в конец списка
     * @param element
     */
    void add(T value);

    /**
     * метод добавляет элемент в указаннную позицию
     * @param element
     */
    void add(int position, T value);

    /**
     * возвращает размер списка
     * @return
     */
//    int size();

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

}
