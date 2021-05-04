package sem2.asd.utp.no1;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dequeue dequeue = new Dequeue();

        String _totalCommand = scanner.nextLine();
        int totalCommand = Integer.parseInt(_totalCommand);

        for (int i = 0; i < totalCommand; i++) {
            String command = scanner.nextLine();

            try {
                if (command.equals("addFront")) {
                    String obj = scanner.next();
                    String[] str = obj.split(" ", -1);
                    dequeue.addFront(new Dequeue.Node(str[str.length - 1]));
                } else if (command.equals("addBack")) {
                    String obj = scanner.next();
                    String[] str = obj.split(" ", -1);
                    dequeue.addBack(new Dequeue.Node(str[str.length - 1]));
                } else if (command.equals("removeFront")) {
                    dequeue.removeFront();
                } else if (command.equals("removeBack")) {
                    dequeue.removeBack();
                } else if (command.equals("front")) {
                    System.out.println(dequeue.front());
                } else if (command.equals("back")) {
                    System.out.println(dequeue.back());
                } else if (command.equals("print")) {
                    dequeue.print();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class Dequeue {
    static class Node {
        String data;
        Node next;

        Node(String  data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size;

    boolean isEmpty() {return size == 0;}

    public void addFront(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    public void addBack(Node input) {
        if (isEmpty()) {
            head = input;
        } else {
            tail.next = input;
        }
        tail = input;
        size++;
    }

    public void removeFront() {
        Node temp = head;
        if (!isEmpty()) {
            if (head.equals(tail)) {
                head = tail = null;
            } else {
                temp = temp.next;
                head = temp;
            }
            size--;
        }
    }


    public void removeBack() {
        Node temp = head;
        if (!isEmpty()) {
            if (head.equals(tail)) {
                head = tail = null;
            } else{
                while(!temp.next.equals(tail)) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }
    }

    public String front() {
        return head.data;
    }

    public String back() {
        return tail.data;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
