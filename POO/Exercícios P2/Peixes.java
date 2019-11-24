/**
 * Peixes
 */
public class Peixes extends Animal{
    private boolean aguaDoce;
    private boolean aguaSalgada;

    public Peixes(int id, String nome, float peso, boolean pet,  boolean aguaDoce, boolean aguaSalgada){
        super(id, nome, peso, pet);
        this.aguaDoce = aguaDoce;
        this.aguaSalgada = aguaSalgada;
    }

    public boolean isAguaDoce(){
        return aguaDoce;
    }

    public boolean isAguaSalgada(){
        return aguaSalgada;
    }

    @Override
    public String toString(){
        String str = super.toString();
        if(aguaDoce){
            str+= ", é de agua doce";
        }
        if(aguaSalgada){
            str+= ", é de agua salgada";
        }
        return str;
    }
    
}