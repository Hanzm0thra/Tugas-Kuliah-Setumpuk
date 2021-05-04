package sem1.looping;

import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        InfiniteLoop infiniteLoop = new InfiniteLoop();
        int n = 1;
        nomorSatu(infiniteLoop, n);
        nomorDua(infiniteLoop, n);
    }

    private static void nomorSatu(InfiniteLoop infiniteLoop, int n){
        System.out.print("1: Untuk For Loop\n2: Untuk While Loop\n3: Untuk Do While Loop\nMasukkan Pilihan:");
        int choose = input();
        if (choose == 1)
            infiniteLoop.forLoop();
        else if(choose == 2)
            infiniteLoop.whileLoop(n);
        else if(choose == 3)
            infiniteLoop.doWhileLoop(n);
        else
            System.out.println("Pilihan tidak tersedia");
    }

    static void nomorDua(InfiniteLoop infiniteLoop, int n){

    }

    private static int input(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }
}

class InfiniteLoop {
    public void forLoop(){
        for (;;){
            System.out.println("For Infinite Loop");
        }
    }
    public void whileLoop(int n){
        while(n >= 0){
            System.out.println("While Infinite Loop");
        }
    }
    public void doWhileLoop(int n){
        do{
            System.out.println("Do While Infinite Loop");
        } while(n >= 0);
    }
}