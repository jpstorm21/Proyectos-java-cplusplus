
package problemaversion2nexos;

public class NodoProfesor {
    private NodoProfesor nextProfesor;
    private NodoProfesor prevProfesor;
    private Profesor profesor;

    public NodoProfesor(Profesor P) {
        this.nextProfesor = null;
        this.prevProfesor = null;
        this.profesor = P;
    }

    public NodoProfesor getNextProfesor() {
        return nextProfesor;
    }

    public void setNextProfesor(NodoProfesor nextProfesor) {
        this.nextProfesor = nextProfesor;
    }

    public NodoProfesor getPrevProfesor() {
        return prevProfesor;
    }

    public void setPrevProfesor(NodoProfesor prevProfesor) {
        this.prevProfesor = prevProfesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
