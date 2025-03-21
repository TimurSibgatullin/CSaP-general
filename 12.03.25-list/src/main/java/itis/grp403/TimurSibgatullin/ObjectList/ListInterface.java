package itis.grp403.TimurSibgatullin.ObjectList;

public interface ListInterface {
    /**
     * добавляет в конец списка
     * @param element
     */
    void add(Object element);

    /**
     * метод добавляет элемент в указаннную позицию
     * @param element
     */
    void add(Object element, int position);

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
    Object get(int position) throws IndexOutOfBoundsException;

    /**
     * Сортировка списка (asc = true -- по возрастанию)
     */
//    void sort(boolean asc);
//
//    /**
//     * Удаляет элемент по индексу
//     * @param position
//     * @throws IndexOutOfBoundsException
//     */
    Object remove(int position) throws IndexOutOfBoundsException;
}
