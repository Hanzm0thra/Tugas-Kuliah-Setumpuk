package sem2.pbo.tugas8.generic2;

public abstract class Change<Before extends Pegawai, After extends Pegawai> {

    abstract After changes(Before before);
}
