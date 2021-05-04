package sem1.selection;

import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int z = 0;
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        if (n > 0)
           if(a > b)
               z = a;
           else
               z = b;
    }
}

/*
1. Jelaskan keyword else berpasangan dengan if yang mana?

    Keyword else berpasangan dengan if yang berada pada line 13 (Dijalankan pada IDE IntelliJ IDEA) yaitu if(a > b)

2. Perbaiki cara penulisan potongan program di atas, agar menjadi lebih jelas dibaca alogritmanya!

    Penulisan potongan program di atas, agar menjadi lebih jelas dibaca alogritmanya adalah dengan menggunakan kelas Math.

    if (n >0)
            z = Math.max(a, b);

 */
