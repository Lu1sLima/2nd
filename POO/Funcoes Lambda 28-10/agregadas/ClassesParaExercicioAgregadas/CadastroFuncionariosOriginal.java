import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CadastroFuncionariosOriginal {
	public static final int TAM = 5;
	private List<Funcionario> lstf;

	public CadastroFuncionariosOriginal() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < TAM; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3);
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		// Retorna um clone da lista
		return new LinkedList<Funcionario>(lstf);
	}

	public void aumentoInsalubres(double taxa){
		lstf.stream()
			.filter(f -> f.getInsalubridade())
			.forEach(f -> f.aumentaSalBase(f.getSalarioBase()*taxa));
			//.filter(f -> f.getInsalubridade)
			//.filter(f -> f.getNroDependentes() > 0)
	}

	public List<String> salarioMaior10(){
		List<String> lista = lstf.stream()
							 .filter(f -> (f.getSalarioBruto()*1.1) > f.getSalarioBase())
							 .map(f -> f.getMatricula()+", "+f.getNome())
							 .collect(Collectors.toList());
		return lista;

	}

	public Double mediaSalarialNormal(){
		Double media = lstf.stream()
					   .filter(f -> !f.getInsalubridade())
					   .mapToDouble(f -> f.getSalarioBase())
					   .average().getAsDouble();
		return media;
	}

	public List<Funcionario> getInsalubresDependentes(){
		List<Funcionario> insalubres = 
		lstf.stream()
			.filter(f -> f.getInsalubridade() == true && f.getNroDependentes() > 0)
			//.filter(f -> f.getInsalubridade)
			//.filter(f -> f.getNroDependentes() > 0)
			.collect(Collectors.toList()); //reagrupa oq tem dentro do stream e retorna uma lista
		return insalubres;

	}	

	public List<String> matricula500(){
		List<String> f500 = lstf.stream()
							.filter(f -> f.getMatricula() > 500)
							.map(f -> f.getNome())
							.collect(Collectors.toList());
		return f500;
	}

	public double somaSalarios(){
		double somatorio = lstf.stream()
						   .filter(f -> f.getSalarioLiquido()>5000)
						   .mapToDouble(f -> f.getSalarioBruto())
						   .sum();
		return somatorio;	
	}

	public long temDependentes(){
		long temDependentes = lstf.stream()
						.filter(f -> f.getNroDependentes() > 0)
						.count();
		return temDependentes;
	}

	@Override
	public String toString() {
		String str = "";
		for(Funcionario f:lstf){
			str += f.toString()+"\n";
		}
		return str;
	}
}
