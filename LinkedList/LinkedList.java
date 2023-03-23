package LinkedList;

public class LinkedList {

    // Declare private instance variables
    private Node head;
    private Node tail;
    private int length;

    // Declare a Node inner class
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor for initializing the linked list with a value
    public LinkedList() {
        // Create a new node called newNode with the given value,
        // and point both the head and tail at it
//        Node newNode = new Node(value);
//        head = newNode;
//        tail = newNode;
//        length = 1; // The length of the list is 1
    }

    public void printList() {
        Node temp = head;
        //starting point
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
            //temp.next takes the pointer from the previous,
            // and switches it the next element
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        System.out.println(linkedList.get(2).value);


    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }


    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;

    }

    public Node get(int index) {

        if (length == 0) {
            return null;
        }
        if (index >= length || index < 0) {
            return null;
        }

        Node temp = head;

//        while (counter != index) {
//            temp = temp.next;
//
//            counter++;
//        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);

        if (index >= length || index < 0) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == this.length - 1) {
            append(value);
            return true;
        }

        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {

        if (index >= length || index < 0) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == this.length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

}
