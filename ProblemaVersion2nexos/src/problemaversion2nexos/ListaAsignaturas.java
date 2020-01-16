
package problemaversion2nexos;

public class ListaAsignaturas {
    private NodoAsignatura firstAsignatura;
    private NodoAsignatura lastAsignatura;

    public ListaAsignaturas() {
        this.firstAsignatura = null;
        this.lastAsignatura = null;
    }

    public NodoAsignatura getFirstAsignatura() {
        return firstAsignatura;
    }

    public void setFirstAsignatura(NodoAsignatura firstAsignatura) {
        this.firstAsignatura = firstAsignatura;
    }

    public NodoAsignatura getLastAsignatura() {
        return lastAsignatura;
    }

    public void setLastAsignatura(NodoAsignatura lastAsignatura) {
        this.lastAsignatura = lastAsignatura;
    }
    public void ingresarAsignatura(Asignatura A){
        NodoAsignatura nuevo = new NodoAsignatura(A);
        if(firstAsignatura == null){
            firstAsignatura = nuevo;
            lastAsignatura = nuevo;
        }else{
            nuevo.setNextAsignatura(firstAsignatura);
            firstAsignatura.setPrevAsignatura(nuevo);
            nuevo.setPrevAsignatura(null);
            firstAsignatura =nuevo;
        }
    }
    public Asignatura buscarAsignatura(String codigo){
        NodoAsignatura actual = firstAsignatura;
        while(actual !=null && !actual.getAsignatura().getCodigo().equalsIgnoreCase(codigo)){
            actual = actual.getNextAsignatura();
        }
        if(actual !=null){
            return actual.getAsignatura();
        }else{
            return null;
        }
    }
}
