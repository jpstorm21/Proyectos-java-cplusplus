
package tareanodos;

public class ListaTelefonos {
    private NodoTelefono firstTelefono;

    public ListaTelefonos() {
        firstTelefono = null;
    }

    public NodoTelefono getFirstTelefono() {
        return firstTelefono;
    }

    public void setFirstTelefono(NodoTelefono firstTelefono) {
        this.firstTelefono = firstTelefono;
    }
    public void ingresarTelefono(Telefono T){
        NodoTelefono nuevo = new NodoTelefono(T);
        if(firstTelefono == null){
            firstTelefono = nuevo;
        }else{
            nuevo.setNextTelefono(firstTelefono);
            firstTelefono = nuevo;
        }
    }
    public Telefono buscarTelefono(int fono){
        NodoTelefono actual = firstTelefono;
        while(actual != null && actual.getTelefono().getFono() != fono){
            actual = actual.getNextTelefono();
        }
        if(actual != null){
            return actual.getTelefono();
        }else{
            return null;
        }
        
    }
    public boolean eliminarTelefono(int fono){
        NodoTelefono actual = firstTelefono;
        NodoTelefono prev = firstTelefono;
        while(actual != null && actual.getTelefono().getFono() != fono){
            prev =actual;
            actual = actual.getNextTelefono();
        }
        if( actual != null){
            if(actual == firstTelefono){
                firstTelefono = firstTelefono.getNextTelefono();
        }else{
            prev.setNextTelefono(actual.getNextTelefono());
        }
        return true;
    }else{
            return false;
        }
    }
    
}
