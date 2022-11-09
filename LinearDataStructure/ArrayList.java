package LinearDataStructure;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> {
    private Object[] elements;
    private static final int Initial_Capacity = 2;
    private int size;
    private int capacity;
    public ArrayList() {
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

    public boolean add(int index, E element) {
        if (index < 0 || index > this.size) {
            return false;
        }
        shiftRight(index);

        this.elements[index] = element;
        return true;
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }

        return (E) this.elements[index];
    }


    public E set(int index, E element)  {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Not valid index");
        }
        Object previousElement = this.elements[index];

        this.elements[index] = element;

        return (E) previousElement;
    }


    public E remove(int index) {
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
    private void shrink() {
        if (this.size > this.capacity / 3) {
            return;
        }
        this.capacity /= 2;

        this.elements = Arrays.copyOf(this.elements, this.capacity);

    }


    public int size() {
        return size;
    }


    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }


    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
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
    private void shiftRight(int index) {
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        size++;
    }
}
