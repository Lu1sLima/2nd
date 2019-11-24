/**
 * Mamifero
 */
public class Mamifero extends Animal{
    private boolean carnivoro;
    private boolean herbivoro;
    private boolean onivoro;

    public Mamifero(int id, String nome, float peso, boolean pet, boolean carnivoro, boolean herbivoro, boolean onivoro){
        super(id, nome, peso, pet);
        this.carnivoro = carnivoro;
        this.herbivoro = herbivoro;
        this.onivoro = onivoro;
    }

    public boolean isCarnivoro(){
        return carnivoro;
    }

    public boolean isHerbivoro(){
        return herbivoro;
    }

    public boolean isOnivoro(){
        return onivoro;
    }

    @Override
    public String toString(){
        String str = super.toString();
        if(this.isCarnivoro()){
            str += ", é Carnivoro";
        }
        if(this.isHerbivoro()){
            str += ", é Herbivoro";
        }
        if(this.isOnivoro()){
            str += ", é Herbivoro";
        }
        return str;
    }
}