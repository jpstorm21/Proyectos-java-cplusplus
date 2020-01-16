package problema;

public class NodoCarrera {
    private Carrera carrera;
    private NodoCarrera siguienteCarrera;
    private NodoCarrera previoCarrera;
    public NodoCarrera(Carrera C){
        this.carrera = C;
        siguienteCarrera = null;
        previoCarrera = null;
    }
    public Carrera getCarrera() {
        return carrera;
    }
    public void setCarrera(Carrera C) {
        this.carrera = C;
    }
    public NodoCarrera getSiguienteCarrera() {
        return siguienteCarrera;
    }
    public void setSiguienteCarrera(NodoCarrera N) {
        this.siguienteCarrera = N;
    }

    public NodoCarrera getPrevioCarrera() {
        return previoCarrera;
    }

    public void setPrevioCarrera(NodoCarrera N) {
        this.previoCarrera = N;
    }
    

}
