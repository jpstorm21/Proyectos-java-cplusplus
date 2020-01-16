
package problemaversion2nexos;

public class NodoAsignatura {
    private NodoAsignatura nextAsignatura;
    private NodoAsignatura prevAsignatura;
    private Asignatura asignatura;

    public NodoAsignatura(Asignatura A) {
        this.nextAsignatura = null;
        this.prevAsignatura = null;
        this.asignatura = A;
    }

    public NodoAsignatura getNextAsignatura() {
        return nextAsignatura;
    }

    public void setNextAsignatura(NodoAsignatura nextAsignatura) {
        this.nextAsignatura = nextAsignatura;
    }

    public NodoAsignatura getPrevAsignatura() {
        return prevAsignatura;
    }

    public void setPrevAsignatura(NodoAsignatura prevAsignatura) {
        this.prevAsignatura = prevAsignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
}
