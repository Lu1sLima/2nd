public class DoublyLinkedStack{
    private Node trailer;
    private Node header;
    private int count = 0;

    public class Node{
        public Double element;
        public Node next;
        public Node prev;

        public Node(Double c){
            element = c;
            next = null;
            prev = null;
        }
    }

        public DoublyLinkedStack(){
            trailer = new Node(null);
            header = new Node(null);
            header.next = trailer;
            trailer.prev = header;
        }

        public void push(Double c){
            Node ch = new Node(c);
            ch.prev = trailer.prev;
            trailer.prev.next = ch;
            trailer.prev = ch;
            ch.next = trailer;
            count++;
        }

        public Double pop(){
            if(count == 0)
                throw new IndexOutOfBoundsException();
            Double ch = trailer.prev.element;
            trailer.prev.prev.next = trailer;
            trailer.prev = trailer.prev.prev;
            count--;
            return ch;
        }

        public Double top(){
            return trailer.prev.element;
        }

        public int size(){
            return count;
        }

        public boolean isEmpty(){
            return count == 0;
        }

        public void clear(){
            header.next = trailer;
            trailer.prev = header;
            count = 0;
        }

        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            Node aux = header;
            s.append("[");
            for (int i = 0; i < count; i++) {
                aux = aux.next;
                s.append(aux.element);
                if(i != count-1){
                    s.append(",");
                }
            }
            s.append("]");
            return s.toString();
        }

}