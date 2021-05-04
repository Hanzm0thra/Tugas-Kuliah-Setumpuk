package sem2.asd.praktikum.dllc;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLLC linkedList = new DLLC();

        int sizeOfLinkedList = scanner.nextInt();
        scanner.nextLine();
        String direction = scanner.next();
        int step = scanner.nextInt();

        for (int i = 0; i < sizeOfLinkedList; i++) {
            linkedList.addLast(new DLLC.Node(scanner.nextInt()));
        }

        if (direction.equals("kanan")) {
            if (step >= 0) {
                linkedList.shiftingRight(step);
            } else {
                int tempStep = step * -1;
                linkedList.shiftingLeft(tempStep);
            }
        } else if (direction.equals("kiri")){
            if (step >= 0) {
                linkedList.shiftingLeft(step);
            } else {
                int tempStep = step * -1;
                linkedList.shiftingRight(tempStep);
            }
        }

        linkedList.displayMiddleDLLC();
    }
}

class DLLC {
    public static class Node {
        int data;
        Node next;
        Node prev;

        //constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;
    private int size = 0;

    private boolean isEmpty() {
        return (size == 0);
    }

    public void addLast(Node input) {
        if (isEmpty()) {
            head = input;
        } else {
            input.prev = tail;
            tail.next = input;
        }
        tail = input;
        tail.next = head;
        head.prev = tail;
        size++;
    }

    public void displayMiddleDLLC() {
        Node helper = head;
        int middle = size / 2;
        for (int i = 0; i < middle; i++) {
            helper = helper.next;
        }
        System.out.println(helper.data);
    }

    public void shiftingRight(int steps) {
        for (int i = 0; i < steps; i++) {
            head = head.prev;
            tail = tail.prev;
        }
    }

    public void shiftingLeft(int step) {
        for (int i = 0; i < step; i++) {
            head = head.next;
            tail = tail.next;
        }
    }
}