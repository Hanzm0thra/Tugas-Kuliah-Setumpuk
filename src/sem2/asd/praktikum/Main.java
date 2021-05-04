package sem2.asd.praktikum;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int number = 0;

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();


        for (int count = 1; count <= total - 1; count++) {

            number = scanner.nextInt();
            if (linkedList.head == null && linkedList.tail == null) {
                linkedList.addFirst(new Node(number));
            }

            if (number > linkedList.tail.data) {
                linkedList.addLast(new Node(number));
            } else if (number < linkedList.head.data) {
                linkedList.addFirst(new Node(number));
            }
        }

        linkedList.cetakLinkedList();
    }
}

class SinglyLinkedList{

    public Node head;
    public Node tail;
    int size;

    SinglyLinkedList(){
        this.head = tail = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    public void addFirst(Node add){
        if (isEmpty()) {
            head = add;
            tail = add;
        } else {
            add.next = head;
            head = add;
        }
        size++;
    }

    public void addLast(Node add){
        if (isEmpty()) {
            head = add;
        } else {
            tail.next = add;
        }
        tail = add;
        size++;
    }

    public int get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
        Node current = head;
        for (int count = 0; count < index; count++) {
            current = current.next;
        }

        return current.data;
    }

    public void cetakLinkedList(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
