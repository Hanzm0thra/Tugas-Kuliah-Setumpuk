package sem2.pbo.projectakhir.help.samuel;

import java.util.Scanner;

public class TurnamenMain {
    public static void main(String[] args) {
        int jumlahTeam = 2;
        int jumlahMember = 2;
        Scanner in = new Scanner(System.in);
        Daftar daftar = new Daftar();
        Versus versus = new Versus();
        for (int i = 0; i < jumlahTeam; i++) {
            System.out.println("=====================================\nDATA TEAM\n=====================================");
            System.out.print("Nama Team         : ");
            String nama = in.nextLine();
            System.out.print("Region            : ");
            String region = in.nextLine();
            System.out.print("Waktu Terbentuk   : ");
            String waktuTerbentuk = in.nextLine();
            System.out.print("Tier              : ");
            int tier = in.nextInt();
            daftar.setTeam(nama, region, waktuTerbentuk, tier);
            in.nextLine();
            for (int j = 0; j < jumlahMember; j++) {
                System.out.println("=====================================\nDATA MEMBER\n=====================================");
                System.out.print("Nama      : ");
                String namaMember = in.nextLine();
                System.out.print("Nick Name : ");
                String nickName = in.nextLine();
                System.out.print("Country   : ");
                String country = in.nextLine();
                daftar.setMember(namaMember, nickName, country, nama);
            }
        }
        daftar.RegistrasiTeam();

        versus.teamSkorInit(daftar.getTeam());
        System.out.print(versus.arrRecordPlaying[0][0]);
        System.out.print(versus.arrRecordPlaying[0][1]);
        System.out.println();
        System.out.print(versus.arrRecordPlaying[1][0]);
        System.out.print(versus.arrRecordPlaying[1][1]);
    }
}
