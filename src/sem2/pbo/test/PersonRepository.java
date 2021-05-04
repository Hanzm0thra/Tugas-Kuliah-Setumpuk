package sem2.pbo.test;

public class PersonRepository implements IPersonRepository {

    @Override
    public String getNama() {
        return Source.getNama();
    }

    @Override
    public void setNama(String nama) {
        Source.setNama(nama);
    }

}
