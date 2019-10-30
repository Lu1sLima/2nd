import java.util.*;
import java.util.List;
import java.util.function.*;
public class App2{
    // public static void printa(List<Integer> lista, intToStr o){
    //     for (Integer inteiro : lista) {
    //         System.out.println(o.change(inteiro));
    //     }
    // }

    public static void printa(List<Integer> lista, Function<Integer, String> o){
        for (Integer inteiro : lista) {
            System.out.println(o.apply(inteiro));
        }
    }

    public static void main(String[]args){
        List <Integer> l1 = Arrays.asList(100, 499, 999, 10, -88, 4, -1);
        printa(l1, x -> "R$ "+x+",00");
        System.out.println("---------------------------------------------------------------------------");
        printa(l1, x ->(x>0)?"<C>"+x : "<D>"+Math.abs(x));
    }
}