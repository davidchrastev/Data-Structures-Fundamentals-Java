package LinearDataStructure;

import java.util.Iterator;

public class SinglyLinkedList<E>  {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;


        public Node(E element) {
            this.value = element;
            next = null;
        }
    }

    public SinglyLinkedList() {
        this.size = 0;
        head = null;
    }


    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);
        nextElement.next = this.head;
        this.head = nextElement;
        this.size++;
    }


    public void addLast(E element) {
        Node<E> lastElement = new Node<>(element);



        if (isEmpty()) {
            this.head = lastElement;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = lastElement;
        }

        size++;

    }


    public E removeFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        Node<E> toRemove = this.head;

        this.head = toRemove.next;
        size--;

        return toRemove.value;
    }


    public E removeLast() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        if (this.size == 1) {
            E value = this.head.value;
            this.head = null;
            size--;
            return value;
        }

        Node<E> toRemove = this.head;
        Node<E> current = this.head.next;
        while (toRemove.next != null) {
            current = toRemove;
            toRemove = toRemove.next;
        }
        current.next = null;


        size--;
        return toRemove.value;
    }


    public E getFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.head.value;
    }


    public E getLast() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
