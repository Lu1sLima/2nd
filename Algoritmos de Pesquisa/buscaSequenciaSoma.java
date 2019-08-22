public class Main{
  public static void main(String[]args){
    int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    System.out.println(calculaSeq(vet));

  }

  public static int calculaSeq(int [] vet){
    int soma = 0;
    int cont = 0;
    for(int i = 0; i < vet.length; i++){
      soma = vet[i];
      for(int j = i+1; j < vet.length; j++){
        soma += vet[j];
        if(soma == 16){
          cont++;
          break;
        }

      }
    }
    return cont;
  }
}
