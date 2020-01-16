package ficha1;

public class ListaEmpleados {
    private NodoEmpleado firstEmpleado;
    
    public ListaEmpleados(){
        firstEmpleado = null;
    }
    public void insertarEmpleado(Empleado E){
        NodoEmpleado nuevoNodo = new NodoEmpleado(E);
        nuevoNodo.setSiguienteEmpleado(firstEmpleado);
        firstEmpleado = nuevoNodo;
    }
    
    public NodoEmpleado getFirstEmpleado(){
        return firstEmpleado;
    }  
    public int cantDepartamentos(){
        NodoEmpleado actual = firstEmpleado;
        int contador = 0;
        while(actual != null){
            actual = actual.getSiguienteEmpleado();
            contador++;           
        }
        return contador;
    }
    
    public Empleado encontrarEmpleado(String rut){
        NodoEmpleado actual = firstEmpleado;
        while(actual != null && !actual.getEmpleado().getRut().equalsIgnoreCase(rut)){
            actual = actual.getSiguienteEmpleado();          
        }
        if(actual != null){
            return actual.getEmpleado();
        }else{
            return null;
        }
    }
}
