import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Passaro p1 = new Passaro(10, "Pardal", 10, true, true, 19282828, 2000);

        List<Animal> list = new ArrayList<>();
        list.add(p1);
        list.add(new Passaro(11, "Catorrita", 10, true, true, 11111118, 2004));
        list.add(new Tamandua(13, "Tamandua", 70, true, true, false, false, 19111170, 2019));
        list.add(new Passaro(12, "Papagaio", 12, true, false, 12234567, 1998));
        list.add(new Passaro(14, "Papagaio", 12, true, false, 12234567, 1998));
        list.add(new Passaro(15, "Rapina", 55, true, true, 19111170, 2019));
        list.add(new Peixes(19, "Beta", 1, true, true, false));
        list.add(new Peixes(20, "Baiacu", 2, false, false, true));
        list.add(new Peixes(21, "Piranha", 2, false, true, false));
        list.add(new Peixes(22, "Tucunare", 5, false, true, false));

        printaNomes(list);

        // printPredicate(list, p -> (p.getPeso()>50) ? true:false);

        // printPredicate(list, p -> (p instanceof Passaro)? true:false);
        // System.out.println(seleciona(list, p -> {
        //     if(p instanceof Peixes){
        //         Peixes a = (Peixes) p;
        //         if(a.isAguaDoce()){
        //             return true;
        //         }
        //         return false;
        //     }
        //     return false;
        // }));

        // System.out.println(seleciona(list, f -> (f.isAguaDoce())? true:false));

        // System.out.println(seleciona(list, f -> {
        //     if(f instanceof Peixes){
        //         Peixes a = (Peixes) f;
        //         if(a.isAguaDoce()){
        //             return true;
        //         }
        //         return false;
        //     }
        //     return false;
        // }));

        
    }

    public static void printaNomes(List<Animal> l){
        l.forEach(a -> {
            if(a.isPet() &&  a.getPeso() > 50){
                System.out.println(a.getNome());
            }
        });
    }

    public static List<Animal> seleciona (List<Animal> lst, Predicate f){
        List<Animal> retorna = new ArrayList<>();
        retorna = lst.stream()
                  .filter( a -> f.test(a))
                  .collect(Collectors.toList());
        // lst.forEach(a ->{ 
        //     if(f.test(a)){
        //         retorna.add(a);
        //     }
        // });
        return retorna;
    }

    // public static List<Animal> seleciona(List<Animal> lst, Predicate <Peixes>f){
    //            List<Animal> peixes = lst.stream()
    //                                  .filter(a -> (a instanceof Peixes) && (f.test((Peixes) a)))
    //                                  .collect(Collectors.toList());
    //            return peixes;
    // }

    public static long quantosPassaros(List<Protegido> l){
        long passaros = l.stream()
                        .filter(f -> (f instanceof Passaro))
                        .count();
        return passaros;
    }

    public static List<Animal> iguais(List<Animal> l1, List<Animal> l2){
        Set<Animal> iguais = new HashSet<>(l1);
        Set<Animal> iguais2 = new HashSet<>(l2);

        List<Animal> comuns = iguais.stream()
                              .filter(a -> (iguais2.contains(a)))
                              .collect(Collectors.toList());
        return comuns;
    }


    public static void printPredicate(List<Animal> lista, Predicate<Animal> p){
        lista.forEach(a -> {if(p.test(a)){
            System.out.println(a);
        }});
    }   
}