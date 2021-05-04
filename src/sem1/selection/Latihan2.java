package sem1.selection;

import java.util.Scanner;

public class Latihan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program Menentukan Nilai Huruf");
        System.out.println("==============================");
        System.out.print("Masukkan Nilai Tugas: ");
        int nilaiTugas = sc.nextInt();
        System.out.print("Masukkan Nilai Kuis: ");
        int nilaiKuis = sc.nextInt();
        System.out.print("Masukkan Nilai UAS: ");
        int nilaiUAS = sc.nextInt();

        if (nilaiUAS < nilaiKuis)
            System.out.println(firstCase(nilaiTugas, nilaiKuis, nilaiUAS));
        else
            System.out.println(secondCase(nilaiTugas, nilaiKuis, nilaiUAS));
    }

    private static char firstCase(int nilaiTugas, int nilaiKuis, int nilaiUAS){
        int nilaiAkhir = (int) ((0.4 * nilaiKuis) + (0.4 * nilaiUAS) + (0.2 * nilaiTugas ));
        return choosingGrade(nilaiAkhir);
    }

    private static char secondCase(int nilaiTugas, int nilaiKuis, int nilaiUAS){
        int nilaiAkhir = (int) ((0.3 * nilaiKuis) + (0.5 * nilaiUAS) + (0.2 * nilaiTugas ));
        return choosingGrade(nilaiAkhir);
    }

    private static char choosingGrade(int nilaiAkhir){
        char grade = 'n';
        if (range(85, 100, nilaiAkhir))
            grade = 'A';
        else if (range(75, 84, nilaiAkhir))
            grade = 'B';
        else if (range(65, 74, nilaiAkhir))
            grade = 'C';
        else if (range(50, 64, nilaiAkhir))
            grade = 'D';
        else
            grade = 'E';
        return grade;
    }
    private static boolean range(int start, int end, int compare){
        return (compare >= start && compare <= end);
    }
}