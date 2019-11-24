
public class App {
    public static void main(String[] args) {
        RedBlackTree b = new RedBlackTree();
        b.add(9);
        System.out.println(b.getRoot());
        System.out.println(b.getLeft(9));
        System.out.println(b.level(9));
    }   
}
