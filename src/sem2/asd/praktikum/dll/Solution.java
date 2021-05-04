package sem2.asd.praktikum.dll;

import sem2.asd.circularlinkedlist.dllc.DoubleLinkedListCircular;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList linkedList = new DoubleLinkedList();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                linkedList.addLast(new DoubleLinkedList.Node(scanner.nextInt()));
            } else {
                scanner.next();
            }
        }

        for (int count = 0; count < linkedList.getSize(); count++) {
            System.out.print(linkedList.calculate() + " ");
        }
    }
}

class DoubleLinkedList {
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
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(Node input) {
        if (isEmpty()) {
            head = input;
        } else {
            input.prev = tail;
            tail.next = input;
        }
        tail = input;
        size++;
    }

    public int calculate() {
        Node helper = head;
        int temp = 0;
        for (int count = 0; count < size; count++) {
            if (helper.prev == null) {
                temp = helper.next.data;
            } else if (helper.next == null){
                temp = helper.prev.data;
            } else {
                temp = helper.prev.data + helper.next.data;
            }
            helper = helper.next;
        }
       return temp;
    }
}