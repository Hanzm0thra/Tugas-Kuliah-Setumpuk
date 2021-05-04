package sem1.looping;

public class Latihan6 {
    public static void main(String[] args) {
        nomorSatu();
        nomorDua();
    }

    private static void nomorSatu() {
        int x, y = 1;
        for (x = 1; x <= 3; x ++)
            for (y = 3; y >= 1; y--);
            System.out.printf("%d %d ", x, y);
    }

    private static void nomorDua() {
        int x, y;
        for (x = 1; x <= 3; x ++);
            for (y = 3; y >= 1; y--);
                System.out.printf("%d %d ", x, y);
    }
}
/*
Apa output potongan program di atas?

1. Program pertama akan menampilkan error yang memiliki pesan bahwa variabel y belum di init

2. Program kedua akan menampilkan output seperti berikut
4 0
 */