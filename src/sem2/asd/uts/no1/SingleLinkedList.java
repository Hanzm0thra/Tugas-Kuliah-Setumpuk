package sem2.asd.uts.no1;

public class SingleLinkedList {
    static class Node {
        Karyawan data;
        Node pointer;

        //constructor
        public Node(Karyawan data) {
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

    public void displayLinkedList() {
        Node current = head;
        System.out.println("NIK \tNama \tAlamat \t\t\t\tJabatan\n");
        while (current != null) {
            System.out.printf("%-6s %-7s %-20s %-14s\n",
                    current.data.getNIK(), current.data.getNama(), current.data.getAlamat(), current.data.getJabatan());
            current = current.pointer;
        }
    }
}