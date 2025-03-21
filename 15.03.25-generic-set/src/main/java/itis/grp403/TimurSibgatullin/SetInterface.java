package itis.grp403.TimurSibgatullin;

public interface SetInterface<T> {
    /**
     * Метод добавляет элемент в множество
     * @param elem
     */
    boolean add(T elem);
    /**
     * Метод выводит размер множества
     * @return
     */
    int size();

    /**
     * Удаляет элемент из множества
     * @param elem
     */
    T remove(T elem);

    /**
     * Получить все символы
     * @return
     */
    T[] getAll();

    /**
     * Проверка на наличие элемента
     * @param element
     * @return
     */
    boolean contains(T element);
}
