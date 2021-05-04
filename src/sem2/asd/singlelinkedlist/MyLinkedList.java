package sem2.asd.singlelinkedlist;

public class MyLinkedList {
    static class Node {
        Object data;
        Node pointer;

        //constructor
        public Node(Object data) {
            this.data = data;
            this.pointer = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    //Melakukan penambahan node terdepan
    public void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.pointer = head;
            head = input;
        }
        size++;
    }

    //Melakukan penambahan node terbelakang
    public void addLast(Node input) {
        if (isEmpty()) {
            head = input;
        } else {
            tail.pointer = input;
        }
        tail = input;
        size++;
    }

    //Melakukan penambahan node setelah node tertentu
    public void insertAfter(Object key, Node input) {
        Node temp = head;
        do {
            if (temp.data.equals(key)) {
                input.pointer = temp.pointer;
                temp.pointer = input;
                size++;
                break;
            }
            temp = temp.pointer;
        } while (temp != null);
    }

    //Melakukan penghapusan node terdepan
    public void removeFirst() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("LinkedList is empty!!!");
        } else {
            if (head.equals(tail)) {
                head = tail = null;
            } else {
                temp = temp.pointer;
                head = temp;
            }
            size--;
        }
    }

    //Melakukan penghapusan node terbelakang
    public void removeLast() {
        Node temp = head;
        if (isEmpty()) {
            throw new NullPointerException("Linked List is Empty!!!");
        } else {
            while(temp.pointer != tail) {
                temp = temp.pointer;
            }
            temp.pointer = null;
            tail = temp;
        }
        size--;
    }

    //Melakukan penghapusan node dengan nilai tertentu
    public void remove(Object key) {
        Node temp = head;
        if(isEmpty()) {
            System.out.println("LinkedList is empty!!!");
        } else {
            while(temp != null) {
                if (temp.pointer.data.equals(key)) {
                    temp.pointer = temp.pointer.pointer;
                    if (temp.pointer == null) {
                        tail = temp;
                    }
                    break;
                } else if(temp.data.equals(key) && temp.equals(head)) {
                    this.removeFirst();
                    break;
                }
                temp = temp.pointer;
            }
        }
        size--;
    }

    //Melakukan pegecekan index pada suatu Linked List
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    public Object getIndex(int index) {
        checkIndex(index);

        Node current = head;
        for (int count = 0; count < index; count++) {
            current = current.pointer;
        }

        return current.data;
    }

    public int indexOf(Object key) {
        Node current = head;
        int index = 0;

        if (current != null){
            do {
                if (current.equals(key)) {
                    break;
                }
                current = current.pointer;
                index++;
            } while(current != null);
        } else {
            index = -1;
        }

        return index;
    }

    public void removeByIndex(int index) {
        checkIndex(index);
        Node current = head;
        if (index == 0) {
            if (head.equals(tail)) {
                head = tail = null;
            } else {
                current = current.pointer;
                head = current;
            }
        } else {
            for (int count = 0; count < index - 1; count++){
                current = current.pointer;
            }
            current.pointer = current.pointer.pointer;
        }
        size--;
    }

    public void addAfterByIndex(int index, Node input) {
        checkIndex(index);
        Node current = head;
        if (index == 0) {
            if (head.equals(tail)) {
                current.pointer = input;
                tail = input;
            } else {
                input.pointer = current.pointer;
                current.pointer = input;
            }
        } else {
            for (int count = 0; count < index; count++) {
                current = current.pointer;
            }
            input.pointer = current.pointer;
            current.pointer = input;
        }
        size++;
    }

    //Melakukan penggantian data pada suatu node yang terletak pada index tertentu
    public void replace(int index, Object theElement) {
        checkIndex(index);
        if (index == 0) {
            head.data = theElement;
        } else {
            Node current = head;
            for (int count = 0; count < index; count++) {
                current = current.pointer;
            }
            current.data = theElement;
        }
    }

    public void displayLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.pointer;
        }
    }
}