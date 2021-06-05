package sem2.pbo.uap;

public class Persik extends Tanaman implements Perawatan{

    public Persik() {
        setMasaHidup(180);
        setBerbuah(250);
        setPerkembangan(0.15);
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
