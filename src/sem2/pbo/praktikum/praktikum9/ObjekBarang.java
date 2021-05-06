package sem2.pbo.praktikum.praktikum9;

public enum ObjekBarang {
    MEJA("Meja"),
    KURSI("Kursi"),
    LEMARI("Lemari"),
    RAK("Rak Buku"),
    KASUR("Tempat Tidur"),
    LAMPU("Lampu"),
    KIPAS("Kipas Angin"),
    TV("TV"),
    RADIO("Radio");

    public String nama;

    ObjekBarang(String nama) {
        this.nama = nama;
    }
}
