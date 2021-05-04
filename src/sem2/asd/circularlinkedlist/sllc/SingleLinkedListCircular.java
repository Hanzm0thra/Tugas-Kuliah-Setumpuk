package sem2.asd.circularlinkedlist.sllc;

public class SingleLinkedListCircular {

    public static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    private boolean isEmpty() {
        return size == 0;
    }

    //penambahan node dari depan
    public void addFirst(Node input) {
        if (isEmpty()) {
            head = tail = input;
            tail.next = head;
        } else {
            tail.next = input;
            input.next = head;
            head = input;
        }
        size++;
    }

    //penambahan node dari belakang
    public void addLast(Node input) {
        if (isEmpty()) {
            head = tail = input;
            tail.next = head;
        } else {
            tail.next = input;
            input.next = head;
            tail = input;
        }
        size++;
    }

    //penambahan node setelah node tertentu
    public void insertAfter(Object key, Node input) {
        Node helper = head;
        do {
            if (helper.data.equals(key)) {
                if (helper == tail) {
                    tail.next = input;
                    input.next = head;
                    tail = input;
                } else {
                    input.next = helper.next;
                    helper.next = input;
                }
                size++;
                break;
            }
            helper = helper.next;
        } while (helper != tail.next);
    }

    //penambahan node sebelum node tertentu
    public void insertBefore(Object key, Node input) {
        Node helper = head;
        Node beforeKey = head;
        do {
            if (helper.data.equals(key)) {
                if (helper == head) {
                    input.next = head;
                    head = input;
                    tail.next = head;
                } else {
                    while (beforeKey.next != helper) {
                        beforeKey = beforeKey.next;
                    }
                    input.next = helper;
                    beforeKey.next = input;
                }
                size++;
                break;
            }
            helper = helper.next;
        }while(helper != tail.next);
    }

    //penghapusan node terdepan
    public void removeFirst() {
        Node helper = head;
        if (isEmpty()) {
            throw new NullPointerException("Single Linked List Circular is empty!!!");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                helper = helper.next;
                head = helper;
                tail.next = head;
            }
        }
        size--;
    }

    //penghapusan node terbelakang
    public void removeLast() {
        Node helper = head;
        if (isEmpty()) {
            throw new NullPointerException("Single Linked List Circular is empty!!!");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                while (helper.next != tail) {
                    helper = helper.next;
                }
                helper.next = head;
                tail = helper;
            }
        }
        size--;
    }

    //penghapusan suatu node dengan data tertentu
    public void remove(Object key) {
        Node helper = head;
        Node beforeKey = head;
        if (isEmpty()) {
            throw new NullPointerException("Single Linked List Circular is empty!!!");
        } else {
            do {
                if (helper.data.equals(key)) {
                    if (helper == tail) {
                        while (helper.next != tail) {
                            helper = helper.next;
                        }
                        helper.next = head;
                        tail = helper;
                    } else if (helper == head) {
                        helper = helper.next;
                        head = helper;
                        tail.next = head;
                    } else {
                        while (beforeKey.next != helper) {
                            beforeKey = beforeKey.next;
                        }
                        beforeKey.next = helper.next;
                    }
                    size--;
                    break;
                }
                helper = helper.next;
            } while (helper != tail.next);
        }
    }

    //membuktikan bahwa SLLC terbentuk dengan semestinya (menyebabkan infinite loop)
    public void proofingSLLC() {
        System.out.println("head: " + head.data);
        System.out.println("tail: " + tail.data);
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //menampilkan data dari setiap node pada SLLC
    public void displaySLLC() {
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        }while (current != tail.next);
    }
}