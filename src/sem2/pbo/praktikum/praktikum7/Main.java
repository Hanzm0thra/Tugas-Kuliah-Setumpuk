package sem2.pbo.praktikum.praktikum7;

public class Main {

    public static void main(String[] args) {
        Hitung[] hitungs = new Hitung[5];
        hitungs[0] = new Persegi("Persegi", 10);
        hitungs[1] = new Segitiga("Segitiga", 15, 18);
        hitungs[2] = new Layang("Layang", 12, 20, 8, 18);
        hitungs[3] = new Trapesium("Trapesium", 28, 18, 12);
        hitungs[4] = new Lingkaran("Lingkaran", 10);

        for(Hitung bangun : hitungs){
            BangunDatar bangunDatar = BangunDatar.getInstanceBangunDatarOf(bangun);
            bangunDatar.info();
        }

    }
}
