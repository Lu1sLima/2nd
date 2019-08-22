import java.util.Scanner;
public class BinarySearch{
    public static void main(String[]args){
        int [] vet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner input = new Scanner(System.in);


        int num = input.nextInt();
        System.out.println(binarySearch(vet, num));

    }

    public static int binarySearch(int [] vet, int num){
        int min = 0;
        int max = vet.length-1;
        while(min <= max){
            int mid = (min+max)/2;
            if(vet[mid] == num){
                return mid;
            }else{
                if(vet[mid] > num){
                    max = mid-1;
                }else{
                    min = mid+1;
                }
            }
        }
        return -1;
    }
}