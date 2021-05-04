package sem2.pbo.praktikum.praktikum5;

public class KRS {

    private int countSKS = 0;
    private int countIndex = 0;
    private MataKuliah[] matkul;

    public KRS() {
        this.matkul = new MataKuliah[12];
    }

    public void tambahMatkulKRS(MataKuliah matkul, String nimMahasiswa) {
        countSKS = countSKS + matkul.getSks();
        if (countSKS <= 24) {
            this.matkul[countIndex] = matkul;
            countIndex++;
            System.out.printf("%s\t: Mata kulilah berhasil ditambahkan\n", nimMahasiswa);
        } else {
            System.out.printf("%s\t: Anda telah mencapai maksimal sks\n", nimMahasiswa);
            countSKS = countSKS - matkul.getSks();
        }
    }

    public void tampilKRS() {
        System.out.println("DAFTAR MATA KULIAH YANG TERPROGRAM DALAM KRS: ");
        int index = 0;
        while (matkul[index] != null) {
            System.out.printf("- %s | %s | %s | %d -\n", matkul[index].getKodeMatkul(), matkul[index].getNamaMatkul(),
                    matkul[index].getDosen().getNama(), matkul[index].getSks());
            index++;
        }
        System.out.printf("Jumlah SKS yang diambil adalah: %d SKS\n", countSKS);
    }

    public int getCountSKS() {
        return countSKS;
    }

    public MataKuliah[] getMatkul() {
        return matkul;
    }
}
