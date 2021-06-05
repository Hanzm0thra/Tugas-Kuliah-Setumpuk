package sem2.pbo.uap;

public abstract class Tanaman {
    private int masaHidup;
    private int lamaHidup;
    private int berbuah;
    private int buah;
    private double perkembangan;
    private double prosesBerbuah;

    public abstract void berkembang();

    public String status() {
        String status = "";
        if (getLamaHidup() >= getMasaHidup()) {
            status = "Mati";
        } else {
            status = "Hidup";
        }
        return status;
    }

    @Override
    public String toString() {
        return "Masa hidup: " + getMasaHidup() + " hari" + "\n" +
                "Umur tanaman: " + getLamaHidup() + " hari" + "\n" +
                "Menghasilkan: " + getBuah() + " buah" + "\n" +
                "Status: " + status() + "\n";
    }

    public int getMasaHidup() {
        return masaHidup;
    }

    public void setMasaHidup(int masaHidup) {
        this.masaHidup = masaHidup;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public int getBerbuah() {
        return berbuah;
    }

    public void setBerbuah(int berbuah) {
        this.berbuah = berbuah;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    public double getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(double perkembangan) {
        this.perkembangan = perkembangan;
    }

    public double getProsesBerbuah() {
        return prosesBerbuah;
    }

    public void setProsesBerbuah(double prosesBerbuah) {
        this.prosesBerbuah = prosesBerbuah;
    }
}
