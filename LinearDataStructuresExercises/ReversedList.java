package LinearDataStructuresExercises;

import java.util.Iterator;

public class ReversedList<E> {

    private Object[] elements;
    private static final int Initial_Capacity = 2;
    private int size;
    private int capacity;

    public ReversedList() {
        this.elements = new Object[Initial_Capacity];
        this.size = 0;
        this.capacity = Initial_Capacity;
    }

    public boolean add(E element) {
        if (this.size == this.capacity) {
            resize();
        }

        this.elements[this.size++] = element;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }

        return (E) this.elements[index];
    }


    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }
        Object previousElement = this.elements[index];
        size--;
        shiftLeft(index);

        return (E) previousElement;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }


    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = size - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return get(index--);
            }
        };

    }

    private void resize() {
        this.capacity *= 2;
        Object[] tmp = new Object[this.capacity];

        for (int i = 0; i < this.elements.length; i++) {
            tmp[i] = this.elements[i];
        }
        this.elements = tmp;
    }


}
