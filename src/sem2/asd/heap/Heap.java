package sem2.asd.heap;

public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize - 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int position) {
        return position > (size / 2) && position <= size;
    }

    /*private void swap(int fpos, int)*/

   /* private void maxHapify(int pos) {
        if (isLeaf(pos))
            return;

        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if ()
        }
    }*/

    /*public void insert(int element) {
        heap[++size]= element;

        int current = size;
        while (heap[current])
    }*/
}
