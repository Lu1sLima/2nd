import java.util.Scanner;

class NewAppV3 {
    private CadastroLocomotivas c1;
    private CadastroVagoes cv;
    private CadastroComposicoes cc;

    public App(){ //garante que tem os 3 cadastros estanciados na memória com os arquivos que estiverm no disco
        c1 = new CadastroLocomotivas();
        c1.carrega(); // carregando os bgl 
        cv = new CadastroVagoes();
        cv.carrega();
        cc = new CadastroComposicoes();
        cc.carrega();
    }

    public void locomotivasLivres(){
        for(int i = 0; i < c1.qtdade(); i++){
            System.out.println(c1.getPorPosicao(i));
        }
    }

    public void vagoesLivres(){
        for(int i = 0; i < c1.qtdade(); i++){
            System.out.println(c1.getPorPosicao(i));
        }
    }

  public void criaComposicao(){
      System.out.println("Qual locomotiva você quer cadastrar?\nVou mostar as disponíveis: ");
      for(int i = 0; i< c1.qtdade(); i++){
          System.out.println(c1.getPorPosicao(i));
      }
      System.out.println("Qual você quer adicionar?");



  }

  public void editaComposicao(int identificador){ //
    Scanner input = new Scanner(System.in);
    Composicao c1 = data.getPorIdentificador(identificador);
    int op = 0;
    do{
      System.out.println("O que deseja fazer?");
      System.out.println("1 - Inserir uma locomotiva;\n2 - Inserir um vagão;\n3 - Remover o último elemento da composição;\n4 - Listar locomotivas livres;\n 5 - Listar vagões livres;\n6 - Encerrar;");
       op = input.nextInt();
    }while(op <= 0 || op >= 7);

    switch(op){
      case 1:
        System.out.println("Informe as configurações da locomotiva: ");
        System.out.println("Identificador: ");
        int identi = input.nextInt();
        System.out.println("Peso Máximo: ");
        double pesoMax = input.nextDouble();
        int qtdVagoes = 10;
        if(c1.engataLocomotiva(new Locomotiva(identi, pesoMax, qtdVagoes))){
          System.out.println("Adicionado com sucesso!");
          break;
        }
        System.out.println("Ocorreu um erro!");

      case 2:
        System.out.println("Informe as configurações do vagão: ");
        System.out.println("Identificador: ");
        int identif = input.nextInt();
        System.out.println("Capacidade de carga do vagão: ");
        double capacidadeCarga = input.nextDouble();
        if(c1.engataVagao(new Vagao(identif, capacidadeCarga))){
          System.out.println("Adicionado com sucesso!");
          break;
        }else{
          System.out.println("Ocorreu um erro!");
          break;
        }

      case 3:
        if(c1.getQtdadeVagoes() == 0){
          c1.desengataLocomotiva();
          break;
        }
        else{
          c1.desengataVagao();
          break;
        }

      case 4:
        //NAO SABEMOS
      case 5:
        //NAO SABEMOS
      default:
       break;  

    }

  }

  public void listaComposicoesEditadas(){
    //3-	Listar todas as composições editadas
    // NAO SABEMOS FAZER
  }
  
  public void removeComposicao(int identificador){
    Composicao c1 = data.getPorIdentificador(identificador);
    for(int i = 0; i < c1.getQtdadeVagoes(); i++){
      c1.desengataVagao();
    }
    for(int j = 0; j < c1.getQtdadeLocomotivas(); j++){
      c1.desengataLocomotiva();
    }
    data.removePorId(identificador);
  }

  public void Menu(){
      int op = input.nextInt();
    switch(op); // botar iso 
      case 1:
        criaComposicao();
        break;
      case 2:
        editarComposicao();
        break;
      case 3:
        listaComposicao();
        break;
      case 4:
        c1.persiste();
        cv.persiste();
        cc.persiste();
        System.exit(0);
        
  }

  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    App ap = new App(); // pra ter acesso aos bgl do app
    //ou faz um ap.menu();
    int op = input.nextInt();
    switch(op); // botar iso 
      case 1:
        ap.criaComposicao();
        break;
      case 2:
        ap.editarComposicao();
        break;
      case 3:
        ap.listaComposicao();
        break;
      case 4:
        c1.persiste();
        cv.persiste();
        cc.persiste();
        System.exit(0);
    default:
        System.out.println("Escolha uma opção certa!");
        


  }
}