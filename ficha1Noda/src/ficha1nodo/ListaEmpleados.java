
package ficha1nodo;


public class ListaEmpleados {
    private NodoEmpleado firstEmpleado;
    private Empleado [] le;
    
    public ListaEmpleados(int max) {
        firstEmpleado = null;
        le = new Empleado[max];
    }

    public void ingresarEmpleado(Empleado E){
        NodoEmpleado nuevoNodo = new NodoEmpleado(E);
        nuevoNodo.setNextEmpleado(firstEmpleado);
        firstEmpleado = nuevoNodo;
    }

    public NodoEmpleado getFirstEmpleado() {
        return firstEmpleado;
    }
    public boolean buscarEmpleado(String rut){
        NodoEmpleado current = firstEmpleado;
        while(!current )
    }
    
    
            
}
