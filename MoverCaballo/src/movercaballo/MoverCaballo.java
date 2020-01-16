/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movercaballo;


public class MoverCaballo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Backtracking b = new Backtracking(7,0,0);
        b.imprimir(b.solve());
    }
}
