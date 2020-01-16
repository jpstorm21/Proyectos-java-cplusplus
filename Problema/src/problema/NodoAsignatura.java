package problema;

public class NodoAsignatura {
    private Asignatura asignatura;
    private NodoAsignatura siguienteAsignatura;
    private NodoAsignatura previoAsignatura;
    
    public NodoAsignatura(Asignatura A){
        this.asignatura = A;
        siguienteAsignatura = null;
        previoAsignatura = null;
    }
    public Asignatura getAsignatura(){
        return asignatura;
    }
    public void setAsignatura(Asignatura A){
        this.asignatura = A;
    }
    public NodoAsignatura getSiguienteAsignatura(){
        return siguienteAsignatura;
    }
    public void setSiguienteAsignatura(NodoAsignatura N){
        this.siguienteAsignatura = N;
    }
    public NodoAsignatura getPrevioAsignatura(){
        return previoAsignatura;
    }
    public void setPrevioAsignatura(NodoAsignatura N){
        this.previoAsignatura = N;
    }
}
