package sem1.looping;

public class Latihan7 {
    public static void main(String[] args) {
        int nilai = 0, jumlah = 0;
        while(nilai < 10){
            jumlah += nilai;
            System.out.printf("\nNilai = %d, Jumlah =%d", nilai++, jumlah);
        }
    }
}
