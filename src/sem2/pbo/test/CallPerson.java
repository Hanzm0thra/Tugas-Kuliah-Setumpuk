package sem2.pbo.test;

import java.util.ArrayList;
import java.util.Scanner;

public class CallPerson {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        Scanner scanner = new Scanner(System.in);
        PersonRepository personRepository = new PersonRepository();

        personArrayList.add(
                new Person("A", "B")
        );

        personArrayList.add(
                new Person("C", "D")
        );

        String nama = scanner.nextLine();
        personRepository.setNama(nama);

        personArrayList.add(
                new Person(personRepository.getNama(), "X")
        );

        System.out.println(personArrayList);
    }
}
