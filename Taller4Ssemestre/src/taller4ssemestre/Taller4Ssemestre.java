
package taller4ssemestre;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
public class Taller4Ssemestre {

    public static void main(String[] args)throws FileNotFoundException {
        Interface sistema = new SistemaMensajeria();
        Scanner sc = new Scanner(System.in);
        sistema.leerAsignatuas();
        sistema.leerPersonas();
        sistema.leerInscripciones();
        sistema.menu();
    }
    
}
