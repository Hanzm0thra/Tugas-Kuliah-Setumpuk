package sem2.asd.praktikum.maxheap;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] separatedInput = input.split(",", -1);
        int[] inputCollection = new int[separatedInput.length];

        for (int index = 0; index< separatedInput.length; index++)
            inputCollection[index] = Integer.parseInt(separatedInput[index]);

        for (int number: inputCollection)
            maxHeap.insert(number);

        for (int index = 0; index < inputCollection.length; index++)
            System.out.print(maxHeap.extractMax() + " ");
    }
}

class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) { return pos / 2; }

    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
}