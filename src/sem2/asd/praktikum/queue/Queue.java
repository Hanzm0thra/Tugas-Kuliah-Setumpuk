package sem2.asd.praktikum.queue;

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

    public boolean isEmpty() { return size == 0;}

    public void enqueue(int input) {
        Node newNode = new Node(input);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public int dequeue() {
        if (size == 0)
            return 0;

        int current = head.data;
        head = head.next;
        size--;
        return current;
    }

    int peek() {
        return head.data;
    }

    void display() {
        Node helper = head;
        while (tail != null) {
            System.out.println(helper.data);
            helper = helper.next;
        }
    }
}
