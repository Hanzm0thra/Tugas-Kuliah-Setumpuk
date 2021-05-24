package praktikumpbo10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public static final ArrayList<Mahasiswa> mhs = new ArrayList<>();
    public static final ArrayList<Dosen> dsn = new ArrayList<>();

    public static void initMahasiswa() {
        try {
            File mahasiswaFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Praktikum\\Praktikum 10\\Data Mahasiswa.txt");
            if (!mahasiswaFile.exists())
                mahasiswaFile.createNewFile();

            Scanner read = new Scanner(mahasiswaFile);
            while (read.hasNextLine())
                pecahMhs(read.nextLine());

            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean pecahMhs(String data) {
        String[] arr = data.split("[-\n]");
        if (arr.length != 4)
            return false;
        else {
            for (Mahasiswa obj : mhs) {
                if (obj.getNim().equals(arr[0]))
                    return false;
            }
            mhs.add(new Mahasiswa(arr[0],arr[1],arr[2],arr[3]));
            return true;
        }
    }

    public static void simpanMhs() {
        File mahasiswaFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Praktikum\\Praktikum 10\\Data Mahasiswa.txt");
        FileWriter write;
        try {
            write = new FileWriter(mahasiswaFile);
            for (Mahasiswa obj : mhs) {
                String data = obj.getNim() + "-" + obj.getNama() + "-" + obj.getProdi() + "-" + obj.getFakultas();
                write.write(data + "\n");
            }
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void hapusMhs(String nim) {
        for (int index = 0; index < mhs.size(); index++) {
            if (mhs.get(index).getNim().equals(nim)) {
                mhs.remove(index);
                break;
            }
        }
        simpanMhs();
    }

    public static void initDosen() {
        try {
            File dosenFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Praktikum\\Praktikum 10\\Data Dosen.txt");
            if (!dosenFile.exists()) {
                dosenFile.createNewFile();
            }
            Scanner read = new Scanner(dosenFile);
            while (read.hasNextLine()) {
                pecahDsn(read.nextLine());
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean pecahDsn(String data) {
        String[] arr = data.split("[-\n]");
        if (arr.length != 4)
            return false;
        else {
            for (Dosen dosen : dsn) {
                if (dosen.getNip().equals(arr[0]))
                    return false;
            }
            dsn.add(new Dosen(arr[0],arr[1],arr[2],arr[3]));
            return true;
        }
    }

    public static void simpanDsn() {
        File dosenFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Praktikum\\Praktikum 10\\Data Dosen.txt");
        try {
            FileWriter write = new FileWriter(dosenFile);
            for (Dosen dosen : dsn) {
                String data = dosen.getNip() + "-" + dosen.getNama() + "-" + dosen.getProdi() + "-" + dosen.getFakultas();
                write.write(data + "\n");
            }
            write.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hapusDsn(String nip) {
        for (int index = 0; index < dsn.size(); index++) {
            if (dsn.get(index).getNip().equals(nip)) {
                dsn.remove(index);
                break;
            }
        }
        simpanDsn();
    }
}