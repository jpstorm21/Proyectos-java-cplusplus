
package problemaversion2nexos;

public class NodoCarrera {
    private NodoCarrera nextCarrera;
    private NodoCarrera prevCarrera;
    private Carrera carrera;

    public NodoCarrera(Carrera C) {
        this.nextCarrera = null;
        this.prevCarrera = null;
        this.carrera = C;
    }

    public NodoCarrera getNextCarrera() {
        return nextCarrera;
    }

    public void setNextCarrera(NodoCarrera nextCarrera) {
        this.nextCarrera = nextCarrera;
    }

    public NodoCarrera getPrevCarrera() {
        return prevCarrera;
    }

    public void setPrevCarrera(NodoCarrera prevCarrera) {
        this.prevCarrera = prevCarrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
