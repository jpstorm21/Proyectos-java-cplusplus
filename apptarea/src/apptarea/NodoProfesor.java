
package apptarea;

public class NodoProfesor {
    private Profesor profesor;
    private NodoProfesor nextProfesor;
    private NodoProfesor prevProfesor;
    public NodoProfesor(Profesor P){
        this.profesor = P;
        nextProfesor = null;
        prevProfesor = null;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public NodoProfesor getNextProfesor() {
        return nextProfesor;
    }

    public void setNextProfesor(NodoProfesor N) {
        this.nextProfesor = N;
    }

    public NodoProfesor getPrevProfesor() {
        return prevProfesor;
    }

    public void setPrevProfesor(NodoProfesor prevProfesor) {
        this.prevProfesor = prevProfesor;
    }
    
    
}
