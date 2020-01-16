
package pruebapasada;
import java.util.Scanner;
public class PruebaPasada {

    public static boolean Balance(String p){
        char [] frase = p.toCharArray();
        int cantAbiertos = 0;
        int cantCerrados = 0;
        int pos =0;
        return balance(frase,cantAbiertos,cantCerrados,pos);
    }
    private static boolean balance( char [] frase, int cantAbiertos , int cantCerrados ,int pos){
        if(pos < frase.length){
            if(frase[pos] == '('){
                cantAbiertos++;
                pos++;
                return balance(frase,cantAbiertos,cantCerrados,pos);
            }else{
                if(frase[pos] == ')'){
                    cantCerrados++;
                    pos++;
                    return balance(frase,cantAbiertos,cantCerrados,pos);                          
                }
            }
        }
        if(cantAbiertos == cantCerrados){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("ingrese palabra: ");
        String p = sc.next();
        boolean Balance = PruebaPasada.Balance(p);
        if(Balance == true){
            System.out.println("palabra balanceada");
        }else{
            System.out.println("palabra no balanceada");
        }
    }   
}
