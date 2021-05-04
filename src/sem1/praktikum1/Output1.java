package sem1.praktikum1;

import java.util.Scanner;

public class Output1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String gender = input.nextLine();
        String age = input.nextLine();
        String college = input.nextLine();
        String phone = input.nextLine();
        String email = input.nextLine();

        System.out.println("Nama            : " + name);
        System.out.println("Jenis Kelamin   : " + gender);
        System.out.println("Umur            : " + age);
        System.out.println("Universitas     : " + college);
        System.out.println("Nomor HP        : " + phone);
        System.out.println("Email           : " + email);
    }
}

