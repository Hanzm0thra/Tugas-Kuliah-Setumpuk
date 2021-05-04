package sem2.pbo.praktikum.praktikum3;

public class Skenario3 {
    public static void main(String[] args) {
        PinjamanOnline[] akun = new PinjamanOnline[]{
                new PinjamanOnline("Ana"),
                new PinjamanOnline("Doni"),
                new PinjamanOnline("Ikhsan"),
                new PinjamanOnline("Adi")
        };

        akun[0].pinjam();
        akun[1].pinjam();
        akun[2].pinjam();
        akun[2].kembalikan();
        akun[0].kembalikan();
        akun[3].pinjam();
        akun[3].kembalikan();
        akun[2].pinjam();
        akun[1].pinjam();
        akun[1].kembalikan();
        akun[2].kembalikan();
        akun[1].pinjam();
        dataPeminjam(akun);
    }

    private static void dataPeminjam(PinjamanOnline[] akun) {
        System.out.println("Data Para Peminjam");
        for (PinjamanOnline nama: akun) {
            System.out.println( "============================");
            System.out.println("Status Peminjman " + nama.nama);
            System.out.println("Lama Peminjaman: " + nama.getLamaPeminjaman());
            System.out.println("Nominal Peminjaman: " + nama.getNominalPeminjaman());
            System.out.println( "============================");
        }
        System.out.println("\nSaldo Sistem: " + akun[0].getSaldoSistem());
    }

}
