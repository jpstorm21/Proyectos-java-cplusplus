
/**
 *
 * @author Eduardo
 */
public class App {

  
    public static void main(String[] args) {
          
      tableroBacktracking l = new tableroBacktracking(5, 5, 0, 0, 4, 4);
        // rellenar tablero de forma aleatoria
        for (int i=0;i<5; i++) {
            for (int j=0; j<5; j++) {
                if (Math.random()>0.8 && i!=0 && j!=0)
                    l.addPared(i,j);
            }
        }
             
       
       System.out.println("Tablero inicial");
       System.out.println("---------------------------------------");
       l.imprimirTablero();
       
       l.resolverLaberinto();
       
       System.out.println("Tablero final");
       System.out.println("----------------------------------------");
       l.imprimirTablero();
       
    }
    
}
