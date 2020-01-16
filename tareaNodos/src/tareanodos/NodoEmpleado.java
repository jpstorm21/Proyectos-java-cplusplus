
package tareanodos;

public class NodoEmpleado {
    private Empleado empleado;
    private NodoEmpleado nextEmpleado;
    private NodoEmpleado prevEmpleado;

    public NodoEmpleado(Empleado E) {
        this.empleado = E;
        nextEmpleado =  null;
        prevEmpleado = null;
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

    public void setNextEmpleado(NodoEmpleado nextEmpleado) {
        this.nextEmpleado = nextEmpleado;
    }

    public NodoEmpleado getPrevEmpleado() {
        return prevEmpleado;
    }

    public void setPrevEmpleado(NodoEmpleado prevEmpleado) {
        this.prevEmpleado = prevEmpleado;
    }

   
    
    
}
