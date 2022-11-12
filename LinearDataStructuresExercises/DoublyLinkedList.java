package LinearDataStructuresExercises;

import java.util.Iterator;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;


        public Node(E value) {
            this.element = value;
        }
    }

    public DoublyLinkedList() {
    }


    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }


    public void addLast(E element) {
        if (this.size == 0) {
            addFirst(element);
        } else {
            Node<E> newNode = new Node<>(element);
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }


    public E removeFirst() {
        ensureNotEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = this.tail =  null;
        } else {
            Node<E> newHead = this.head.next;
            this.head.next = null;
            this.head = newHead;
        }
        this.size--;
        return element;
    }

    private void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Illegal remove for empty LinkedList");
        }
    }


    public E removeLast() {
        ensureNotEmpty();
        if (this.size == 1) {
            return removeFirst();
        }


        E element = this.tail.element;
        this.tail = this.tail.prev;
        this.tail.next = null;

        this.size--;

        return element;
    }


    public E getFirst() {
        ensureNotEmpty();
        return this.head.element;
    }


    public E getLast() {
<<<<<<< HEAD
        ensureNotEmpty();
        return this.tail.element;
=======
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.element;
>>>>>>> origin/master
    }


    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }



    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
<<<<<<< HEAD
                return current.next == null;
=======
                return current != null;
>>>>>>> origin/master
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
