package sem2.asd.doublelinkedlist;

import sem2.asd.circularlinkedlist.dllc.DoubleLinkedListCircular;
import sem2.asd.singlelinkedlist.MyLinkedList;

public class DoubleLinkedList {
    public static class Node {
        Object data;
        Node next;
        Node prev;

        //constructor
        Node(Object data) {
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

    //melakukan penambahan node dari depan
    public void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    //melakukan penambahan node dari belakang
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

    //melakukan penambahan node setelah node dengan data tertentu
    public void insertAfter(Object key, Node input) {
        Node helper = head;
        do {
            if (helper.data.equals(key)) {
                if (helper == tail) {
                    input.prev = tail;
                    tail.next = input;
                    tail = input;
                } else {
                    input.prev = helper;
                    input.next = helper.next;
                    helper.next.prev = input;
                    helper.next = input;
                }
                size++;
                break;
            }
            helper = helper.next;
        } while(helper != tail.next);
    }

    //melakukan penambahan node sebelum node dengan data tertentu
    public void insertBefore(Object key, Node input) {
        Node helper = head;
        do {
            if (helper.data.equals(key)) {
                if (helper == head) {
                    input.next = head;
                    head.prev = input;
                    head = input;
                } else {
                    input.prev = helper.prev;
                    input.next = helper;
                    helper.prev.next = input;
                    helper.prev = input;
                }
                size++;
                break;
            }
            helper = helper.next;
        } while (helper != tail.next);
    }

    //menghapus node terdepan
    public void removeFirst() {
        Node helper = head;
        if (isEmpty()) {
            throw new NullPointerException("Double Linked List Circular is empty!!!");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = helper.next;
            }
        }
        size--;
    }

    //menghapus node terbelakang
    public void removeLast() {
        Node helper = tail;
        if (isEmpty()) {
            throw new NullPointerException("Double Linked List Circular is empty!!!");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = helper.prev;
            }
        }
        size--;
    }

    //menghapus node dengan data tertentu
    public void remove(Object key) {
        Node helper = head;
        if (isEmpty()) {
            throw new NullPointerException("Double Linked List Circular is empty!!!");
        } else {
            do {
                if (helper.data.equals(key)) {
                    if (helper == head) {
                        head.next.prev = null;
                        head = helper.next;
                    } else if (helper == tail) {
                        tail.prev.next = null;
                        tail = helper.prev;
                    } else {
                        helper.prev.next = helper.next;
                        helper.next.prev = helper.prev;
                    }
                    size--;
                    break;
                }
                helper = helper.next;
            } while (helper != tail.next);
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    public Object getIndex(int index) {
        checkIndex(index);

        Node current = head;
        for (int count = 0; count < index; count++) {
            current = current.next;
        }

        return current.data;
    }

    public void removeByIndex(int index) {
        checkIndex(index);
        Node helper = head;
        if (index == 0) {
            if (head.equals(tail)) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = helper.next;
            }
        } else {
            for (int count = 0; count < index - 1; count++){
                helper = helper.next;
            }
            helper.prev.next = helper.next;
            helper.next.prev = helper.prev;
        }
        size--;
    }

    //membuktikan bahwa DLLC terbentuk dengan semestinya (menyebabkan infinite loop)
    public void proofingDLLC() {
        System.out.println("head: " + head.data);
        System.out.println("tail: " + tail.data);
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //menampilkan data dari setiap node pada DLLC
    public void displayDLLC() {
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        }while(current != head);
    }
}
