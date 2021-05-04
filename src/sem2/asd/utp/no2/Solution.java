package sem2.asd.utp.no2;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Solution {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();

        String str = scanner.nextLine();

        String[] command = str.split("");

        if (command.length % 2 != 0) {
            System.out.println("Tidak Seimbang");
        } else {
            for (String obj: command) {
                if (obj.equals("{") || obj.equals("[") || obj.equals("(")) {
                    stack.push(obj);
                } else if (obj.equals("}")){
                    String top = stack.peek();
                    if (top.equals("{")) {
                        stack.pop();
                        count++;
                    } else {
                        System.out.println("Tidak Seimbang");
                        break;
                    }
                } else if (obj.equals("]")) {
                    String top = stack.peek();
                    if (top.equals("[")) {
                        stack.pop();
                        count++;
                    } else {
                        System.out.println("Tidak Seimbang");
                        break;
                    }
                } else if (obj.equals(")")) {
                    String top = stack.peek();
                    if (top.equals("(")) {
                        stack.pop();
                        count++;
                    } else {
                        System.out.println("Tidak Seimbang");
                        break;
                    }

                }
            }
            if (count != 0 )
                System.out.println("Seimbang " + count);
        }
    }
}

class StackLinkedList {

    Node top = null;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    void pop() {
        if (isEmpty())
            throw new EmptyStackException();

        String result = this.top.data;
        this.top = this.top.next;
        size--;
    }

    void push(String input) {
        Node newNode = new Node(input);
        if (size == 0)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    String peek() {
        if (size == 0)
            return null;
        return top.data;
    }
}

class Node {
    String  data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

