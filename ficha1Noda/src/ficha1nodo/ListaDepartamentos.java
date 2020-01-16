
package ficha1nodo;

public class ListaDepartamentos {
    private NodoDepto firstDepto;
   
    public ListaDepartamentos() {
        firstDepto = null;
    }

   
    public void ingresarDepto(Departamento D){
        NodoDepto nuevoNodo = new NodoDepto(D);
        nuevoNodo.setNextDepto(firstDepto);
        firstDepto = nuevoNodo;
        
    }

    public NodoDepto getFirstDepto() {
        return firstDepto;
    }
    
    
}
