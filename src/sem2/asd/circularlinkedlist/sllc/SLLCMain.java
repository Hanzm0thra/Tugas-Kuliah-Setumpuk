package sem2.asd.circularlinkedlist.sllc;

public class SLLCMain {

    public static void main(String[] args) {
        SingleLinkedListCircular linkedList = new SingleLinkedListCircular();

        //penambahan node di depan
        linkedList.addFirst(new SingleLinkedListCircular.Node(300));
        linkedList.addFirst(new SingleLinkedListCircular.Node(200));
        linkedList.addFirst(new SingleLinkedListCircular.Node(100));

        //penambahan node dengan data 400 di akhir
        linkedList.addLast(new SingleLinkedListCircular.Node(400));

        //penambahan node dengan data 250 setelah node dengan data 200
        linkedList.insertAfter(200, new SingleLinkedListCircular.Node(250));

        //penambahan node dengan data x setelah ndoe denagnd data y
        linkedList.insertBefore(200, new SingleLinkedListCircular.Node(150));

        //penghapusan node terdepan
        linkedList.removeFirst();

        //penghapusan node terbelakang
        linkedList.removeLast();

        //penghapusan node dengan data 250
        linkedList.remove(250);

        //melakukan pembuktian pada SLLC, jika terbentuk dengan baik akan menyebabkan infinite loop
        linkedList.proofingSLLC();

        //menampilkan data dari SLLC
        //linkedList.displaySLLC();
    }
}
