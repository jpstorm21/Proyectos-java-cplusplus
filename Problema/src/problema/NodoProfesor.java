package problema;

public class NodoProfesor {
    private Profesor profesor;
    private NodoProfesor siguienteProfesor;
    private NodoProfesor previoProfesor;
    
    public NodoProfesor(Profesor P){
        this.profesor = P;
        siguienteProfesor = null;
        previoProfesor = null;
    }
    public Profesor getProfesor(){
        return profesor;
    }
    public void setProfesor(Profesor P){
        this.profesor = P;
    }
    public NodoProfesor getSiguienteProfesor(){
        return siguienteProfesor;
    }
    public void setSiguienteProfesor(NodoProfesor N){
        this.siguienteProfesor = N;
    }    

    public NodoProfesor getPrevioProfesor() {
        return previoProfesor;
    }

    public void setPrevioProfesor(NodoProfesor previoProfesor) {
        this.previoProfesor = previoProfesor;
    }
    
    
}
