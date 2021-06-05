package sem2.pbo.uap;

public class Tomat extends Tanaman implements Perawatan {

    public Tomat() {
        setMasaHidup(100);
        setBerbuah(100);
        setPerkembangan(0.25);
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.025);
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
