package sem1.looping;

public class Latihan2 {
    public static void main(String[] args) {
        nomorSatu();
        nomorDua();
        nomorTiga();
    }

    /*
   Jika k < n maka berapa kali kata FILKOM-UB dicetak di layar monitor?

   Misalkan k = 1 dan n = 2, maka kata FILKOM-UB tidak akan dicetak pada layar monitor
    */
    private static void nomorSatu() {
        int i, k = 1, n = 2;
        for(i = k; i >= n; i--)
            System.out.println("FILKOM-UB");
    }

     /*
    Jika k = n maka berapa kali kata FILKOM-UB dicetak di layar monitor?

    Misalkan k = 1 dan n = 2, maka kata FILKOM-UB akan dicetak sebanyak satu kali pada layar monitor
     */
    private static void nomorDua() {
        int i, k = 2, n = 2;
        for(i = k; i >= n; i--)
            System.out.println("FILKOM-UB");
    }

    /*
   Jika k > n maka berapa kali kata FILKOM-UB dicetak di layar monitor?

   Misalkan k = 1 dan n = 2, maka kata FILKOM-UB akan dicetak sebanyak dua kali pada layar monitor atau dengan kata lain
   akan dicetak sebanyak (k-n) + 1
    */
    private static void nomorTiga() {
        int i, k = 3, n = 2;
        for(i = k; i >= n; i--)
            System.out.println("FILKOM-UB");
    }
}
