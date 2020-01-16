package ejerciciosrecursion;

/**
 *
 * @author Fabian
 */
public class EjerciciosRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Suma s = new Suma ();
        
        System.out.println ("suma con metodo normal: "+s.sumaNormal(s.l));
        
        System.out.println ("suma con metodo de recursion: "+s.sumaRecursiva(s.l, 0));
    }
}
