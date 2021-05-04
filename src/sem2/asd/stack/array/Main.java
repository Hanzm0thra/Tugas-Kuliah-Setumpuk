package sem2.asd.stack.array;

public class Main {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray();

        stackArray.init(10);
        stackArray.push(1);
        stackArray.push(2);

        stackArray.push(3);
        stackArray.push(4);
        stackArray.pop();
        System.out.println(stackArray.peek());
    }
}
