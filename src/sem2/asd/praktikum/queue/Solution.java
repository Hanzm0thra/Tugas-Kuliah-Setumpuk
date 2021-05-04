package sem2.asd.praktikum.queue;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        QueueLinkedList queue = new QueueLinkedList();

        int totalCurrentQueue = scanner.nextInt();
        scanner.nextLine();
        String stuffs = scanner.nextLine();

        String[] convertStuff = stuffs.split(",", -1);

        for (String s: convertStuff) {
            int data = Integer.parseInt(s);
            queue.enqueue(new QueueLinkedList.Node(data));
        }

        int siaStuffs = scanner.nextInt();
        QueueLinkedList.Node siaNode = new QueueLinkedList.Node(siaStuffs);
        queue.enqueue(siaNode);

        int count = 0;
        while(!queue.isEmpty()) {
            if (queue.head.data <= 2) {
               if (queue.head.equals(siaNode)){
                   queue.dequeue();
                   break;
               } else {
                   queue.dequeue();
                   count++;
               }
            } else {
                int tempData = queue.head.data;
                if (queue.head.equals(siaNode)) {
                    siaNode = new QueueLinkedList.Node(tempData - 2);
                    queue.dequeue();
                    queue.enqueue(siaNode);
                } else {
                    queue.dequeue();
                    queue.enqueue(new QueueLinkedList.Node(tempData - 2));
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

class QueueLinkedList {

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

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(Node input) {
        if (size == 0) {
            head = input;
        } else {
            tail.next = input;
        }
        tail = input;
        size++;
    }

    void dequeue() {
        if (size == 0)
            throw new NullPointerException();

        head = head.next;
        size--;
    }
}
