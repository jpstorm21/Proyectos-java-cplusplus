
package lunes23.pkg10.pkg2017;

public class ListaEmpleados {

    private NodoEmpleado first;
    private NodoEmpleado last;

    public ListaEmpleados() {
        this.first = null;
        this.last = null;
    }

    public NodoEmpleado getFirst() {
        return first;
    }

    public void setFirst(NodoEmpleado first) {
        this.first = first;
    }

    public NodoEmpleado getLast() {
        return last;
    }

    public void setLast(NodoEmpleado last) {
        this.last = last;
    }

    public void ingresarEmpleado(Empleado E) {
        NodoEmpleado nuevo = new NodoEmpleado(E);
        if (first == null) {
            first = nuevo;
            last = nuevo;
        }else{
            nuevo.setNext(first);
            first.setPrev(nuevo);
            first = nuevo;         
        }
    }
    public Empleado buscarEmpleado(String rut){
        NodoEmpleado actual = first;
        while(actual != null && !actual.getEmpleado().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNext();
        }
        if(actual != null){
            return actual.getEmpleado();
        }else{
            return null;
        }
    }
    public boolean eliminarEmpleado(String rut){
        NodoEmpleado actual = first;
        while(actual != null && !actual.getEmpleado().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNext();
        }
        if(actual !=null){
            if(actual ==first){
                first = first.getNext();
            }else if(actual == last){
                last = last.getPrev();
            }else{
                actual.getPrev().setNext(actual.getNext());
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        }else{
            return false;
        }
    }

}
