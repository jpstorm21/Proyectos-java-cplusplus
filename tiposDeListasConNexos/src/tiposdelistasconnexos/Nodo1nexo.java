
package tiposdelistasconnexos;


public class Nodo1nexo {
    private Nodo1nexo next;
    private Empleado empleado;

    public Nodo1nexo(Empleado E) {
        this.next = null;
        this.empleado = E;
    }

    public Nodo1nexo getNext() {
        return next;
    }

    public void setNext(Nodo1nexo next) {
        this.next = next;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    
}
