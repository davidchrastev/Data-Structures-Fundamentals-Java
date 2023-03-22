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
    public LinkedList(int value) {
        // Create a new node called newNode with the given value,
        // and point both the head and tail at it
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1; // The length of the list is 1
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
        LinkedList linkedList = new LinkedList(4);

        linkedList.printList();
    }
}
