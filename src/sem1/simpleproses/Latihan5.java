package sem1.simpleproses;

public class Latihan5 {
    public static void main(String[]args){
        int y = 33, x = 45;
        y = y & x;
        System.out.printf("y = %d\n", y);
        y += y >> 2 & x;
        System.out.printf("y = %d\n", y);
        y = y | x;
        System.out.printf("y = %d\n", y);
        y = y | x << 2;
        System.out.printf("y = %d\n", y);
        y &= y = x;
        System.out.printf("y = %d\n", y);
        y ^= y = x;
        System.out.printf("y = %d\n", y);
    }
}

/*
ALERT!!!!
Penulisan baris ke x pada nomer 1 hingga 6 didasarkan pada penulisan saya di IntelliJ IDEA, jika ada perbedaan nomor baris karena perbadaan IDE dimohon menyesuaikan.
 */

/*
Apakah keluaran yang akan ditampilkan di layar monitor bila program di atas bila dieksekusi ? Jelaskan, Mengapa bisa diperoleh demikian?

Output:
y = 33
y = 41
y = 45
y = 189
y = 45
y = 0

Penjelasan:
Nilai awal dari variabel x adalah 33 dan nilai y adalah 45
Bilangan biner dari 33 adalah 100001, sedangkan 45 adalah 101101

1. Kode pada baris ke 6 (y = y & x;) merupakan operator bitwise AND

        Ketika 100001 dioperasikan dengan 101101 menggungakan operator AND, maka akan menghasilkan bilangan biner 100001
    Bilangan biner 100001 ketika diubah menjadi bilangan desimal hasilnya adalah 33

        Sehingga baris 7 (System.out.printf("y = %d\n", y);) akan menghasilkan output nilai variabel y yaitu 33

2. Kode pada baris ke 8 (y += y >> 2 & x;) merupakan gabungan operator aritmatika dan bitwise
        Jika dituliskan ekspresinya akan sama seperti ini: y = y + (y >> 2 & x)

        Operator bitwise pertama adalah menggeser 2 bit variabel y ke arah kanan. Nilai y sebelumnya adalah 33 atau 100001 (biner)
    jika digerser 2 bit ke kanan, maka hasilnya adalah 1000 atau 8 (desimal). Lalu operator biwise kedua yaitu AND. Ketika
    bilangan biner 1000 dioperasikan dengan 101101 menggunakan opertor AND, maka hasilnya adalah 1000 atau 8 (desimal).
    Selanjutnya adalah operator matematika penjumlahan y = 33 + 8, sehingga nilai variabel y adalah 41

        Sehingga pada baris ke 9 (System.out.printf("y = %d\n", y);) akan menghasilkan output nilai variabel y yaitu 41

3. Kode pada baris ke 10 (y = y | x;) adalah operator bitwise OR
        Nilai variabel y sebelumnya adalah 41 atau 101001 (biner)

        Ketika 101001 dioperasikan dengan 101101 menggunakan operator OR, maka akan menghasilkan bilangan biner 101101
    Bilangan biner 101101 ketika diubah menjadi bilangan desimal hasilnya adalah 45

        Sehingga baris ke 11 (System.out.printf("y = %d\n", y);) akan menghasilkan output nilai variabel y yaitu 45

4. Kode pada baris ke 12 (y = y | x << 2;) adalah gabungan operator aritmatika dan bitwise
        Jika kita mengoperasikan persamaan tersebut dari kiri ke kanan maka hasilnya adalah 180 sedangkan output yang dihasilkan
   oleh Java adalah 189, Kenapa demikian?

        Jawabannya adalah operator bitwise OR memiliki skala prioritas yang lebih kecil daripada operator bitwise penggeseran bit.
    Sehingga operator bitwise penggeseran bit akan dikerjakan terlebih dahulu.

        Nilai variabel x adalah 45 dan jika bit nya digeser sebanyak 2 ke arah kiri, maka bitnya berubah menjadi 10110100.
    Selanjutnya bilangan biner 10110100 dioperasikan dengan 101101 (bilangan biner variabel y) menggunakan operator OR, maka
    hasilnya adalah 10111101. Jika kita ubah bilangan biner 10111101 menjadi bilangan desimal, maka hasilnya adalah 189

        Sehingga baris ke 13 (System.out.printf("y = %d\n", y);) akan menghasilkan output varaibel y yaitu 189

5. Kode pda baris ke 14 (y &= y = x;) merupakan gabungan operator bitwise dan operator penugasan matematika
        Jika dituliskan ekspresinya maka akan ekuivalen dengan y = y & (y = x)

        Ekspresi y = x menunjukkan bahwa nilai variabel y pada ekspresi tesebut sama dengan variabel x yaitu 45 atau 101101 (biner).
   Lalu nilai variabel y sebelumnya yaitu 189 akan dioperasikan dengan nilai y dari ekspresi y = x menggunakan operator AND.
   Ketika bilangan biner 10111101 dioperasikan dengan 101101 menggunakan operator AND, maka akan menghasilkan bilangan
   biner 00101101. Jika kita ubah bilangan biner tersebut menjadi bilangan desimal, maka hasilnya adalah 45

        Sehingga baris ke 15 (System.out.printf("y = %d\n", y);) akan menghasilkan output variabel y yaitu 45

6.  Kode pda baris ke 16 (y ^= y = x;) merupakan gabungan operator bitwise dan operator penugasan matematika
          Jika dituliskan ekspresinya maka akan ekuivalen dengan y = y ^ (y = x)

         Ekspresi y = x menunjukkan bahwa nilai variabel y pada ekspresi tesebut sama dengan variabel x yaitu 45 atau 101101 (biner).
   Lalu nilai variabel y sebelumnya yaitu 45 akan dioperasikan dengan nilai y dari ekspresi y = x menggunakan operator XOR.
   Ketika bilangan biner 101101 dioperasikan dengan 101101 menggunakan operator XOR, maka akan menghasilkan bilangan
   biner 000000. Jika kita ubah bilangan biner tersebut menjadi bilangan desimal, maka hasilnya adalah 0

        Sehingga baris ke 17 (System.out.printf("y = %d\n", y);) akan menghasilkan output variabel y yaitu 0
 */
