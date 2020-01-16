/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appbacktrackingcaballo;

/**
 *
 * @author Juan
 */
public class AppBacktrackingCaballo {

    public static void main(String[] args) {
        // TODO code application logic here
       Backtracking b = new Backtracking(4,0,0);
       b.imprimir(b.solve());
    }
}

