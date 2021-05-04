package sem2.asd.uts.no1;

public class LinkedList {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.addLast(new SingleLinkedList.Node(
                new Karyawan("00001", "Muhlis", "Jl. Veteran", "Direktur")
        ));

        linkedList.addLast(new SingleLinkedList.Node(
                new Karyawan("00002", "Firza", "Jl. Gajayana", "Sekretaris")
        ));

        linkedList.addLast(new SingleLinkedList.Node(
                new Karyawan("00003", "Akhtar", "Jl. Mayjen Panjaitan", "Staff Pemasaran")
        ));

        linkedList.addLast(new SingleLinkedList.Node(
                new Karyawan("00004", "Adi", "Jl. MT Haryono", "Staff Humas")
        ));

        linkedList.displayLinkedList();
    }
}
