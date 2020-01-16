/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author Usuario
 */
public interface Coleccion {
    public boolean agregar(Elemento e);
    public void limpiar();
    public boolean contiene(Elemento e);
    public boolean esIgual(Coleccion c);
    public boolean esVacia();
    public boolean eliminar(Elemento e);
    public int tamanio();
    public Elemento[] toArray();    
}
