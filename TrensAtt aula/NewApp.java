import java.util.Scanner;
import java.util.ArrayList;
public class NewApp{
    private static ArrayList <Composicao> composicoes; // PODE SER STATIC, NÉ?
    static Scanner input = new Scanner(System.in);

    public static void CriaComposicao(int identificador, Locomotiva locomotiva){
        Composicao c1 = new Composicao(identificador);
        c1.engataLocomotiva(locomotiva);
        composicoes.add(c1);


    }

    public static void editaComposicao(int qualComposicao){ // grande dúvida
        Composicao essa = null; // variável auxiliar(irá guardar qual composição a pessoa quer editar)
        for(Composicao composicao : composicoes){ //procurando se tem uma composição com esse identificador na lista de composicoes
            if(composicao.getIdentificador() == qualComposicao){
                essa = composicao;
            }
            else if(composicao == composicoes.get(composicoes.size()-1)){
                System.out.println("Composição não encontrada!");
            }
        }
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Inserir uma locomotiva;\n2 - Inserir um vagão;\n3 - Remover o último elemento da composição;\n4 - Listar locomotivas livres;\n 5 - Listar vagões livres;\n6 - Encerrar;");
        int op = input.nextInt();

        switch(op){
            case 1:
                System.out.println("Informe as configurações da locomotiva: ");
                System.out.println("Identificador: ");
                int identi = input.nextInt();
                System.out.println("Peso Máximo: ");
                double pesoMax = input.nextDouble();
                int qtVagoes = 10;
                if(essa.engataLocomotiva(new Locomotiva(identi, pesoMax, qtVagoes))){ // adicionando uma locomotiva nessa composição.
                    System.out.println("Adicionado com sucesso!");
                    break;
                }else{
                    System.out.println("Ocorreu um erro!");
                    break;
                }
            case 2:
                System.out.println("Informe as configurações do vagão: ");
                System.out.println("Identificador: ");
                int identif = input.nextInt();
                System.out.println("Capacidade de carga do vagão: ");
                double capacidadeCarga = input.nextDouble();
                if(essa.engataVagao(new Vagao(identif, capacidadeCarga))){
                    System.out.println("Adicionado com sucesso!");
                    break;
                } else{
                    System.out.println("Ocorreu um erro!");
                    break;
                }
            case 3:
                // •	Remover o último elemento da composição // nao entendi!
            case 4:
                // •	Listar locomotivas livres
                // •    Listar vagões livres
            case 5:
                break;
            default:
                break;
        }
    }


    public static ArrayList<Composicao> retornaComposicoes(){
        return composicoes; // retorna todos os elementos do array de composicoes
    }



}