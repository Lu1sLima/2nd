public class App{
    public static void main(String[]args){
        DoublyLinkedStack pilha = new DoublyLinkedStack();

        pilha.push(1.0);
        pilha.push(2.5);
        pilha.push(2.4);
        pilha.push(3.9);

        System.out.println(pilha);
    }
}