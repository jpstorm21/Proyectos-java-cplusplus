
package apptarea;

public class NodoAsignatura {
    private Asignatura asignatura;
    private NodoAsignatura nextAsignatura;
    private 
    public NodoAsignatura(Asignatura A){
        this.asignatura = A;
        nextAsignatura = null;
    }
    public Asignatura getAsignatura(){
        return asignatura;
    }
    public NodoAsignatura getNextAsignatura(){
        return nextAsignatura;
    }
    public void setNextAsignatura(NodoAsignatura N){
        this.nextAsignatura = N;
    }
}
