package sem2.asd.singlelinkedlist;

public class Number1 {

    public static void main(String[] args) {
        /**
         Buatlah program dari 4 node berikut dengan kondisi
         awal linked list kosong:
         **/

        /*
        Membuat sebuah obyek bernama linkedList yang merupakan instance dari Class bernama MyLinkedList
        Kondisi awal linkedList kosong
         */
        MyLinkedList linkedList = new MyLinkedList();

        //Mengisi linkedList dengan 4 node sesuai gambar, pengisian dimulai dari belakang menuju ke depan
        linkedList.addFirst(new MyLinkedList.Node(400));
        linkedList.addFirst(new MyLinkedList.Node(300));
        linkedList.addFirst(new MyLinkedList.Node(200));
        linkedList.addFirst(new MyLinkedList.Node(100));

        //------------------------------------------------------------------------------------------------//

        /**
         Tambahkan node baru dengan data 500 dari belakang.
         Tambahkan node baru dengan data 50 dari depan.
         Tambahkan node dengan data 250 setelah node 200.
         **/

        //Menambahkan node baru dengan data 500 dari belakang
        linkedList.addLast(new MyLinkedList.Node(500));

        //Menambahkan node baru dengan data 50 dari depan
        linkedList.addFirst(new MyLinkedList.Node(50));

        //Menambahkan node baru dengan data 250 setelah node dengan data 200
        linkedList.insertAfter(200, new MyLinkedList.Node(250));

        //------------------------------------------------------------------------------------------------//

        /**
         Hapus node depan. Selanjutnya hapus node belakang.
         Selanjutnya hapus node yg memiliki data 300.
         **/

        //Menghapus node tedepan
        linkedList.removeFirst();

        //Menghapus node terbelakang dari linkedList
        linkedList.removeLast();

        //Menghapus node yang memiliki data 300 dari linkedList
        linkedList.remove(300);

        //------------------------------------------------------------------------------------------------//

        /**
         Akses semua data dari seluruh node tersebut dari node
         yg paling depan ke belakang.
         **/

        //Mengakses semua data dari linkedList
        linkedList.displayLinkedList();
    }
}
