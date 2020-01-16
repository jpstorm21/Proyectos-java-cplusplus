package problema;

public class ListaAsignaturas {
    private NodoAsignatura primerAsignatura;
    private NodoAsignatura lastAsignatura;
    
    public ListaAsignaturas(){
        primerAsignatura = null;
        lastAsignatura = null;
    } 
    public NodoAsignatura getPrimerAsignatura(){
        return primerAsignatura;
    }
    public void setPrimerAsignatura(NodoAsignatura N){
        this.primerAsignatura = N;
    }

    public NodoAsignatura getLastAsignatura() {
        return lastAsignatura;
    }

    public void setLastAsignatura(NodoAsignatura lastAsignatura) {
        this.lastAsignatura = lastAsignatura;
    }
    
    public void insertarAsignaturaAlinicio(Asignatura A){
        NodoAsignatura nuevoNodo = new NodoAsignatura(A);
        if(primerAsignatura == null){
            primerAsignatura = nuevoNodo;
            lastAsignatura = nuevoNodo;
        }else{
            nuevoNodo.setSiguienteAsignatura(primerAsignatura);
            primerAsignatura.setPrevioAsignatura(nuevoNodo);
            nuevoNodo.setPrevioAsignatura(null);
            primerAsignatura = nuevoNodo;
        }
    }
    public Asignatura buscarAsignatura(String codigo){
        NodoAsignatura actual = primerAsignatura;
        while(actual != null && !actual.getAsignatura().getCodigo().equalsIgnoreCase(codigo)){
            actual = actual.getSiguienteAsignatura();
        }
        if(actual != null){
            return actual.getAsignatura();
        }else{
            return null;
        }
    }
   

}
