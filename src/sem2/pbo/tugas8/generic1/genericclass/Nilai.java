package sem2.pbo.tugas8.generic1.genericclass;

public class Nilai <T>{
    private T Data;

    public Nilai(T data) {
        this.Data = data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
