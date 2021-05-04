package sem2.pbo.praktikum.praktikum4;

public class Main {

    public static void main(String[] args) {
        //NIK = 10 digit, NIM = 15 digit, NIP = 12 digit

        //Create Array Of Object
        Manusia[] manusia = new Manusia[]{
                new Manusia("Adi", "1011247365", true, true),
                new Manusia("Bela", "1110785614", false, true),
                new Manusia("Caca", "1200234689", false, false),
                new Manusia("Deni", "1310446698", true, false)
        };

        Mahasiswa[] mahasiswa = new Mahasiswa[] {
                new Mahasiswa("Eli", "2000145876", false, false),
                new Mahasiswa("Fahmi", "2111468792", true, true),
                new Mahasiswa("Gaffy", "2210457821", true, false)
        };

        Pekerja[] pekerja = new Pekerja[] {
                new Pekerja("Hani", "3001243115", false, true),
                new Pekerja("Indah", "3100446678", false, false),
                new Pekerja("Jamal", "3211785464", true, true)
        };

        Manager[] manager = new Manager[] {
                new Manager("Kylix", "4010554732", true, false),
                new Manager("Lala", "4101322325", false, true),
                new Manager("Mona", "4200784512", false, false)
        };

        //Set Value For Each Object(Mahasiswa, Pekerja, & Manager)
        setterValue(mahasiswa);
        setterValue(pekerja);
        setterValue(manager);

        //Output Each Object
        outputModel(manusia);
        outputModel(mahasiswa);
        outputModel(pekerja);
        outputModel(manager);

        //Output Total Of Objects
        outputTotalObject(manusia, mahasiswa, pekerja, manager);
    }

    private static void setterValue(Mahasiswa[] objArr) {
        String[] arrNIM = new String[] {"205150201111038", "195150300111040", "185150607111065"};
        double[] arrIPK = new double[] {4, 3.2, 2.9};
        for (int index = 0; index < objArr.length; index++) {
            objArr[index].setNIM(arrNIM[index]);
            objArr[index].setIPK(arrIPK[index]);
        }
    }

    private static void setterValue(Pekerja[] objArr) {
        int[] arrJamKerja = new int[] {10, 9, 6};
        int[] arrHariKerja = new int[] {14, 29, 23};
        String[] arrNIP = new String[] {"132001587645", "334100168457", "535211487696"};

        for(int index = 0; index < objArr.length; index++) {
            objArr[index].setJamKerja(arrJamKerja[index]);
            objArr[index].setHariKerja(arrHariKerja[index]);
            objArr[index].setNIP(arrNIP[index]);
        }
    }

    private static void setterValue(Manager[] objArr) {
        int[] arrLamaKerja = new int[]{10, 20, 30};
        int[] arrJamKerja = new int[] {6, 7, 8};
        int[] arrHariKerja = new int[] {30, 30, 30};
        String[] arrNIP = new String[] {"142010587645", "344101168457", "545200487696"};

        for (int index = 0; index < objArr.length; index++) {
            objArr[index].setLamaKerja(arrLamaKerja[index]);
            objArr[index].setJamKerja(arrJamKerja[index]);
            objArr[index].setHariKerja(arrHariKerja[index]);
            objArr[index].setNIP(arrNIP[index]);
        }
    }

    private static void outputModel(Manusia[] objArr){
        System.out.println("------------------------------------------------------");
        String _className = objArr.getClass().getSimpleName();
        int length = objArr.getClass().getSimpleName().length();
        String className = _className.substring(0, length - 2);

        System.out.println("Class: " + className);
        for (Manusia manusia: objArr) {
            System.out.println("=============================");
            System.out.println(manusia.toString());
            System.out.println("=============================");
        }
        System.out.println("------------------------------------------------------\n");
    }

    private static void outputTotalObject(Manusia[] manuisaArr, Mahasiswa[] mahasiswaArr, Pekerja[] pekerjaArr, Manager[] managerArr) {
        System.out.println("------------------------------------------------------");
        System.out.println("Jumlah object Class Manusia: " + manuisaArr.length);
        System.out.println("Jumlah object Class Mahasiswa: " + mahasiswaArr.length);
        System.out.println("Jumlah object Class Pekerja: " + pekerjaArr.length);
        System.out.println("Jumlah object class Manager: " + managerArr.length);
        System.out.println("------------------------------------------------------");
    }
}