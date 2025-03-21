package itis.grp403.TimurSibgatullin;


public class List2Direction<T> implements LinkedListInterface<T>{
    private class Node<T> {
        public T value;
        public Node next;
        public Node prev;
        public Node(T value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void add(T value) {
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            Node current = last;
            current.next = new Node(value);
            current.next.prev = current;
            last = current.next;
        }
        size++;
    }

    public void add(int position, T value) {
        Node a = first;
        for (int i = 1; i < position; ++i) {
            a = a.next;
        }

        Node b = a;
        a = new Node(value);
        a.prev = b.prev;
        a.next = b;
        b.prev = a;
        a.prev.next = a;
        Node current = a;
        while (current.next != null) {
            current = current.next;
        }
        last = current;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int position) throws IndexOutOfBoundsException {
        if (position < size) {
            Node a = first;
            for (int i = 1; i < position; ++i) {
                a = a.next;
            }
            return (T) a.value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = first;
        while (current != null) {
            stringBuilder.append(current.value).append(" ");
            current = current.next;
        }
        return stringBuilder.toString();
    }

    @Override
    public T remove(int position) {
        if (position < 0 || first == null) return null;

        Node current = first;
        for (int i = 0; i < position; ++i) {
            if (current.next == null) return null;
            current = current.next;
        }

        if (current.prev != null) current.prev.next = current.next;
        if (current.next != null) current.next.prev = current.prev;
        if (current == first) first = current.next;
        if (current == last) last = current.prev;

        return (T) current.value;
    }
}
