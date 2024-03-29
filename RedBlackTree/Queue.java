
import java.util.LinkedList;

public class Queue<E> {

    private LinkedList<E> fila;

    public Queue() {
        fila = new LinkedList();
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public E head() throws EmptyQueueException {
        if (fila.isEmpty()) {
            throw new EmptyQueueException("A fila esta vazia");
        } else {
            E elem = fila.get(0);
            return elem;
        }
    }

    public void enqueue(E element) {
        fila.add(element);
    }

    public E dequeue() throws EmptyQueueException {
        if (fila.isEmpty()) {
            throw new EmptyQueueException("Queue is empty!");
        } else {
            E elem = fila.remove(0);
            return elem;            
        }
    }

    public void clear() {
        fila.clear();
    }
}
