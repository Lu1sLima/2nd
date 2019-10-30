import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class App{
    public static void main(String[]args){
        List<Integer> lista = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        System.out.println("Original: "+lista);
        List<Integer> l1 = aplicaOperacao(lista, (a,b) -> a+b);
        System.out.println("Editada: "+l1);

        List<Integer> l2 = aplicaOperacao(lista, (a,b) -> (int)a+b/2);
        System.out.println("Original: "+lista);
        System.out.println("Editada: "+l2); 
        
        List<Integer> l3 = aplicaOperacao(lista, (a,b) -> (a>b)?a:b);
        System.out.println("Original: "+lista);
        System.out.println("Editada: "+l3); 

                
        List<Integer> l4 = aplicaOperacao(lista, (a,b) -> {
                                                            if(a>b) return a;
                                                            else return b;
                                                            });
        System.out.println("Original: "+lista);
        System.out.println("Editada: "+l4); 
    }

    public static List<Integer> aplicaOperacao(List<Integer> lista, Operation op){
        List<Integer> novaList = new ArrayList<>();
        for (int i = 0; i < lista.size()-1; i++) {
            int aux = op.opera(lista.get(i), lista.get(i+1));
            novaList.add(aux);
        }
        return novaList;
    }
}