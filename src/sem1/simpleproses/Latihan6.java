package sem1.simpleproses;

public class Latihan6 {
    public static void main(String[]args){
        int y, n;
        n = 10;
        y = ++n;
        System.out.printf("y = %d\n", y);
        n = 10;
        y = n++;
        System.out.printf("y = %d\n", y);
        n = 10;
        n++;
        System.out.printf("y = %d\n", n);
    }
}

/*
Apakah keluaran yang akan ditampilkan di layar monitor bila program di atas bila dieksekusi?, Jelaskan, mengapa bisa menghasilkan keluaran demikian?

Output:
y = 11
y = 10
y = 11

1. Pada baris ke-6 nilai n adalah 10, lalu pada baris ke-7 variabel y = ++n
        Jika ++n terikat dalam ekspresi lainnya (tidak stand alone), maka nilai n ditambah 1 terlebih dahulu lalu diproses
   terhadap ekspresinya. Sehingga nilai y pada baris ke-7 adalah 11.

2. Pada baris ke-9 nilai n adalah 10, lalu pada baris ke-10 variabel y = n++
        Jika n++ terikat dalam ekspresi lainnya (tidak stand alone), maka nilai n langsung diproses terhadap ekspresinya
   tanpa menambah nilai n sebanyak 1 terlebih dahulu, pada saat selesai baru nilai n ditambah 1. Sehingga nilai y pada baris ke-10 adalah 10.

3. Pada baris ke-12 nilai n adalah 10, lalu pada baris ke-13 post increment terhadap varaibel n
        Jika n++ berdiri sendiri (stand alone), maka hal tersebut tidak ada bedanya dengan ++n yang artinya sama dengan
   n = n + 1. Sehingga nilai n pada baris ke-13 akan menjadi 11.
 */
