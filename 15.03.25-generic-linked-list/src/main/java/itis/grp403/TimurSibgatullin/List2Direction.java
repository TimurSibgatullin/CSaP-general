package itis.grp403.TimurSibgatullin;


public class List2Direction<T> implements LinkedListInterface<T>{
    public class Node<T> {
        public T value;
        public Node next;
        public Node prev;
        public Node(T value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;

    public void add(T value) {
        if (first == null) {
            first = new Node(value);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
            current.next.prev = current;
            last = current.next;
        }
    }

    public void add(int position, T value) {
        Node a = first;
        for (int i = 1; i < position; ++i) {
            a = a.next;
        }
        //return false;

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
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = first;
        while (current != null) {
            stringBuilder.append(current.value);
            current = current.next;
        }
        return stringBuilder.toString();
    }

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

        return current.value;
    }
}
