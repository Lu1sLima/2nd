/**
 * FilaPilha
 */
public class FilaPilha {
    private ArrayStack pilhaQueue;
    private ArrayStack pilhaDequeue;

    public FilaPilha(){
        pilhaQueue = new ArrayStack();
        pilhaDequeue = new ArrayStack();
    }

    public void enqueue(Integer element){
        pilhaQueue.push(element);
    }

    public int size(){
        return pilhaQueue.size();
    }

    public Integer dequeue(){
        if(size() == 0){
            throw new RuntimeException("Fila vazia!!");
        }
        if(size() == 1){
            return pilhaQueue.pop();
        }
        else{
            while(!pilhaQueue.isEmpty()){
                pilhaDequeue.push(pilhaQueue.pop());
            }
            Integer aux = pilhaDequeue.pop();
            while(!pilhaDequeue.isEmpty()){
                pilhaQueue.push(pilhaDequeue.pop());
            }
            return aux;
        }
    }

    public Integer front(){
        if(size() == 0){
            throw new RuntimeException("Fila vazia!!");
        }
        if(size() == 1){
            return pilhaQueue.top();
        }
        else{
            while(!pilhaQueue.isEmpty()){
                pilhaDequeue.push(pilhaQueue.pop());
            }
            Integer aux = pilhaDeque.top();

            while(!pilhaDequeue.isEmpty()){
                pilhaQueue.push(pilhaDequeue.pop());
            }
            return aux;
        }

    }
}