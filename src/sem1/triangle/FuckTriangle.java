package sem1.triangle;

import java.util.Scanner;

public class FuckTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();
        for(int a=1;a<=n;a++){
            for (int b=1;b<=a;b++){
                System.out.printf("%*s",(n-a)," ");
                
            }
        }
    }
}
