package LinearDataStructuresExercises;

import java.util.Iterator;

public class ReversedList<E> implements Iterable<E> {

    private Object[] elements;
    private static final int Initial_Capacity = 2;
    private int size;
    private int capacity;
    private int head;

    public ReversedList() {
        this.elements = new Object[Initial_Capacity];
        this.size = 0;
        this.capacity = Initial_Capacity;
        head = 0;
    }

    public void add(E element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.elements[this.size++] = element;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }

        return (E) this.elements[this.size - 1 - index];
    }


    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }

        int elementIndex = this.size -1 - index;

        for (int i = index ; i < this.size - 1; i++) { // ako e elementIndex/ тогава гърми последния тест !!!
            this.elements[i] = this.elements[i + 1];
        }

        this.size--;

    }




    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public Iterator<E> iterator() {

        return  new Iterator<E>() {
            int index = size - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return (E) elements[index--];
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
