package sem2.pbo.tugas8.generic1.multiparamtype;

public class PairApp {

    public static void main(String[] args) {
        Pair<String, Integer> data = new Pair<>("andi", 170);
        System.out.println(data.getFirst());
        System.out.println(data.getSecond());
    }
}
