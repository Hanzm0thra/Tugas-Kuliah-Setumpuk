package sem2.asd.queue;

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

    boolean isEmpty() {return size == 0;}

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

    void reEnqueue() {
        int dequeueNode = dequeue();
        enqueue(new Node(dequeueNode));
    }

    void display() {
        Node helper = head;
        while (helper != null) {
            System.out.println(helper.data);
            helper = helper.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(new Queue.Node(1));
        queue.enqueue(new Queue.Node(2));
        queue.enqueue(new Queue.Node(4));
        queue.enqueue(new Queue.Node(5));

        int input = 0;
        int earlyHead = queue.peek();


        while (!queue.isEmpty()) {
            if (queue.head.data > input) {
                queue.enqueue(new Queue.Node(input));
                break;
            }
            queue.reEnqueue();
        }
        while (queue.head.data != earlyHead) {
            queue.reEnqueue();
        }


        queue.display();
    }
}
