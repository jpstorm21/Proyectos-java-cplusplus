/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;
import ucn.StdOut;

public class ListaNexoSimple implements Lista {

    private NodoElemento start;
    private NodoElemento end;
    private int cant;
    
    public ListaNexoSimple(){
        start=null;
        end=null;
        cant=0;
    }
    
    public boolean agregar(Elemento e){
        NodoElemento aux = new NodoElemento(e);
        aux.siguiente=null;
        if (start == null){
            start = aux;
            end = aux;
        } else {
            end.siguiente = aux;
            end = aux;                
        }        
        cant++;
        return true;
    }

    public void limpiar(){
    }
    
    public boolean contiene(Elemento e){
         NodoElemento aux = start;        
         while (aux!=null) {
             if (aux.elemento.equals(e))
                 return true;
             aux = aux.siguiente;
         }         
         return false;       
    }

    public boolean esIgual(Coleccion c){
        return true;               
    }
    
    public boolean esVacia() {
        if (start==null)
            return true;
        else
            return false;
    }

    public boolean eliminar(Elemento e){
/*         NodoElemento aux = start;        
         while (aux.siguiente!=null) {
             if (aux.siguiente.elemento.equals(e)) {
                 aux.siguiente = aux.siguiente.siguiente;
                 break;
             }
             aux = aux.siguiente;
         }         */
         return true;               
    }
    
    public int tamanio(){
        return cant;
    }
   
    public Elemento[] toArray(){
        Elemento[] le = new Elemento[cant];
        for (int i=0;i<cant;i++){
            le[i] = start.elemento;
            start=start.siguiente;
        }
        return le;
    }
    
    public boolean agregar(int posicion, Elemento e){
        if ((posicion<=cant && posicion>=0) || (posicion==0 && cant==0)) {
            NodoElemento ne = new NodoElemento(e);
            if (posicion==0) {
                StdOut.println("(1)" + start);                       
                ne.siguiente=start;              
                start = ne;
                cant++;
            } else {
                StdOut.println("(2)");
                NodoElemento aux = start;
                for (int i=0; i<posicion-1; i++){
                    StdOut.println(">"+i+":"+aux);
                    aux = aux.siguiente;
                }
                ne.siguiente = aux.siguiente;
                aux.siguiente = ne;      
                cant++;
            }    
                        
            if (posicion == cant-1) {
                StdOut.println(posicion+"/"+cant+"/"+end);
                end = ne;
            }
            
            return true;
        } 
        return false;
    }
    
    public int posicionDe(Elemento e){
        return -1;                       
    }
    
    public Elemento get(int posicion){
        NodoElemento aux = start;
        
        if (posicion<cant){
            for (int i = 0; i<=posicion-1 && aux.siguiente!=null; i++)
                aux=aux.siguiente;
            return aux.elemento;
        }
        return null;
    }
    
    
    
    public Elemento eliminar(int posicion){
        return null;
    }
    
    public Elemento reemplazar(int posicion, Elemento e){
        return null;
    }
    
    public Lista subLista(int desde, int hasta){    
        return null;
    }
}