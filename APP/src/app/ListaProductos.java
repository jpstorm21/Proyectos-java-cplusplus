
package app;


public class ListaProductos {
    private NodoProducto primero;
    private NodoProducto ultimo;

    public ListaProductos() {
    }

    public NodoProducto getPrimero() {
        return primero;
    }

    public void setPrimero(NodoProducto primero) {
        this.primero = primero;
    }

    public NodoProducto getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoProducto ultimo) {
        this.ultimo = ultimo;
    }
    
    public void IngresarProducto(Producto p){
        NodoProducto nuevo = new NodoProducto(p);
        if(primero == null){
            primero = nuevo;
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setPrevio(ultimo);
        }
        ultimo = nuevo;
    }
    
    public Producto BuscarProducto(int codigo){
        NodoProducto actual = primero;
        while(actual != null && actual.getProducto().getCodigo() != codigo){
            actual = actual.getSiguiente();
        }
        if(actual != null){
            return actual.getProducto();
        }else{
            return null;
        }
    }
    
    //No se pide en el ejercicio pero dejo el codigo igual
    public boolean EliminarProducto(int codigo){
        NodoProducto actual=primero;
        NodoProducto previo= null;
        
        while(actual!=null && actual.getProducto().getCodigo() != codigo){
            previo=actual;
            actual=actual.getSiguiente();
        }
        
        if(actual!=null){
            if(primero == ultimo){
                primero = null;
                ultimo = null;
            }else{
                if(actual == primero){
                    primero = actual.getSiguiente();
                    primero.setPrevio(null);
                }else{
                    if(actual == ultimo){
                        ultimo = previo;
                        ultimo.setSiguiente(null);
                    }else{
                        previo.setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setPrevio(previo);
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarUltimo(){
        if(ultimo == null){
            return false;
        }else{
            if(ultimo.getPrevio() == null){
                ultimo = null;
            }else{
                ultimo = ultimo.getPrevio();
            }
        }
        return true;
    }
}
