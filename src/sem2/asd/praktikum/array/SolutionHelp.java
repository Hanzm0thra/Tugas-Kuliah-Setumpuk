package sem2.asd.praktikum.array;

import java.util.Scanner;

public class SolutionHelp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String teks = input.nextLine();
        int putaran = input.nextInt();
        input.nextLine();
        int pusat = putaran;
        String delate = input.nextLine();

        String[] arr = new String[teks.length()];
        String[] arr2 = new String[arr.length];

        for (int i = 0; i < teks.length(); i++){
            arr[i] = String.valueOf(teks.charAt(i));

        }

        int i = 0;
        while(pusat < arr.length){
            arr2[i] = arr[pusat];
            i++;
            pusat++;
        }

        pusat = 0;
        while(pusat < putaran){
            arr2[i] = arr[pusat];
            i++;
            pusat++;
        }



        StringBuilder stringBuilder = new StringBuilder();
        for (String a : arr2){
            stringBuilder.append(a);
        }

        System.out.println(stringBuilder);
        String last = stringBuilder.toString();
        String encryption = last.replace(delate, "");
        System.out.println(encryption);
    }
}
