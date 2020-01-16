
package colecciones;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class Colecciones {

    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        List<Integer>ListaEnteros = new LinkedList<Integer>();
        System.out.print("ingrese dato(FIN -1): ");
        int dato = sc.nextInt();
        while(dato != -1){
            ListaEnteros.add(dato);
            System.out.print("ingrese dato(FIN -1): ");
            dato = sc.nextInt();
        }
        int i=0;
        for(Integer iterador: ListaEnteros){
            System.out.println("dato "+ (i+1) +" :" + iterador);
            i++;
        }
        System.out.print("ingrese dato a eliminar: ");
        int n = sc.nextInt();
        ListaEnteros.remove(2);
        int j=0;
        System.out.println("nueva lista");
        for(Integer iterador: ListaEnteros){
            System.out.println("dato "+ (j+1) +" :" + iterador);
            i++;
        }
    } 
}
