package sem2.asd.uts.no3;

public class A {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(new Queue.Node(34));
        queue.enqueue(new Queue.Node(38));
        queue.enqueue(new Queue.Node(45));
        queue.enqueue(new Queue.Node(50));
    }
}