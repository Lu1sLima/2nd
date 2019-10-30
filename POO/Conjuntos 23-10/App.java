import java.util.List;
import java.util.ArrayList;

public class App{
    public static void main(String[]args){
        
    }

    public static List <Integer> semRepeticao(List<Integer> l){
        Set<Integer> nros = new HashSet<>(l);
        return ArrayList<Integer>(nros);
    }
}