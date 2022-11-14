package LinearDataStructuresExercises;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDeque<E> {
    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;
    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;
        this.size = 0;
    }


    public void add(E element) {
        addLast(element);

    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;
        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;

        int begin = middle - this.size / 2;
        int index = this.head;

        for (int i = begin; index < this.tail; i++) {
            newElements[i] = this.elements[index++];
        }
        this.head = begin;
        this.tail = this.head + this.size - 1;

        return newElements;
    }


    public void offer(E element) {
        addLast(element);
    }


    public void addFirst(E element) {
        if (isEmpty()) {
            addLast(element);
        } else {
            if (this.head == 0) {
                elements = grow();
            }
            this.elements[--this.head] = element;
            this.size++;
        }
    }


    public void addLast(E element) {
        if (isEmpty()) {
            this.elements[tail] = element;
        } else {
            if (this.tail == elements.length - 1) {
                elements = grow();
            }
            this.elements[++tail] = element;
        }
        size++;
    }

    public void push(E element) {
        addFirst(element);
    }


    public void insert(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft(realIndex - 1,element);
        } else {
            insertAndShiftRight(realIndex,element);
        }
    }

    private void insertAndShiftRight(int index,E element) {
        E lastElement = this.get(this.tail);
        for (int i = this.tail; i > index  ; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = lastElement;
        this.addLast(lastElement);
        size++;
    }

    private void insertAndShiftLeft(int index,E element) {
        E firstElement = this.get(head);
        for (int i = this.head; i <= index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = firstElement;
        this.addFirst(firstElement);
        size++;
    }


    public void set(int index, E element) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        this.elements[realIndex] = element;
    }


    public E peek() {

        if (size == 0) {
            return null;
        }

        E element = (E) this.elements[this.head];
        return element;
    }


    public E poll() {
        return removeFirst();
    }


    public E pop() {
        return removeFirst();
    }


    public E get(int index) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);

        return getAt(realIndex);
    }


    public E get(Object object) {
        for (int i = this.head; i <= this.tail; i++) {
            if (object.equals(this.elements[i])) {
                return getAt(i);
            }
        }
        return null;
    }


    public E remove(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);
        this.elements[realIndex] = null;

        size--;

        return this.getAt(realIndex);
    }
    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    private void ensureIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }
    }


    public E remove(Object object) {
        for (int i = this.head; i <= tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = (E) this.elements[i];
                this.elements[i] = null;

                for (int j = i; j < this.tail ; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.removeLast();

                return element;
            }
        }

        return null;
    }


    public E removeFirst() {
        if (!isEmpty()) {
            E element = this.get(this.head);
            this.elements[this.head] = null;
            this.head++;
            this.size--;
            return element;
        }

        return null;
    }


    public E removeLast() {
        if (!isEmpty()) {
            E element = this.get(this.tail);
            this.elements[this.tail] = null;
            this.tail--;
            this.size--;
            return element;
        }
        return null;
    }


    public int size() {
        return this.size;
    }


    public int capacity() {
        return this.elements.length;
    }


    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;
        for (int i = this.head; i <=  this.tail; i++) {
            newElements[index++] = this.elements[i];
        }
        this.elements = newElements;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }
}
