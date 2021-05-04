package sem2.pbo.praktikum.praktikum7;

public class fungsiBangunDatar extends BangunDatar{

    @Override
    public void info() {
        System.out.println("---------------Informasi Bangun Datar---------------");
        for (int i = 0; i < listBangunDatar.length; i++) {
            if (listBangunDatar[i] == null) {
                break;
            } else {
                System.out.println((i+1) + ". " + listBangunDatar[i]);
            }
        }
    }
}
