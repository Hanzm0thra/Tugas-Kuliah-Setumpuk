package sem2.asd.circularlinkedlist.dllc;

public class DLLCMain {
    public static void main(String[] args) {
        DoubleLinkedListCircular linkedList = new DoubleLinkedListCircular();

        //penambahan node di depan
        linkedList.addFirst(new DoubleLinkedListCircular.Node(300));
        linkedList.addFirst(new DoubleLinkedListCircular.Node(200));
        linkedList.addFirst(new DoubleLinkedListCircular.Node(100));

        //penambahan node di belakang
        linkedList.addLast(new DoubleLinkedListCircular.Node(400));

        //penambahan node dengan data 450 setelah node dengan data 400
        linkedList.insertAfter(200, new DoubleLinkedListCircular.Node(250));

        //penambahan node dengan data 50 sebelum node dengan data 100
        linkedList.insertBefore(200, new DoubleLinkedListCircular.Node(150));

        //penghapusan node terdepan
        linkedList.removeFirst();

        //penghapusan node terbelakang
        linkedList.removeLast();

        //penghapusan node dengan data 400
        linkedList.remove(250);

        //melakukan pembuktian pada DLLC, jika terbentuk dengan baik akan menyebabkan infinite loop
        linkedList.proofingDLLC();

        //menampilkan data pada setiap node yang terdapat pada DLLC
        linkedList.displayDLLC();
    }
}
