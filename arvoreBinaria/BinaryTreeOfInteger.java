import java.util.LinkedList;
import java.util.List;

public class BinaryTreeOfInteger {

    // Classe interna Node
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    
    // Atributos da arvore binaria
    private int count; //total de elementos da arvore
    private Node root; //referencia para o nodo raiz da arvore

    
    // Metodos da arvore binaria
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void setRoot(Integer element) {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        root.element = element;
    }

    public boolean addRoot(Integer element) {
        if (root != null) {
            return false;
        }
        Node node = new Node(element);
        root = node;
        count++;
        return true;
    }
    
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        Node res = null;
        if (target != null) {
            if (target.element.equals(element)) {
                res = target;
            } else {
                res = searchNodeRef(element, target.left);
                if (res == null) {
                    res = searchNodeRef(element, target.right);
                }
            }
        }
        return res;
    }
    

    ////////////////////////////////////////////////////
    // Implemente os metodos abaixo considerando os 
    // comentarios javadoc.
    ////////////////////////////////////////////////////
    
    /**
     * Insere um elemento a esquerda de outro elemento (pai). 
     * Caso ja tenha um elemento a esquerda do pai, ou caso o 
     * elemento pai nao seja encontrado na arvore, a insercao  
     * nao e realizada.
     * @param element elemento a ser inserido
     * @param father pai do elemento a ser inserido.
     * @return true se o elemento for inserido e false caso
     * contrario.
     */
    public boolean addLeft(Integer element, Integer father) {
        if(father == null || element == null){
            return false;
        }
        Node n = new Node(element);
        Node search = searchNodeRef(father, root);
        if(search != null){
            if(search.left == null){
                search.left = n;
                n.father = search;
                count++;
                System.out.println("Inseriu");
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     * Insere um elemento a direita de outro elemento (pai). 
     * Caso ja tenha um elemento a direita do pai, ou caso o 
     * elemento pai nao seja encontrado na arvore, a insercao  
     * nao e realizada.
     * @param element elemento a ser inserido
     * @param father pai do elemento a ser inserido.
     * @return true se o elemento for inserido e false caso
     * contrario.
     */    
    public boolean addRight(Integer element, Integer father) {
        if(element == null || father==null){
            return false;
        }
        Node n = new Node(element);
        Node searchPai = searchNodeRef(father, root);
        if(searchPai != null){
            if(searchPai.right == null){
                searchPai.right = n;
                n.father = searchPai;
                count++;
                System.out.println("Inseriu");
                return true;
            }
            return false;
        }


        return false;
    }    
    
    /**
     * Conta o total de nodos da subarvore cuja raiz esta sendo passada por 
     * parametro.
     * @param n referencia para o nodo a partir do qual sera feita a contagem
     * @return 
     */
    private int countNodes(Node n) {
        if(n == null){
            return 0;
        }
        return 1+countNodes(n.left)+countNodes(n.right);
    }

    public int retorna(){
        return countNodes(root);
    }
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pre-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger l = new LinkedListOfInteger();
        positionsPreAux(root, l);
        return l;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger lista){
        if(n != null){
            lista.add(n.element); // visita raiz;
            // percorrer subarvore da esquerda
            positionsPreAux(n.left, lista);
            // percorrer subarvore da direita
            positionsPreAux(n.right, lista);
        }
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pos-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPosAux(root, lista);
        return lista;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger l){
        if(n != null){
            // percorrer subarvore da esquerda
            positionsPosAux(n.left, l);
            // visita raiz;
            l.add(n.element);
            // percorrer subarvore da direita
            positionsPosAux(n.right, l);
        }
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */    
    public LinkedListOfInteger positionsCentral() {
        
        return null;
    }
    
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento em largura. 
     * @return LinkedListOfInteger lista com os elementos da arvore
     */  
    public LinkedListOfInteger positionsWidth() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        Queue<Node> fila = new Queue<>();
        fila.enqueue(root);
        while(!fila.isEmpty()){
            Node n = fila.dequeue();
            res.add(n.element);
            if(n.left != null){
                fila.enqueue(n.right);
            }
            if(n.right != null){
                fila.enqueue(n.right);
            }
        }

        return res;
    }
    
    /**
     * Procura pelo elemento passado por parametro e retorna o seu pai.
     * @param element elemento raiz da subarvore a ser removida.
     * @return true se o elemento passado por parametro for encontrado
     * e removido ou false caso contrario.
     */     
    public boolean removeBranch(Integer element) {
        Node search = searchNodeRef(element, root);
        // if(search != null){
        //     count = count - countNodes(search.left);
        //     search.left.father = null;
        //     search.left = null;
        //     count = count - countNodes(search.right);
        //     search.right.father = null;
        //     search.right = null;
        //     return true;
        // }
        if(search != null){
            if(search.left != null){
                count = count - countNodes(search.left);
                search.left.father = null;
                search.left = null;
            }
            if(search.right != null){
                count = count - countNodes(search.right);
                search.right.father = null;
                search.right = null;
            }
            return true;
        }
        return false;
    }        

    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */     
    public String strPositionsCentral() {
        return strPositionsCentralAux(root);
    }

    private String strPositionsCentralAux(Node n) {
        if (n == null){
            return "";
        }
        return strPositionsCentralAux(n.left)+ // percorre subarvore da esquerda
               n.element.toString()+"\n"+
               strPositionsCentralAux(n.right);
    }

    /**
     * Retorna o nivel do nodo no qual esta armazenado o elemento
     * passadado por parametro.
     * @param element o elemento que se quer saber o nivel.
     * @return o nivel do nodo onde esta o elemento, ou -1 se nao
     * encontrou o elemento.
     */
    public int level(Integer element) {
        return -1;
    }
   
    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */
    public int height() {
        return -1;
    }
    
    /**
     * Verifica se o elemento passado por parametro esta armazenado em
     * um nodo folha.
     * @param element elemento a ser encontrado.
     * @return true se o elemento esta em um nodo folha, e false caso contrario.
     */    
    public boolean isExternal(Integer element) {
        // Implemente este metodo
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro esta armazenado em
     * um nodo interno ou galho.
     * @param element elemento a ser encontrado.
     * @return true se o elemento esta em um nodo interno, e false caso contrario.
     */       
    public boolean isInternal(Integer element) {
        // Implemente este metodo
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro tem um filho na 
     * subarvore da esquerda.
     * @param element elemento a ser encontrado para verificar se possui filho 
     * a esquerda.
     * @return true se o elemento tem subarvore a esquerda, e false caso contrario.
     */     
    public boolean hasLeft(Integer element) {
        // Implemente este metodo
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro tem um filho na 
     * subarvore da direita.
     * @param element elemento a ser encontrado para verificar se possui filho
     * a direita
     * @return true se o elemento tem subarvore a direita, e false caso contrario.
     */       
    public boolean hasRight(Integer element) {
        // Implemente este metodo
        return false;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu filho da 
     * subarvore da esquerda.
     * @param element elemento a ser encontrado para retornar seu filho a esquerda.
     * @return referencia para o filho da subarvore da esquerda, ou null caso o 
     * elemento passado por parametro nao seja encontrado ou caso ele nao tenha
     * filho na subarvore da esquerda.
     */    
    public Integer getLeft(Integer element) {
        // Implemente este metodo
        return 0;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu filho da 
     * subarvore da direita.
     * @param element elemento a ser encontrado para retornar seu filho a direita.
     * @return referencia para o filho da subarvore da direita, ou null caso o 
     * elemento passado por parametro nao seja encontrado ou caso ele nao tenha
     * filho na subarvore da direita.
     */        
    public Integer getRight(Integer element) {
        // Implemente este metodo
        return 0;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu pai.
     * @param element elemento a ser encontrado para retornar seu pai.
     * @return referencia para o pai, ou null caso o elemento passado por 
     * parametro nao seja encontrado ou caso ele esteja na raiz.
     */     
    public Integer getParent(Integer element) {
        // Implemente este metodo
        return 0;
    }    
    
}
