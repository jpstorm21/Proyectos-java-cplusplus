
package apptarea;

public class ListaProfesores {
    private NodoProfesor firstProfesor;

    public ListaProfesores(){
        firstProfesor = null;
    }
    public NodoProfesor getFirstProfesor(){
        return firstProfesor;
    }
    public int cantProfesores(){
        int contador = 0;
        NodoProfesor actual = firstProfesor;
        while(actual != null){
            actual.getNextProfesor();
            contador++;
        }
        return contador;
    }
    public void ingresarProfesor(Profesor P){
        NodoProfesor nuevonodo = new NodoProfesor(P);
        nuevonodo.setNextProfesor(firstProfesor);
        firstProfesor = nuevonodo;
    }
    public Profesor buscarProfesor(String rut){
        NodoProfesor actual = firstProfesor;
        while(actual != null && !actual.getProfesor().getRut().equalsIgnoreCase(rut)){
            actual = actual.getNextProfesor();
        }
        if( actual != null){
            return actual.getProfesor();
        }else{
            return null;
        }
    }
    
    
    
}

