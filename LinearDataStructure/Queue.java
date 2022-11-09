package LinearDataStructure;

import java.util.Iterator;

public class Queue<E>  {


    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E element) {
            this.value = element;
        }
    }

    public Queue() {
        this.head = null;
        this.size = 0;
    }


    public void offer(E element) {

        Node<E> toInsert = new Node<>(element);
        if (this.isEmpty()) {
            this.head = toInsert;

        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toInsert;
        }
        size++;
    }


    public E poll() {
        if (this.isEmpty()) {
            throw new IllegalStateException("its empty");
        }

        Node<E> first = this.head;
        this.head = first.next;

        this.size--;
        return first.value;
    }


    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("its empty");
        }
        return head.value;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                Node<E> elementToReturn = current;
                current = elementToReturn.next;
                return elementToReturn.value;
            }
        };
    }
}
