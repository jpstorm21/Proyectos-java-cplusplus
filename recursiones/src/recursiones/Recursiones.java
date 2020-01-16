
package recursiones;
import java.util.Scanner;
public class Recursiones {

    public static int exponente(int base,int exp){
        return recexponente(base,exp);
     }
    private static int recexponente(int base, int exp){
        if( exp ==0){
            return 1;
        }else{
            return base*recexponente(base,exp-1);
        }
    }
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("ingrese base : ");
      int base = sc.nextInt();
      System.out.print("ingrese exponenete: ");
      int exp = sc.nextInt();
      int resultado = exponente(base,exp);
      System.out.println("resultado = " + resultado);
    }
    
}
