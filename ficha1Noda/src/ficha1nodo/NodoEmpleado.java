
package ficha1nodo;

public class NodoEmpleado {
    private Empleado empleado;
    private NodoEmpleado nextEmpleado;

    public NodoEmpleado(Empleado E) {
        this.empleado = E;
        nextEmpleado = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NodoEmpleado getNextEmpleado() {
        return nextEmpleado;
    }

    public void setNextEmpleado(NodoEmpleado n) {
        this.nextEmpleado = n;
    }
    
    
}
