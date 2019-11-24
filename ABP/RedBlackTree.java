

public class RedBlackTree {
    
    // Classe interna privada
    private static final class Node {
        public Integer element;
        public Node father;
        public Node left;
        public Node right;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            red = true;
            black = false;
            this.element = element;
        }
    }

    
    // Atributos        
    private int count; //contador do numero de nodos
    private Node root; //referencia para o nodo raiz


    // Metodos
    public RedBlackTree() {
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

    private Node searchNodeRef(Integer element, Node target) {
        int r;

        if (element == null || target == null) {
            return null;
        }

        r = target.element.compareTo(element);

        if (r == 0) {
            return target;
        } else if (r > 0) {
            return searchNodeRef(element, target.left);
        } else {
            return searchNodeRef(element, target.right);
        }
    }      

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }
    
    public Integer getLeft(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.left != null) {
                res = nAux.left.element;
            }
        }
        return res;
    }

    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    public boolean isRoot(Integer element) {
        if (root != null) {
            if (root.element.equals(element)) {
                return true;
            }
        }
        return false;
    }    
    
    /**
     * Conta o total de nodos da subarvore cuja raiz esta sendo passada por 
     * parametro.
     * @param n referencia para o nodo a partir do qual sera feita a contagem
     * @return total de elementos da subarvore
     */
    private int countNodes(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + countNodes(n.left) + countNodes(n.right);
        }
    }  
    
    /**
     * Retorna uma lista com todos os elementos da arvore. Os elementos
     * sao colocados na lista seguindo um caminhamento prefixado.
     * @return lista com os elementos da arvore na ordem prefixada
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }
    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subarvore esquerda
            positionsPreAux(n.right, res); //Visita a subarvore direita
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore. Os elementos
     * sao colocados na lista seguindo um caminhamento central.
     * @return lista com os elementos da arvore na ordem central
     */    
    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }
    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subarvore esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subarvore direita
        }
    }

    /**
     * Procura pelo menor elemento da subarvore cuja raiz eh passada por
     * parametro,e retorna a referencia para o nodo no qual este elemento
     * esta armazenado.
     * @param n referencia para a raiz da subarvore na qual deve ser 
     * feita a busca.
     * @return referencia para o Node que contem o menor elemento da
     * subarvore.
     */
    private Node smallest(Node n) {
        if (n == null) {
            return null;
        }
        if (n.left == null) {
            return n;
        }
        return smallest(n.left);
    }
    
    /**
     * Adiciona o elemento passado por parametro na arvore. 
     * @param element elemento a ser adicionado na arvore.
     */
    public void add(Integer element) {
        Node n = new Node(element);
        if(root == null){

        }
    }
    private Node add(Node n, Integer e, Node father) {
        if (n == null) {
            Node aux = new Node(e);
            aux.father = father;
            return aux;
        }
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        } else {
            n.left = add(n.left, e, n);
        }
        return n;
    }     
    
    
    
    ////////////////////////////////////////////////////
    // Implemente os métodos abaixo
    ////////////////////////////////////////////////////
    
    /**
     * Remove da arvore o elemento passado como parametro, mantendo as 
     * propriedades da ABP.
     * @param element elemento a ser removido.
     * @return true se achou o elemento e fez a remocao, e false caso 
     * contrario.
     */
    public boolean remove(Integer element) {
        if(root == null || element == null){
            return false;
        }

        Node n = searchNodeRef(element, root);

        if(n == null){ // nao achei
            return false;
        }

        remove(n); // metodo auxiliar privado!
        count--;
        return true;
    }

    private void remove(Node n){
        // quando tem dois filhos eu pego o menor do lado direito e boto no lugar 
        Node pai = n.father;
        if(n.left == null && n.right == null){ //remove nodo folha
            if(n == root){
                root = null;
            }
            else{
                if(pai.left == n){
                    pai.left = null;
                }
                else{
                    pai.right = null;
                }
                n.father = null;
            }
        }
        else if(n.left != null && n.right == null){ //remove de nodo com filho a esquerda
            if(root == n){
                root = n.left;
                root.father = null;
            }
            else{
                if(pai.left == n){
                    pai.left = n.left;
                }
                else{
                    pai.right = n.left;
                }
                n.left.father = pai;
            }
        }
        else if(n.left == null && n.right == null){ // remove de nodo com filho a direita
            if(root == n){
                root = n.right;
                root.father = null;
            }
            else{
                if(pai.left == n){
                    pai.left = n.right;
                }
                else{
                    pai.right = n.right;
                }
                n.right.father = pai;
            }
        }
        else{ //remove nodo com 2 filhos

            Node s = smallest(n.right);
            n.element = s.element;
            remove(s);
        }
    }


    // public Integer countLeaf(Node n){
    //     if(root == null){
    //         return 0;
    //     }
    //     Integer countL = 0;
    //     if(n.left != null){
    //         countL = countLeaf(n.left);
    //     }
    // }
    
    /**
     * Retorna o maior elemento armazenado na ABP.
     * @return Integer o maior elemento da arvore.
     */
    public Integer getBiggest() {
        return null;
    }
    
    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */    
    public int height() {        
        return height(root);
    }

    private int height(Node n){
        if(n == null){
            return -1;
            System.out.println("entrou");
        }
        int left = height(n.left);
        int right = height(n.right);

        return 1 + Math.max(height(n.left), height(n.right));
    }
    
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento em largura. 
     * @return LinkedListOfInteger lista com os elementos da arvore
     */     
    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        LinkedListOfInteger res = new LinkedListOfInteger();
        // Implemente este metodo 
        return res;
    }    

    
    /**
     * Retorna o elemento que eh o filho a direita do elemento 
     * passado por parametro.
     * @param element do qual se quer saber quem eh o filho a direita.
     * @return fiho da direita do elemento passado por parametro.
     */    
    public Integer getRight(Integer element) {
        Node n = searchNodeRef(element, root);
        if(n != null){
            return n.right.element;
        }
        return null;

    }

    /**
     * Retorna o elemento que eh o pai do elemento passado por
     * parametro.
     * @param element do qual se quer saber quem eh o pai.
     * @return pai do elemento passado por parametro.
     */
    public Integer getParent(Integer element) {
        Node n = searchNodeRef(element, root);
        if(n != null){
            return n.father.element;
        }     
        return null;
    }    

    /**
     * Remove um galho da árvore. A raiz deste galho eh o nodo que contem 
     * o elemento passado por parâmetro (element). Caso "element" nao esteja
     * na arvore, nao eh feita a remocao e o metodo retorna false.
     * @param element raiz da subarvore que deve ser removida
     * @return true se houve a remocao do galho, false caso contrario.
     */
    public boolean removeBranch(Integer element) {
        Node n = searchNodeRef(element, root);
        if(n == null){
            return false;
        }
        Node pai = n.father;
        if(n == root){
            root = null;
        }
        else{
            if(pai.left == n){
                pai.left = null;
            }
            else{
                pai.right = null;
            }
        }
        count = count-countNodes(n);
        return true;

    }
    
    /**
     * Retorna o nivel do nodo no qual esta armazenado o elemento
     * passadado por parametro.
     * @param element o elemento que se quer saber o nivel.
     * @return o nivel do nodo onde esta o elemento, ou -1 se nao
     * encontrou o elemento.
     */
    public int level(Integer element) {
        //Implemente este metodo
        return 0;
    }    
    
    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento pre-fixada. Chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */        
    public String strTraversalPre() {
        return strTraversalPre(root);
    }
    private String strTraversalPre(Node n) {
        String res = "";
        // Implemente este metodo
        return res;
    }

    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento pos-fixada. Chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */       
    public String strTraversalPos() {
        return strTraversalPos(root);
    }
    private String strTraversalPos(Node n) {
        String res = "";
        // Implemente este metodo
        return res;
    }

    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento central. Chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */       
    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }
    private String strTraversalCentral(Node n) {
        String res = "";
        // Implemente este metodo
        return res;
    }    
    
    /**
     * Retorna uma copia da arvore.
     * @return BinarySearchTreeOfInteger com uma copia desta ABP.
     */
    @Override
    public BinarySearchTreeOfInteger clone() {
        return null;
    }
    
}
