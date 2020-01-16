/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apparbolbinario;

/**
 *
 * @author featz
 */
public class NodoDoble {
    
    public int elemento;
    public NodoDoble right;
    public NodoDoble left;
    public int key;
    
    public NodoDoble(int e){
        elemento = e;
        key = e;
        right=null;
        left=null;
    }
    
}
