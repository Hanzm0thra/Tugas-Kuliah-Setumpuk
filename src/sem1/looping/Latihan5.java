package sem1.looping;

public class Latihan5 {
    public static void main(String[] args) {
        nomorSatu();
        System.out.println();
        nomorDua();
    }

    private static void nomorSatu() {
        int x, y;
        for (x = 1; x <= 3; x ++)
            for (y = 3; y >= 1; y--)
                System.out.printf("%d %d ", x, y);
    }

    private static void nomorDua() {
        int x, y;
        for (x = 1; x <= 3; x++);
            for (y = 3; y >= 1; y--)
                System.out.printf("%d %d ", x, y);
    }
}
/*
Apa output potongan program di atas?

1. Program pertama akan menampilkan output seperti berikut
1 3 1 2 1 1 2 3 2 2 2 1 3 3 3 2 3 1

2. Program kedua akan menampilkan output seperti berikut
4 3 4 2 4 1
 */