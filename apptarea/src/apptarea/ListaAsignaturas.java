
package apptarea;

public class ListaAsignaturas {
    
    private NodoAsignatura firstAsignatura;
    
    public ListaAsignaturas(){
        firstAsignatura = null;
    }
    public NodoAsignatura getFirstAsignatura(){
        return firstAsignatura;
    }
    public void ingresarAsignatura(Asignatura A){
        NodoAsignatura nuevonodo = new NodoAsignatura(A);
        nuevonodo.setNextAsignatura(firstAsignatura);
        firstAsignatura = nuevonodo;
    }
    public int cantAsignatura(){
        NodoAsignatura actual = firstAsignatura;
        int contador = 0;
        while(actual != null){
            actual = actual.getNextAsignatura();
           contador++;
        }
        return contador;
    }
    public Asignatura buscarAsignatura(String codigo){
        NodoAsignatura actual = firstAsignatura;
        while(actual != null && !actual.getAsignatura().getCodigo().equalsIgnoreCase(codigo)){
            actual = actual.getNextAsignatura();
        }
        if( actual !=null){
            return actual.getAsignatura();
        }else{
            return null;
        }
    }

   
    
    
}