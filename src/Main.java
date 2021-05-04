import java.util.*;
public class Main {


    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();

        int firstInp = inp.nextInt();
        list.addLast(new Node(firstInp));

        for (int i=0; i <N-1;i++) {
            int input = inp.nextInt();
            Node node = new Node(input);
            if (input>list.tail.data) {
                list.addFirst(node);
            } else if (input<list.head.data) {
                list.addLast(node);
            }
        }

        list.cetakLinkedList();
    }
}


class SinglyLinkedList{

    public Node head;
    public Node tail;
    int size;
    SinglyLinkedList(){
        this.head = tail = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    public void addFirst(Node add){
        if(isEmpty()){
            head = tail = add;
        }
        else {
            add.next = head;
            head = add;
        }
        size++;
    }

    public void addLast(Node add){
        if(isEmpty()){
            head = tail = add;
        }
        else {
            tail.next = add;
            tail = add;
        }
        size--;
    }

    public int get(int index){
        return -1;
    }

    public void cetakLinkedList(){
        Node pointer = head;
        while ( pointer != null){
            System.out.println (pointer.data);
            pointer = pointer.next;
        }

    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}