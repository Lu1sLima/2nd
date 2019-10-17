
import java.util.EmptyStackException;

public class ArrayStack {

    private int topo;
    private char p[];

    public ArrayStack() {
        p = new char[100];
        topo = 0;
    }

    public int size() {
        return topo;
    }

    public void push(char e) {
        if (topo >= p.length) {
            throw new StackOverflowError();
        }
        p[topo] = e;
        topo++;
    }

    public char pop() {
        if (topo == 0) {
            throw new EmptyStackException();
        }
        topo--;
        char aux = p[topo];
        p[topo] = ' ';
        return aux;
    }

    public char top() {
        if (topo == 0) {
            throw new EmptyStackException();
        }
        return p[topo - 1];
    }

    public boolean isEmpty() {
        return (topo == 0);
    }

    public void clear() {
        p = new char[100];
        topo = 0;
    }
}
