
public class App {
    public static void main(String[] args) {
        // LinkedQueue queue = new LinkedQueue();
        // queue.enqueue(1);
        // queue.enqueue(2);
        // queue.enqueue(3);
        // while (!queue.isEmpty()) {
        //     Integer aux = queue.dequeue(); // remove da fila
        //     System.out.println(aux); // imprime
        // }
        
        // ArrayStack stack = new ArrayStack();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }  
        Deque deq = new Deque();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);
        deq.addFirst(4);
        deq.addLast(999);
        System.out.println(deq.removeLast());     
        System.out.println(deq.getLast()); 
    }
}
