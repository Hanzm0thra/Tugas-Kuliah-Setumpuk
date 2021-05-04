package sem2.asd.uts.no1;

public class Array {
    public static void main(String[] args) {
        Karyawan[] karyawan = new Karyawan[4];

        karyawan[0] = new Karyawan("00001", "Muhlis", "Jl. Veteran", "Direktur");
        karyawan[1] = new Karyawan("00002", "Firza", "Jl. Gajayana", "Sekretaris");
        karyawan[2] = new Karyawan("00003", "Akhtar", "Jl. Mayjen Panjaitan", "Staff Pemasaran");
        karyawan[3] = new Karyawan("00004", "Adi", "Jl. MT Haryono", "Staff Humas");

        System.out.println("NIK \tNama \tAlamat \t\t\t\tJabatan\n");
        for (Karyawan obj: karyawan) {
            System.out.printf("%-6s %-7s %-20s %-14s\n",
                    obj.getNIK(), obj.getNama(), obj.getAlamat(), obj.getJabatan());
        }
    }
}
