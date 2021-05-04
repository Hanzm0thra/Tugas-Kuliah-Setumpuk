package sem2.pbo.tugas8.generic1.multiboundedtypeparam;

public class MultipleBoundedApp {

    public static void main(String[] args) {
        //Data<AtasanLangsung> atasan = new Data<AtasanLangsung>(new AtasanLangsung());
        Data<Direktur> direktur = new Data<>(new Direktur());

    }

    public interface Salam {
        void ucapSalam(String nama);
    }

    public static abstract class Pegawai {

    }

    public static class AtasanLangsung extends Pegawai {

    }

    public static class Direktur extends Pegawai implements Salam {

        @Override
        public void ucapSalam(String nama) {
            System.out.println("hai, " + nama);
        }
    }

    public static class Data<T extends Pegawai & Salam> {
        private T data;

        public Data(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
}
