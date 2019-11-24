/**
 * Passaro
 */
public class Passaro extends Animal implements Protegido{
    private boolean podeVoar;
    private int nroIBAMA;
    private int anoLicenca;

    public Passaro(int id, String nome, float peso, boolean pet, boolean podeVoar, int nroIBAMA, int anoLicenca){
        super(id, nome, peso, pet);
        this.podeVoar = podeVoar;
        this.nroIBAMA = nroIBAMA;
        this.anoLicenca = anoLicenca;
    }

    public boolean podeVoar(){
        return podeVoar;
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
        String str = super.toString()+" nroLicencaIBAMA: "+nroIBAMA+", Ano Licenca: "+anoLicenca;
        return str;
    }
}