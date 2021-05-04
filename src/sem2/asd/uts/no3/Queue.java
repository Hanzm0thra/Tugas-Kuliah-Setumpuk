package sem2.asd.uts.no3;

public class Queue {

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size;

    void enqueue(Node input) {
        if (size == 0) {
            head = input;
        } else {
            tail.next = input;
        }
        tail = input;
        size++;
    }

    int dequeue() {
        if (size == 0)
            return 0;

        int current = head.data;
        head = head.next;
        return current;
    }

    int peek() {
        return head.data;
    }
}
