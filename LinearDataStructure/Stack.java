package LinearDataStructure;

import java.util.Iterator;

public class Stack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E element) {
            this.value = element;
        }
    }
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E element) {
        Node<E> toInsert = new Node<>(element);

        toInsert.next = this.top;
        this.top = toInsert;

        this.size++;
    }


    public E pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("its empty");
        }
        Node<E> tmp = top;
        top = tmp.next;
        size--;
        return tmp.value;
    }

    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("its empty");
        }

        return top.value;
    }


    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E value = this.current.value;
                this.current = this.current.next;
                return value;
            }
        };
    }
}
