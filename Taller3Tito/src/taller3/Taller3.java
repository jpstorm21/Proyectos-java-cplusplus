
package taller3;

import java.io.FileNotFoundException;

public class Taller3 {

    public static void main(String[] args) throws FileNotFoundException {
      Interface Sistema =new SistemaTaller3();
      Sistema.leerPersonas();
      Sistema.leerCreditos();
      Sistema.menu();
    }
    
}
