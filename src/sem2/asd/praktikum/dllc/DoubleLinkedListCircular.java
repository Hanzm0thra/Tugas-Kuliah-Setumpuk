package sem2.asd.praktikum.dllc;

public class DoubleLinkedListCircular {
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
        head.prev = tail;
        tail.next = head;
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
        tail.next = head;
        head.prev = tail;
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
                    tail.next = head;
                    head.prev = tail;
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
                    head.prev = tail;
                    tail.next = head;
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
                head.next.prev = tail;
                head = helper.next;
                tail.next  = head;
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
                tail.prev.next = head;
                tail = helper.prev;
                head.prev = tail;
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
                        head.next.prev = tail;
                        head = helper.next;
                        tail.next  = head;
                    } else if (helper == tail) {
                        tail.prev.next = head;
                        tail = helper.prev;
                        head.prev = tail;
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