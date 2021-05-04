package sem2.asd.stack.linkedlist;

import java.util.EmptyStackException;

public class StackLinkedList {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    void pop() {
        if (isEmpty())
            throw new EmptyStackException();

        int result = this.top.data;
        this.top = this.top.next;
        size--;
    }

    void push(Node input) {
        if (size == 0)
            top = input;
        else {
            input.next = top;
            top = input;
        }
        size++;
    }

    int peek() {
        if (size == 0)
            return 0;
        return top.data;
    }
}
