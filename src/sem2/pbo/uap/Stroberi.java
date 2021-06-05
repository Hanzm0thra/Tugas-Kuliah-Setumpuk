package sem2.pbo.uap;

public class Stroberi extends Tanaman implements Perawatan{

    public Stroberi() {
        setMasaHidup(60);
        setBerbuah(150);
        setPerkembangan(0.35);
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.05);
    }

    @Override
    public void berkembang() {
        setProsesBerbuah(getProsesBerbuah() + (getProsesBerbuah() * getPerkembangan()));
        if (getProsesBerbuah() >= getBerbuah()) {
            setBuah(getBuah() + 1);
            setProsesBerbuah(getProsesBerbuah() - getBerbuah());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
