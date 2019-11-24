/**
 * Deque
 */
public class Deque {
    private ArrayStack pilhaInicio;
    private ArrayStack pilhaFim;

    public Deque(){
        this.pilhaInicio = new ArrayStack();
        this.pilhaFim = new ArrayStack();
    }

    void addFirst(Integer element){
        pilhaInicio.push(element);
    }

    void addLast(Integer element){
        pilhaFim.push(element);
    }

    public int size(){
        return pilhaInicio.size()+pilhaFim.size();
    }

    public Integer removeFirst(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }

        if(!pilhaInicio.isEmpty()){
            return pilhaInicio.pop();
        }
        else{
            while(!pilhaFim.isEmpty()){
                pilhaInicio.push(pilhaFim.pop());
            }
            Integer aux = pilhaInicio.pop();
            while(!pilhaInicio.isEmpty()){
                pilhaFim.push(pilhaInicio.pop());
            }
            return aux;
        }
    }

    public Integer removeLast(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }

        if(!pilhaFim.isEmpty()){
            return pilhaFim.pop();
        }
        else{
            while(!pilhaInicio.isEmpty()){
                pilhaFim.push(pilhaInicio.pop());
            }
            Integer aux = pilhaFim.pop();
            while(!pilhaFim.isEmpty()){
                pilhaInicio.push(pilhaFim.pop());
            }
            return aux;
        }
    }


    public Integer getFirst(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }

        if(!pilhaInicio.isEmpty()){
            return pilhaInicio.top();
        }
        else{
            while(!pilhaFim.isEmpty()){
                pilhaInicio.push(pilhaFim.pop()); 
            }
            Integer aux = pilhaInicio.top();
            while(!pilhaInicio.isEmpty()){ 
                pilhaFim.push(pilhaInicio.pop());
            }
            return aux;
        }
    }

    public Integer getLast(){
        if(size() == 0){
            throw new RuntimeException("Deque vazio!");
        }

        if(!pilhaFim.isEmpty()){
            return pilhaFim.top();
        }
        else{
            while(!pilhaInicio.isEmpty()){
                pilhaFim.push(pilhaInicio.pop());
            }
            Integer aux = pilhaFim.top();
            while(!pilhaFim.isEmpty()){
                pilhaInicio.push(pilhaFim.pop());
            }
            return aux;
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }


}