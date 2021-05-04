package sem2.asd.stack.array;

import java.util.EmptyStackException;

public class StackArray {

    int[] stack;
    int arraySize;
    int top;

    void init(int arraySize) {
        this.arraySize = arraySize;
        stack = new int[this.arraySize];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arraySize - 1;
    }

    void pop() {
        if(isEmpty())
            throw new EmptyStackException();
        top--;
    }

    void push(int data) {
        if (isFull()) {
            stack = resizing(stack);
        }
        stack[++top] = data;
    }

    private int[] resizing(int[] stack) {
        int[] newArr = new int[2 * stack.length];
        arraySize = newArr.length;
        System.arraycopy(stack, 0, newArr, 0, arraySize);
        return newArr;
    }

    int peek() {
        return stack[top];
    }
}
