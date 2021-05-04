package sem1.looping;

import java.util.Scanner;

public class Latihan9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bilangan ganjil antara 11 - 189");
        System.out.print("1: Menggunakan For\n2: Menggunakan While\n3: Menggunakan Do While\nMasukkan Pilihan: ");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                forLoop();
                break;
            case 2:
                whileLoop();
                break;
            case 3:
                doWhileLoop();
                break;
            default: System.out.println("Pilihan tidak tersedia");
        }
    }
    static void forLoop(){
        for (int i = 11; i <= 188; i++)
            if (i % 2 == 0)
                System.out.println(i);
    }

    static void whileLoop(){
        int i = 11;
        while (i <= 188){
            if (i % 2 == 0)
                System.out.println(i);
            i++;
        }
    }

    static void doWhileLoop(){
        int i = 11;
        do{
            if(i % 2 ==0)
                System.out.println(i);
            i++;
        }while(i <= 188);
    }
}