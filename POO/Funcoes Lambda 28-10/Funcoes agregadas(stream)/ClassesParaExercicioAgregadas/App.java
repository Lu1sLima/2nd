public class App{
    public static void main(String[]args){
        CadastroFuncionariosOriginal c1 = new CadastroFuncionariosOriginal();
        System.out.println(c1);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Quais funcionários ganham insalubridade? ");
        c1.getInsalubresDependentes().forEach(f -> System.out.println(f.toString()));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Quantos funcionários tem dependendes? "+c1.temDependentes());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Somatório dos salários: "+c1.somaSalarios());
    }
}