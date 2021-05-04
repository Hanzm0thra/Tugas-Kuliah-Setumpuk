package sem2.asd.praktikum.stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String postfix = scanner.nextLine();
        StackLinkedList stack = new StackLinkedList();

        double var1;
        double var2;
        double result;

        String[] postfixCollection = postfix.split(",", -1);

        for (String s : postfixCollection) {

            switch (s) {
                case "+" :
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = var2 + var1;
                    stack.push(result);
                    break;

                case "-" :
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = var2 - var1;
                    stack.push(result);
                    break;

                case "*":
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = var2 * var1;
                    stack.push(result);
                    break;

                case "/":
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = var2 / var1;
                    stack.push(result);
                    break;

                case"^":
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = (int) Math.pow(var2, var1);
                    stack.push(result);
                    break;

                case "%":
                    var1 = stack.pop();
                    var2 = stack.pop();
                    result = var2 % var1;
                    stack.push(result);
                    break;

                default:
                    int number = Integer.parseInt(s);
                    stack.push(number);
                    break;
            }
        }
        double _top = stack.peek();
        int top = Math.toIntExact(Math.round(_top));
        System.out.println(top);
    }
}

class StackLinkedList {

    Node top = null;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    double pop() {
        if (isEmpty())
            throw new EmptyStackException();

        double result = this.top.data;
        this.top = this.top.next;
        size--;
        return result;
    }

    void push(double input) {
        Node newNode = new Node(input);
        if (size == 0)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    double peek() {
        if (size == 0)
            return 0;
        return top.data;
    }
}

class Node {
    double data;
    Node next;
    Node(double data) {
        this.data = data;
        this.next = null;
    }
}
