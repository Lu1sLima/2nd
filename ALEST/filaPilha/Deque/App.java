/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Deque d1 = new Deque();

        d1.addFirst(20);
        d1.addLast(10);
        d1.addLast(200);
        d1.addLast(19);
        d1.addFirst(6);
        System.out.println(d1.getFirst());
        d1.removeFirst();
        d1.removeFirst();
        d1.removeFirst();
        d1.removeFirst();
        d1.removeFirst();
        System.out.println(d1.getFirst());
    }
}