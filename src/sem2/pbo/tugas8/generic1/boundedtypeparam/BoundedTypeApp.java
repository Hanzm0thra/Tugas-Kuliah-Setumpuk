package sem2.pbo.tugas8.generic1.boundedtypeparam;

public class BoundedTypeApp {

    public static void main(String[] args) {
        DataNumber<Integer> dataInteger = new DataNumber<>(200);
        DataNumber<Long> dataLong = new DataNumber<>(2L);
        //DataNumber<String> dataString = new DataNumber<String>("Tesla");

        System.out.println(dataInteger.getData());
        System.out.println(dataLong.getData());
    }

    public static class DataNumber<T extends Number> {
        private T data;

        public DataNumber(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
