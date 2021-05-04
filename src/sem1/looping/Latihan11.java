package sem1.looping;

public class Latihan11 {
    public static void main(String[] args) {
        nomorSatu();
        nomorDua();
        nomorTiga();
        nomorEmpat();
    }

    private static void nomorSatu() {
        System.out.println("Nomor Satu: ");
        int x;
        for (x = 0; x < 10; x++)
            System.out.printf("Hello\n");
        System.out.println();
    }

    private static void nomorDua() {
        System.out.println("Nomor Dua: ");
        int x = 0;
        for ( ; x < 10; x++)
            System.out.printf("Hello\n");
        System.out.println();
    }

    private static void nomorTiga() {
        System.out.println("Nomor Tiga: ");
        int x = 0;
        for ( ; ; x++) {
            if (x < 10)
                System.out.printf("Hello\n");
            else
                break;
        }
        System.out.println();
    }

    private static void nomorEmpat() {
        System.out.println("Nomor Empat: ");
        int x = 0;
        for (;;){
            if (x < 10)
                System.out.printf("Hello\n");
            else
                break;
            x++;
        }
    }
}
