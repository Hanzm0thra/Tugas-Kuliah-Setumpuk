package sem1.selection;

import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan nilai IPK mahasiswa: ");
        double nilai = in.nextDouble();
        if (nilai >= 3.5 && nilai <= 4.0){
            System.out.println("Sangat Menuaskan");
        } else if (nilai >= 3.0 && nilai <= 3.4){
            System.out.println("Memuaskan");
        } else if(nilai >= 2.5 && nilai <= 2.9){
            System.out.println("Baik Sekali");
        } else if(nilai >= 2.0 && nilai <= 2.4){
            System.out.println("Baik");
        } else{
            System.out.println("Kurang");
        }
    }
}
