
package tareanodos;

public class NodoTelefono {
    
    private NodoTelefono nextTelefono;
    private Telefono telefono;
    
    public NodoTelefono(Telefono T){
        this.telefono= T;
        nextTelefono = null;
    }

    public NodoTelefono getNextTelefono() {
        return nextTelefono;
    }

    public void setNextTelefono(NodoTelefono nextTelefono) {
        this.nextTelefono = nextTelefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
}
