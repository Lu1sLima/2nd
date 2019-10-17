
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
        // Deque deq = new Deque();
        // deq.addFirst(1);
        // deq.addFirst(2);
        // deq.addFirst(3);
        // deq.addFirst(4);
        // deq.addLast(999);
        // System.out.println(deq.removeLast());     
        // System.out.println(deq.getLast()); 


            String teste = "(){[()]}[()()]";

            System.out.println(verificaParenteses(teste));

    }
    //LEMBRAR DO BREAK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public static boolean verificaParenteses(String s){
            ArrayStack pilha = new ArrayStack();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                    pilha.push(s.charAt(i));
                   // System.out.println(s.charAt(i)+", tam pilha="+pilha.size());
                   // System.out.println("---------------");
                }
                else{

                    switch(s.charAt(i)){
                        case ']':
                            if(pilha.pop() != '['){
                                return false;
                            }
                            break;
                        case '}':
                        //System.out.println(s.charAt(i)+", tam pilha="+pilha.size());
                            if(pilha.pop() != '{'){
                                return false;
                            }
                            break;
                        case ')':
                            if(pilha.pop() != '('){
                                return false;
                            }
                            break;
                    }
                }
            }
        
        return true;
    }

}
