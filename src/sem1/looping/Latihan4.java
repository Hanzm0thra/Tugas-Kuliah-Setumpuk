package sem1.looping;

public class Latihan4 {
    //Program yang error akan saya jadikan komentar
    public static void main(String[]args){
        nomorSatu();
        nomorDua();
    }

    private static void nomorSatu() {
        for (int i = 0, j = 1; i < 8; i++, j++)
            System.out.printf("%d + %d = %d\n", i, j, i + j);
    }

    private static void nomorDua() {
//        for (int i = 0, j = 1; i < 8; i++, j++);
//            System.out.printf("%d + %d = %d\n", i, j, i + j);
    }

/*
Jelaskan output-nya dan perbedaannya dari dua potongan program di atas!

Program pertama akan menghasilkan output sebagai berikut:
0 + 1 = 1
1 + 2 = 3
2 + 3 = 5
3 + 4 = 7
4 + 5 = 9
5 + 6 = 11
6 + 7 = 13
7 + 8 = 15

Sedanghkan program kedua akan menghasilkan error karena setelah for ada semicolon(;)
 */
}
