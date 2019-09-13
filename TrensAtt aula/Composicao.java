import java.util.ArrayList;

public class Composicao {
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;
	private int identificador;

	public Composicao(int identificador){
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		return locomotivas.size();
	}

	public Locomotiva getLocomotiva(int posicao) {
		if (posicao >= 0 && posicao < locomotivas.size()) {
			return locomotivas.get(posicao);
		} else {
			return null;
		}
	}

	public int getQtdadeVagoes() {
		return vagoes.size();
	}

	public Vagao getVagao(int posicao) {
		if (posicao >= 0 && posicao < vagoes.size()) {
			return vagoes.get(posicao);
		} else {
			return null;
		}
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		if(getQtdadeVagoes() == 0 && locomotiva.getComposicao() == -1){//pra eu poder engatar ela tem que estar livre
			locomotivas.add(locomotiva);
			locomotiva.setComposicao(this); // This é a própria classe(digo que a composição agora é essa(Dessa classe)).
			return true;
		}
		return false;
	}

	// public boolean engataVagao(Vagao vagao) {
	// 	int quantosVag = 0;
	// 	double peso = 0;
	// 	for(int i = 0; i < locomotivas.size(); i++){
	// 		quantosVag += locomotivas.get(i).getQtdadeMaxVagoes();
	// 		peso += locomotivas.get(i).getPesoMaximo();
	// 	}
	// 	if(locomotivas.size() == 1 && quantosVag != 0 && peso >= vagao.getCapacidadeCarga()){
	// 		vagoes.add(vagao);
	// 		quantosVag--;
	// 		vagao.setComposicao(this);
	// 		return true;
	// 	}else{
	// 		if(peso >= vagao.getCapacidadeCarga() && quantosVag != 0){
	// 			quantosVag = quantosVag -((quantosVag*10)/100);
	// 			vagoes.add(vagao);	
	// 			quantosVag--;
	// 			vagao.setComposicao(this);
	// 			return true;
	// 		}else{
	// 			return false;
	// 		}
	// 	}

	// }

	public boolean engataVagao(Vagao vagao){
		if(locomotivas.size() == 0 || vagao.getComposicao() != -1){
			return false;
		} else{
			int novoPeso = 0;
			if(locomotivas.size() >= 2 && vagoes.size() < calculaQtsVagoes() && calculaPesoMax() < (calculaPesoVagoes()*0.9)){
				vagao.setComposicao(this);
				vagoes.add(vagao);
			}
			else if(vagoes.size() < calculaQtsVagoes() && calculaPesoMax() < calculaPesoVagoes())
			{
				vagao.setComposicao(this);
				vagoes.add(vagao);
			}
		}
		return false;
	}

	public int calculaPesoVagoes(){
		int pesoVagoes = 0;
		for(Vagao vagao : vagoes){
			pesoVagoes += vagao.getCapacidadeCarga();
		}
		return pesoVagoes;
	}

	public int calculaPesoMax(){
		int pesoMax = 0;
		for(Locomotiva locomotiva : locomotivas){
			pesoMax += locomotiva.getPesoMaximo();
		}
		return pesoMax;
	}

	public int calculaQtsVagoes(){
		int qtsVagoes = 0;
		for(Locomotiva locomotiva : locomotivas){
			qtsVagoes += locomotiva.getQtdadeMaxVagoes();
		}
		return qtsVagoes;
	}

	public boolean desengataLocomotiva() {
		if(getQtdadeVagoes() == 0 && locomotivas.size() > 0){
			Locomotiva qualDecrementar = locomotivas.remove(locomotivas.size()-1);
			qualDecrementar.setComposicao(null);
			return true;
		}
		return false; 
	}

	public boolean desengataVagao() {
		if(vagoes.size() > 0){
			Vagao qualDecrementar = vagoes.remove(locomotivas.size()-1);
			qualDecrementar.setComposicao(null);
			return true;
		}

		return false;
	}

	public String toLineFile(){
		String aux = "";
		aux += this.getIdentificador() +",";
		aux += this.getQtdadeLocomotivas()+",";
		for(int i=0;i<this.getQtdadeLocomotivas();i++){
			aux += this.getLocomotiva(i).toLineFile()+",";
		}
		aux += this.getQtdadeVagoes()+",";
		for(int i=0;i<this.getQtdadeVagoes();i++){
			aux += this.getVagao(i).toLineFile();
			if (i<this.getQtdadeVagoes()-1){
				aux += ",";
			}
		}
		return aux;
	}
}
