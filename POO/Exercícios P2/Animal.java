/**
 * Animal
 */
public class Animal {

    private String nome;
    private int id;
    private float peso;
    private boolean pet;

    public Animal(int id, String nome, float peso, boolean pet){
        this.peso = peso;
        this.id = id;
        this.nome = nome;
        this.pet = pet;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public float getPeso(){
        return peso;
    }

    public boolean isPet(){
        return pet;
    }

    public boolean mesmaCategoria(Animal outro){
        if(Math.abs(this.getPeso() - outro.getPeso()) > 5 ){
            return false;
        }
        else{
            return true;
        }
    }

    public String toString(){
        String str = getNome()+ ", " +getPeso()+ "kgs";

        if(isPet()){
            str += ", é um pet";
        }

        return str;
    }

}