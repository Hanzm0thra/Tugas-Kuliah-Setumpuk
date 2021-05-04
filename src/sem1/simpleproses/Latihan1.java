package sem1.simpleproses;

/*
   Baris kode yang menghasilkan error akan saya jadikan komentar
    */
public class Latihan1 {
    public static void main(String[]args){
        int b = 23, c = 12, d = 32, e = 0;
        nomorSatu(b, e);
        nomorDua(b, c);
        nomorTiga(c, d);
        nomorEmpat(b, d);
        nomorLima(b);
        nomorEnam(b);
        nomorTujuh(c);
        nomorDelapan(c);
        nomorSembilan(b ,c);
        nomorSepuluh(b, c);
    }

    private static void nomorSatu(int b, int e){
        //int a = b && e;
        //System.out.println(a);
        System.out.println("1. error: Opertaor Logika tidak bisa di operasikan dengan menggunakan tipe data integer");
    }

    private static void nomorDua(int b, int c){
        int a = b & c;
        System.out.println("2. " + a);
    }

    private static void nomorTiga(int c, int d){
        //int a = c || d;
        //System.out.println(a);
        System.out.println("3. error: Opertaor Logika tidak bisa di operasikan dengan menggunakan tipe data integer");
    }

    private static void nomorEmpat(int b, int d){
        int a = b | d;
        System.out.println("4. " + a);
    }

    private static void nomorLima(int b){
        //int a = b > 2;
        //System.out.println(a);
        System.out.println("5. error: Opertaor Relational tidak bisa di masukkan ke varaibel dengan tipe data integer");
    }

    private static void nomorEnam(int b){
        int a = b >> 2;
        System.out.println("6. " + a);
    }

    private static void nomorTujuh(int c) {
        //int a = c < 3;
        //System.out.println(a);
        System.out.println("7. error: Opertaor Relational tidak bisa di masukkan ke varaibel dengan tipe data integer");
    }

    private static void nomorDelapan(int c){
        int a = c <<  3;
        System.out.println("8. " + a);
    }

    private static void nomorSembilan(int b, int c){
        int a = b = c;
        System.out.println("9. " + a);
    }

    private static void nomorSepuluh(int b, int c){
        //int a = b == c;
        //System.out.println(a);
        System.out.println("10. error: Opertaor Relational tidak bisa di masukkan ke varaibel dengan tipe data integer");
    }
}