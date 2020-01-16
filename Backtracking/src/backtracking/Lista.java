/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author Usuario
 */
public interface Lista extends Coleccion {       
    public boolean agregar(int posicion, Elemento e);
    public int posicionDe(Elemento e);
    public Elemento eliminar(int posicion);
    public Elemento reemplazar(int posicion, Elemento e);
    public Lista subLista(int desde, int hasta);
}
