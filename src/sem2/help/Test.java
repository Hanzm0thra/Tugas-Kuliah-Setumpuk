package sem2.help;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++)
            System.out.println(random.nextInt(2) + 1);
    }
}

class Parent {

    ArrayList<String> list = new ArrayList<>();

    public void hello() {
        System.out.println("This is parent");
    }

    public void add() {
        list.add("Array List Form Parent");
    }
}

class Child extends Parent {
    private Child instance;

    Child() {

    }

    Child getInstance() {
        if (instance == null){
            instance = new Child();
        }
        return instance;
    }
    @Override
    public void hello() {
        System.out.println("This is child");
    }

    public void setHello(String hello) {

    }
}

class Child2 extends Parent {
    @Override
    public void hello() {
        System.out.println("This is child 2");
    }
}

class Unrelated {
    private Unrelated instance;

    Unrelated getInstance() {
        if(instance == null) {
            instance = new Unrelated();
        }
        return  instance;
    }

    public void hello() {
        System.out.println("This is unrealted class");
    }
}

class SomeArrayList {
    List<SomeArrayListRecord> list = new ArrayList<>();

    public void insert(SomeArrayListRecord record) {
        list.add(record);
    }

    public void delete() {
        list.remove(null);
        list.remove(list.get(1));
    }
}

record SomeArrayListRecord(
        int id,
        String nama
) {

}

class MultiLineInput {
    Scanner scanner = new Scanner(System.in);
    String text = "";

    public void input() {
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("".equals(input))
                break;
            text = text.concat("\n").concat(input) ;
        }
        System.out.println(text);
    }
}