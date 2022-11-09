package representation;

import java.util.Arrays;

public class ArrayStorage<T> {
    private final int INITIAL_CAPACITY = 4;

    private T[] elements;
    private int index;

    private int countElements;

    public ArrayStorage() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.index = 0;
    }

    public boolean add(T element) {
        if (size() == 0) {
            elements = (T[]) new Object[INITIAL_CAPACITY];
            index = 0;
        }
        add(element, index++);
         countElements++;
        return true;
    }

    private void add(T element, int index) {

        if (index == this.elements.length) {
            elements = grow();
        }
        this.elements[index] = element;
    }

    public T[] grow() {
       return elements = Arrays.copyOf(elements, elements.length * 2);
    }

    // TODO: Implement additional operations like: remove(int element), contains(int element) and more

    public void remove(T element) {
        boolean refactor = false;
        for (int i = 0; i <= elements.length - 1; i++) {
            if (elements[i] == element) {
                elements[i] = element;
                refactor = true;
            }
            if (refactor) {
                if (i == elements.length - 1) {
                    elements = Arrays.copyOf(elements, elements.length - 1);
                    countElements--;
                    return;
                } else {
                    elements[i] = elements[i + 1];
                }
            }
        }
    }
    public int size() {
        return countElements;
    }

    public int getElement(int index) {
        return (int) elements[index];
    }
    public boolean contains(T element) {
        for (T t : elements) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

}
