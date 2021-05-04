package sem2.asd.singlelinkedlist;


public class Number3 {

    public static void main(String[] args) {

        /**
         Buatlah method untuk replace data pada single linked list. Gunakan pengaksesan index pada node
         **/

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addFirst(new MyLinkedList.Node(400));
        linkedList.addFirst(new MyLinkedList.Node(300));
        linkedList.addFirst(new MyLinkedList.Node(200));
        linkedList.addFirst(new MyLinkedList.Node(100));

        //Melakukan replace sesuai index
        linkedList.replace(0, 500);
        linkedList.replace(1, 600);
        linkedList.replace(2, 700);

        linkedList.displayLinkedList();
    }
}
