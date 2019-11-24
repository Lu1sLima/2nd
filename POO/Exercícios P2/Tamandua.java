/**
 * Tamandua
 */
public class Tamandua extends Mamifero implements Protegido{
    private int nroIBAMA;
    private int anoLicenca;

    public Tamandua(int id, String nome, float peso, boolean pet, boolean carnivoro, boolean herbivoro, boolean onivoro, int nroIBAMA, int anoLicenca){
        super(id, nome, peso, pet, carnivoro, herbivoro, onivoro);
        this.nroIBAMA = nroIBAMA;
        this.anoLicenca = anoLicenca;
    }

    @Override
    public int getNroLicencaIBAMA(){
        return nroIBAMA;
    }

    @Override
    public int getAnoLicenciamento(){
        return anoLicenca;
    }

    @Override
    public String toString(){
        String str = super.toString();
        return str+", Numero de licenciamento do IBAMA: "+getNroLicencaIBAMA()+", Ano de licenciamento: "+getAnoLicenciamento();
    }
}