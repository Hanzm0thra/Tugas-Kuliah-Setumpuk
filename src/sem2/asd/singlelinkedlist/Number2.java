package sem2.asd.singlelinkedlist;

public class Number2 {

    public static void main(String[] args) {

         /*
        Membuat sebuah obyek bernama linkedList yang merupakan instance dari Class bernama MyLinkedList
        Kondisi awal linkedList kosong
         */
        MyLinkedList linkedList = new MyLinkedList();

        // Menambahkan beberapa node pada linked list
        linkedList.addLast(new MyLinkedList.Node(100));
        linkedList.addLast(new MyLinkedList.Node(200));
        linkedList.addLast(new MyLinkedList.Node(300));
        linkedList.addLast(new MyLinkedList.Node(400));

        /**
         Mengakses semua data pada single linked list
         **/
        linkedList.displayLinkedList();
    }
}
