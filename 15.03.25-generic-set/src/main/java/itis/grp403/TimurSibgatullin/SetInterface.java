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
    int length();

    /**
     * Удаляет элемент из множества
     * @param elem
     */
    T remove(T elem);
}
