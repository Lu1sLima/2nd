import javax.management.RuntimeErrorException;

public class Deque{
    private ArrayStack pilha1;
    private ArrayStack pilha2;

    public Deque(){
        pilha1 = new ArrayStack();
        pilha2 = new ArrayStack();
    }

    public void addFirst(Integer e){
        pilha1.push(e);
    }

    public void addLast(Integer e){
        pilha2.push(e);
    }

    public int size(){
        return pilha1.size()+pilha2.size();
    }

    public Integer getFirst(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }

        if(!pilha1.isEmpty()){
            return pilha1.top();
        }
        else{
            while(!pilha2.isEmpty()){
                pilha1.push(pilha2.pop());
            }
            int aux = pilha1.top();
            //tem q devolver pra pilha2 agora!
            while(!pilha1.isEmpty()){
                pilha2.push(pilha1.pop());
            }
            return aux;
        }
    }

    public int getLast(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio");
        }
        if(!pilha2.isEmpty()){
            return pilha2.top();
        }
        else{
            while(!pilha1.isEmpty()){
                pilha2.push(pilha1.pop());
            }
            int aux = pilha2.top();
            while(!pilha2.isEmpty()){
                pilha1.push(pilha2.pop());
            }
            return aux;
        }
    }

    public int removeFirst(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }
        if(!pilha1.isEmpty()){
            return pilha1.pop();
        }
        else{
            while(!pilha1.isEmpty()){
                pilha1.push(pilha2.pop());
            }
            int aux = pilha1.pop();
           while(!pilha2.isEmpty()){
                pilha2.push(pilha1.pop());
            }
            return aux;
        }
    }

    public int removeLast(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio");
        }
        if(!pilha2.isEmpty()){
            return pilha2.pop();
        }
        else{
            while(!pilha2.isEmpty()){
                pilha2.push(pilha1.pop());
            }
            int aux = pilha2.pop();
            while(!pilha1.isEmpty()) {
                pilha1.push(pilha2.pop());
            }
            return aux;
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }




}