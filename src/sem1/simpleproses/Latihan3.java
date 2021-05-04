package sem1.simpleproses;

public class Latihan3 {
    public static void main(String[]args){
        int x = 10, y = 6, z = 25;
        x *= 5 + y;
        y += y &= x;
        z += x >> 2 & y << 1;
        System.out.printf("x = %d\ny = %d\nz = %d\n", x , y , z);
    }
}
/*
Apakah keluaran yang akan ditampilkan di layar monitor bila program di atas berhasil dieksekusi?
x = 110
y = 12
z = 49
 */
