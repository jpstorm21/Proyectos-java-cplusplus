
package pilajava;
import java.util.Scanner;
public class PilaJava {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("ingrese tamaño de la pila: ");
      int cant = sc.nextInt();
      Pila p = new Pila(cant);
      System.out.print("ingrese dato(Fin 999): ");
      int dato = sc.nextInt();
      while(dato != 999){
          System.out.print("ingrese [1] si desea ingresar el dato en la pila A o [2] si en la pila B: ");
          int opcion = sc.nextInt();
          if(opcion ==1){
              boolean sepudo = p.ingresarA(dato);
              if(sepudo){
                 System.out.println("dato ingresado exitosamente en la pila A"); 
              }else{
                  System.out.println("Pila llena");
                  break;
              }
          }else{
              boolean sepudo = p.ingresarB(dato);
              if(sepudo){
                  System.out.println("dato ingresado exitosamente en la pila B");
              }else{
                  System.out.println("Pila llena");
                  break;
              }
          }
          System.out.print("ingrese dato(Fin 999): ");
          dato =sc.nextInt();
      }
      System.out.println("datos: ");
      for(int i=0;i<p.getMax();i++){
          System.out.println((i+1) + ":" +p.getDato(i));
      }
    }
    
}
