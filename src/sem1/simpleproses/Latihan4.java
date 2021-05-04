package sem1.simpleproses;

/*
   Baris kode yang menghasilkan error akan saya jadikan komentar
    */
public class Latihan4 {
    public static void main(String[]args){
        nomorSatu();
        System.out.println();
        nomorDua();
    }

    /*
     1. Bagaimanakah hasil keluaran yang ditampilkan di layar monitor dari program di bawah?, Jelaskan?

         x = 3.000000
         x = 3.500000
         x = 3.500000
         x = 3.500000
         x = 3.500000

         Output pertama tidak bertipe double karena semua bilanga di dalam ekspresinya bertipe integer. Output kedua
         hingga kelima bertipe double karena setidaknya ada satu bilangan bertipe double di dalam ekspresi nya
     */
    private static void nomorSatu(){
        double x;
        x = 7 / 2; System.out.printf("x = %f\n", x);
        x = 7.0 / 2; System.out.printf("x = %f\n", x);
        x = 7 / 2.0; System.out.printf("x = %f\n", x);
        x = 7.0 / 2.0; System.out.printf("x = %f\n", x);
        x = (float) 7 / 2; System.out.printf("x = %f\n", x);
    }

    /*
    2.  Bila tipe data x diganti dengan float, jelaskan apa hasilnya, mengapa?

        Apabila tipe data x diganti dengan float, maka akan terjadi error dan ketika program dipaksa untuk dijalankan akan
        menghasilkan error seperti ini:
        java: incompatible types: possible lossy conversion from double to float

        Hal itu dikarenakan ekspresi 7.0 dan 2.0 masih berupa tipe data double sehingga perlu diubah menjadi tipe data
        float agar mencegah terjadinya error dengan cara:

        a. Mengganti 7.0 menjadi 7.0f dan 2.0 menjadi 2.0f
            x = 7.0f / 2; System.out.printf("x = %f\n", x);
            x =  7 / 2.0f; System.out.printf("x = %f\n", x);
            x = 7.0f / 2.0f; System.out.printf("x = %f\n", x);
        b. Menggunakan type casting
            x = (float) (7.0 / 2); System.out.printf("x = %f\n", x);
            x = (float) (7 / 2.0); System.out.printf("x = %f\n", x);
            x = (float) (7.0 / 2.0); System.out.printf("x = %f\n", x);
     */
    private static void nomorDua(){
        float x;
        x = 7 / 2; System.out.printf("x = %f\n", x);
       // x = 7.0 / 2; System.out.printf("x = %f\n", x);
       // x =  7 / 2.0; System.out.printf("x = %f\n", x);
       // x = 7.0 / 2.0; System.out.printf("x = %f\n", x);
        x = (float) 7 / 2; System.out.printf("x = %f\n", x);
    }
}
