
import java.util.LinkedList;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {
        // Atributos da classe Node
        public Node father;
        public Integer element;
        public LinkedList<Node> subtrees;
        // Métodos da classe Node
        public Node(Integer element) {
            father = null;
            this.element = element;
            subtrees = new LinkedList<>();
        }
        private void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }
        private boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }
        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }
        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    
    
    // Atributos da classe GeneralTreeOfInteger
    private Node root;
    private int count;

    
    
    // Metodos da classe GeneralTreeOfInteger
    
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }
    
    private Node searchNodeRef(Integer elem, Node n) {
        Node aux = null;
        
        if ( n != null ) {
            if ( n.element.equals(elem)) { // "Visita a raiz" (todo nodo é raiz de uma subárvore)
                aux = n; // Achou o elemento e retorna referência para o nodo onde ele está armazenado
            }
            else { // "Visita subárvores"
                for (int i=0; i<n.getSubtreesSize(); i++) {
                    aux = searchNodeRef(elem, n.getSubtree(i));
                    if (aux != null) {
                        break;
                    }
                }
            }
        }
        return aux;
    }
    
    public boolean add(Integer elem, Integer father) {
        Node n = new Node(elem);
        
        if (father == null) { // Insere o elemento como raiz
            if (root == null) {
                root = n;
            } 
            else {
                root.father = n;
                n.addSubtree(root);
                root = n;
            }
            count++;
            return true;
        }
        else { // Procura pelo pai
            Node refParaPai = searchNodeRef(father,root);
            if (refParaPai == null) {
                return false;
            }
            else {
                n.father = refParaPai;
                refParaPai.addSubtree(n);
                count ++;
                return true;
            }
        }
    }
    
    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento em largura
    public LinkedList<Integer> positionsWidth() {
        LinkedList<Integer> lista = new LinkedList<>();
        Queue<Node> fila = new Queue<>();
        if(root != null){
            fila.enqueue(root);
            while(!fila.isEmpty()){
                Node qual = fila.dequeue();
                lista.add(qual.element);
                for(int i = 0; i < qual.getSubtreesSize(); i++){
                    fila.enqueue(qual.getSubtree(i));
                }
            }
        }
        
        return lista;
    }    
    
    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento pré-fixado
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root,lista);
        return lista;
    }  
    
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            lista.add(n.element);
            for (int i = 0; i < n.getSubtreesSize(); i++) {
                positionsPreAux(n.getSubtree(i), lista);
            }
        } 
    }

    // Retorna uma lista com todos os elementos da árvore numa ordem de 
    // caminhamento pós-fixado
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root,lista);
        return lista;
    }  
    
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            for (int i = 0; i < n.getSubtreesSize(); i++) {
                positionsPosAux(n.getSubtree(i), lista);
            }
            lista.add(n.element);
        }
    }    
    
    // Retorna em que nível o elemento está 
    // Vou pegando os pais até chegar no root
    public int level(Integer element) {
        if(element == null){
            return -1;
        }
        Node n = searchNodeRef(element, root);
        if(n == null){ // nao achou na lista
            return -1;
        }
        int level = 0;
        while(n != root){
            n = n.father;
            level++;
        }
        return level;
       
    }     
    
    // Remove um galho da arvore
    // desafio: contar quantos nodos tinha na árvore para atualizar o count
    public boolean removeBranch(Integer element) { 
        Node n = searchNodeRef(element, root);
        if(root == null){ // ou count 0
            return false;
        }
        else if(root.element.equals(element)){
            root = null;
            count = 0;
            return true;
        }
        else if(n == null){
            return false;
        }
        int c = countNodes(n);
        count = count-c;
        //Retira da arvore a referencia para o galho
        n.father.removeSubtree(n); //removi do meu pai a referencia para mim
        n.father = null; // opcional
        return true;
        
    }

    // Conta o numero de nodos da subarvore suja raiz eh passada por parametro
    private int countNodes(Node n) {
        if(n == null){
            return 0;
        }
        int contFilhos = 0;
        for(int i = 0; i < n.getSubtreesSize(); i++){
            contFilhos += countNodes(n.getSubtree(i));
        }
        return 1+contFilhos;
        
    }
    
    public boolean isExternal(Integer element){
        Node n = searchNodeRef(element, root);
        if(n != null){
            return (n.getSubtreesSize() == 0);
        }
        else{
            return false;
        }
    }
}
